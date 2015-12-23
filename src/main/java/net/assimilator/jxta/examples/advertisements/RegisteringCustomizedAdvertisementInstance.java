/*
 * Copyright (c) 2015 Nebarti, LLC. All rights reserved.
 *
 * based on work from DawningStreams, Inc. 2010
 *
 */
package net.assimilator.jxta.examples.advertisements;

import net.assimilator.jxta.tools.Tools;
import net.jxta.document.AdvertisementFactory;

public class RegisteringCustomizedAdvertisementInstance {
    
    public static final String Name = "Example_510";

    public static void main(String[] args) {
        
        // Registering our customized advertisement instance
        AdvertisementFactory.registerAdvertisementInstance(
                CustomizedAdvertisement.getAdvertisementType(),
                new CustomizedAdvertisement.Instantiator());
        
        // Notifying the user
        Tools.PopInformationMessage(Name, "Registered in Advertisement Factory:\n\n"
                + CustomizedAdvertisement.getAdvertisementType());
        
    }

}
