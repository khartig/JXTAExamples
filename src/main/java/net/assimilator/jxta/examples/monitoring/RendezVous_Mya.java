/*
 * Copyright (c) 2015 Nebarti, LLC. All rights reserved.
 *
 * Based on work from DawningStreams, Inc. 2010
 *
 */
package net.assimilator.jxta.examples.monitoring;

import net.jxta.exception.PeerGroupException;
import net.jxta.id.IDFactory;
import net.jxta.peer.PeerID;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupID;
import net.jxta.platform.NetworkConfigurator;
import net.jxta.platform.NetworkManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Simple RENDEZVOUS peer connecting via the NetPeerGroup.
 */
public class RendezVous_Mya {

    // Static

    public static final String Name_RDV = "RENDEZVOUS";
    public static final PeerID PID_RDV = IDFactory.newPeerID(PeerGroupID.defaultNetPeerGroupID, Name_RDV.getBytes());
    public static final int TcpPort_RDV = 9711;
    public static final File ConfigurationFile_RDV = new File("." + System.getProperty("file.separator") + Name_RDV);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            // Removing any existing configuration?
            NetworkManager.RecursiveDelete(ConfigurationFile_RDV);

            // Creation of the network manager
            final NetworkManager myNetworkManager = new NetworkManager(
                    NetworkManager.ConfigMode.RENDEZVOUS,
                    Name_RDV, ConfigurationFile_RDV.toURI());

            // Retrieving the network configurator
            NetworkConfigurator myNetworkConfigurator = myNetworkManager.getConfigurator();

            // Setting Configuration
            myNetworkConfigurator.setUseMulticast(false);

            myNetworkConfigurator.setTcpPort(TcpPort_RDV);
            myNetworkConfigurator.setTcpEnabled(true);
            myNetworkConfigurator.setTcpIncoming(true);
            myNetworkConfigurator.setTcpOutgoing(true);

            // Setting the Peer ID
            myNetworkConfigurator.setPeerID(PID_RDV);

            // Starting the JXTA network
            PeerGroup NetPeerGroup = myNetworkManager.startNetwork();

            // Starting the connectivity monitor
            new ConnectivityMonitor(NetPeerGroup);

            // Stopping the network asynchronously
            ConnectivityMonitor.TheExecutor.schedule(
                    new DelayedJxtaNetworkStopper(
                            myNetworkManager,
                            "Click to stop " + Name_RDV,
                            "Stop"),
                    0,
                    TimeUnit.SECONDS);

        } catch (IOException Ex) {

            System.err.println(Ex.toString());

        } catch (PeerGroupException Ex) {

            System.err.println(Ex.toString());

        }

    }

}
