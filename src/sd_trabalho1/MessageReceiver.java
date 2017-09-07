/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_trabalho1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

/**
 *
 * @author CarolPeSena
 */
public class MessageReceiver implements Runnable{
    
    private MulticastSocket socket;
    public MessageReceiver(MulticastSocket s){
	socket = s;
    }
    
    
    public void run(){
        
        System.out.println("Receiving");
        
        while(true){
            byte[] buffer = new byte[1000];

            DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);

            try{
                socket.receive(messageIn);
                /*System.out.println(messageIn.getLength());
                if(messageIn.getLength() > 0)*/
                    System.out.println("Received:" + new String(messageIn.getData()));
            }
            catch(IOException e){
                System.out.println("Erro de recepção"+e);
            }
            
        }
    }
    
}
