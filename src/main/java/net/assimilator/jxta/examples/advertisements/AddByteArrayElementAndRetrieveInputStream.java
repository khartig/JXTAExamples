/*
 * Copyright (c) 2015 Nebarti, LLC. All rights reserved.
 *
 * based on work from DawningStreams, Inc. 2010
 *
 */
package net.assimilator.jxta.examples.advertisements;

import net.assimilator.jxta.tools.Tools;
import java.io.IOException;
import java.io.InputStream;
import net.jxta.document.MimeMediaType;
import net.jxta.endpoint.ByteArrayMessageElement;
import net.jxta.endpoint.Message;
import net.jxta.endpoint.MessageElement;

public class AddByteArrayElementAndRetrieveInputStream {

    public static final String Name = "Example_430";
    
    public static void main(String[] args) {
        
        try {
            
            // Creating byte array and filling it
            byte[] myByteArray = new byte[10];
            
            for (int i = 0; i < myByteArray.length; i++) {
                myByteArray[i] = (byte) i;
            }
            
            Message myMessage = new Message();
            
            ByteArrayMessageElement MyByteArrayMessageElement = new ByteArrayMessageElement("MyByteArrayElement", MimeMediaType.AOS, myByteArray, null);
            myMessage.addMessageElement("MyNameSpace", MyByteArrayMessageElement);
            MessageElement MyElement = myMessage.getMessageElement("MyNameSpace", "MyByteArrayElement");
            
            InputStream  myInputStream = MyElement.getStream();

            int read = myInputStream.read();
            String Result = "";

            while (read != -1) {
                Result = Result + read + " ";
                read = myInputStream.read();
            }
            
            Tools.PopInformationMessage(Name, "Extracted byte array content:\n\n" + Result);
            
        } catch (IOException ex) {
            Tools.PopErrorMessage(Name, ex.toString());
        } 
        
    }
        
}
