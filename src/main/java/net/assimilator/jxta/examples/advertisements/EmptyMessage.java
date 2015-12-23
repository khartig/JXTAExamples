/*
 * Copyright (c) 2015 Nebarti, LLC. All rights reserved.
 *
 * based on work from DawningStreams, Inc. 2010
 *
 */
package net.assimilator.jxta.examples.advertisements;

import net.assimilator.jxta.tools.Tools;
import net.jxta.endpoint.Message;

public class EmptyMessage {
    
    public static final String Name = "Example_400";
    
    public static void main(String[] args) {

        Message MyMessage = new Message();
        Tools.DisplayMessageContent(Name, MyMessage);
        
    }
        
}
