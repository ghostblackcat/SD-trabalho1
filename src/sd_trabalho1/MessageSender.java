/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_trabalho1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CarolPeSena
 */
public class MessageSender implements Runnable {
 
    private MulticastSocket socket;
    private InetAddress groupSender;
    public boolean stop;
    public MessageSender(MulticastSocket s, InetAddress group){
	socket = s;
        groupSender = group;
        stop = false;
    }
    
    
    public void run(){
        
        System.out.println("Sending");
        
        System.out.println("Mensagem (pressione enter para enviar): ");
        Scanner scanner = new Scanner(System.in);
        String newMessage = scanner.nextLine();
        String end = new String("sair");
        
        
        while(!newMessage.equals(end)){
            byte [] m = newMessage.getBytes();
            DatagramPacket messageOut = new DatagramPacket(m, m.length, groupSender, 6789);
            try {
                socket.send(messageOut);
            } catch (IOException ex) {

            }
            System.out.println("Mensagem (pressione enter para enviar): ");
            newMessage = scanner.nextLine();
        }
        stop = true;
    }
}
