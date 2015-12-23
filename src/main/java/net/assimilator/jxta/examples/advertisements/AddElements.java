/*
 * Copyright (c) 2015 Nebarti, LLC. All rights reserved.
 *
 * based on work from DawningStreams, Inc. 2010
 *
 */
package net.assimilator.jxta.examples.advertisements;

import net.assimilator.jxta.tools.Tools;
import net.jxta.endpoint.Message;
import net.jxta.endpoint.StringMessageElement;

public class AddElements {
    
    public static final String Name = "Example_410";

    public static void main(String[] args) {

        // Creating an empty message
        Message myMessage = new Message();
        
        // Creating string element
        StringMessageElement myStringMessageElement = new StringMessageElement(
                "MyStringElement", "My string message content", null);
        
        // Creating int element
        StringMessageElement myIntMessageElement = new StringMessageElement(
                "MyIntElement", Integer.toString(33), null);
                
        // Creating long element
        StringMessageElement myLongMessageElement = new StringMessageElement(
                "MyLongElement", Long.toString(29345677), null);

        // Adding string message elements
        myMessage.addMessageElement("MyNameSpace", myStringMessageElement);
        myMessage.addMessageElement("MyNameSpace", myIntMessageElement);
        myMessage.addMessageElement("MyNameSpace", myLongMessageElement);
        
        // Displaying message
        Tools.DisplayMessageContent(Name, myMessage);
        
    }
        
}
