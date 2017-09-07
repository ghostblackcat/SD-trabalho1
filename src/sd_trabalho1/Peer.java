/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sd_trabalho1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Peer {
    
    private int chosen;
    private int concrete_purchase;
    public int reputation;
    public String argsP;
    public int port;
    public boolean isIndex;
    
   
    public Peer(String args, int randomPort){
        argsP = args;
        port = randomPort;
        reputation = 5;
        isIndex = false;
    }
   
    public void sendMessage(){
    MulticastSocket s =null;

        try {
            InetAddress group = InetAddress.getByName(argsP);
            s = new MulticastSocket(6789);
            s.joinGroup(group);

            MessageReceiver receiver = new MessageReceiver(s);
            MessageSender sender = new MessageSender(s, group);
            Thread threadReceive = new Thread(receiver);
            Thread threadSend = new Thread(sender);
            threadReceive.start();
            threadSend.start();
            
            /*System.out.println("Mensagem (pressione enter para enviar): ");
            Scanner scanner = new Scanner(System.in);
            String newMessage = scanner.nextLine();
            String end = new String("sair");*/
            
            
            //byte [] m = newMessage.getBytes();
            //DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);

            /*while(!newMessage.equals(end)){
                byte [] m = newMessage.getBytes();
                DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
                try {
                    s.send(messageOut);
                } catch (IOException ex) {

                }
                System.out.println("Mensagem (pressione enter para enviar): ");
                newMessage = scanner.nextLine();
            }*/
            
            
            //if(sender.stop == true){
               // threadSend.stop();
                //threadReceive.stop();
                //s.leaveGroup(group);
            //}

        }catch (SocketException e){System.out.println("Socket: " + e.getMessage());
        }catch (IOException e){System.out.println("IO: " + e.getMessage());
        }finally {//if(s != null) s.close();
            
        }}
        
    
    public void calculateReputation(){
        reputation = 5*concrete_purchase/chosen;
    }
    
    public void sendProducts(){
        
    
    }
    
    public void election(){
        
    }
    
}



//eleição
//criptografia
//anunciar disponibilidade do indexador: multicast
//thread para eleição
//thread para indexador
//


//TCP para threads -> servidor = indexador;
//usar algo para identificar cada tipo de mensagem que pode ser recebida pelo indexador.
//mandar o valor (usado para escolher o indexador) no hello
//hashmap para os processos -> id-processo, para fazer eleições
//quando um novo par entra, o id dele vai para a tabela (hashmap)
//thread para escutar
//thread para enviar (o hello)
//enviar o hello (para todo o grupo) toda vez que receber algum, para permitir que todos se conheçam


//cada peer terá uma thread para escutar as mensagens dos outros peers, criará uma tabela