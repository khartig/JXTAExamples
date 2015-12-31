/*
 * Copyright (c) 2015 Nebarti, LLC. All rights reserved.
 *
 * based on work from DawningStreams, Inc. 2010
 *  
 */

package net.assimilator.jxta.examples.astrology;

import net.jxta.id.IDFactory;
import net.jxta.impl.id.UUID.ModuleClassID;
import net.jxta.platform.ModuleSpecID;

public class ModuleIDsCreationExample {
    
    public static final String Name = "Example_700";
    
    public static void main(String[] args) {
        
        // Creating a new random module class ID
        ModuleClassID moduleClassID = (ModuleClassID) IDFactory.newModuleClassID();
        
        // Creating a new random module specification ID
        ModuleSpecID moduleSpecID = IDFactory.newModuleSpecID(moduleClassID);
        
        // Printing IDs
        System.out.println(moduleClassID.toURI().toString() + "\n");
        System.out.println(moduleSpecID.toURI().toString() + "\n");

    }
        
}
