/*
 * Copyright (c) 2015 Nebarti, LLC. All rights reserved.
 *
 * Based on work from DawningStreams, Inc. 2010
 *
 */
package net.assimilator.jxta.examples.peersandgroups;

import net.assimilator.jxta.tools.Tools;
import net.jxta.exception.PeerGroupException;
import net.jxta.id.IDFactory;
import net.jxta.peer.PeerID;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupID;
import net.jxta.platform.NetworkConfigurator;
import net.jxta.platform.NetworkManager;

import java.io.IOException;

public class CreatingPeers {

    public static final String Name = "Example_210";

    public static final String PeerName = "Santa Claus de la JXTA";

    public static void main(String[] args) {

        try {

            // Removing any existing configuration
            /// Tools.DeleteConfigurationInDefaultHome();

            // Creation of the network manager
            NetworkManager myNetworkManager = new NetworkManager(
                    NetworkManager.ConfigMode.EDGE, Name);

            // Retrieving the configurator
            NetworkConfigurator myNetworkConfigurator = myNetworkManager.getConfigurator();

            // Setting configuration
            myNetworkConfigurator.setTcpEnabled(true);
            myNetworkConfigurator.setTcpIncoming(true);
            myNetworkConfigurator.setTcpOutgoing(true);
            myNetworkConfigurator.setUseMulticast(false);


            // Creating a new peer
            PeerID myPeerID = IDFactory.newPeerID(PeerGroupID.defaultNetPeerGroupID,
                    PeerName.getBytes());

            Tools.PopInformationMessage(Name, "Creating the Peer ID for: " + PeerName
                    + "\n\n" + myPeerID.toString());

            // Setting peer ID
            myNetworkManager.setPeerID(myPeerID);

            // Starting and stopping the network
            PeerGroup netPeerGroup = myNetworkManager.startNetwork();
            myNetworkManager.stopNetwork();

        } catch (PeerGroupException Ex) {
            Tools.PopErrorMessage(Name, Ex.toString());
        } catch (IOException Ex) {
            Tools.PopErrorMessage(Name, Ex.toString());
        }

    }

}
