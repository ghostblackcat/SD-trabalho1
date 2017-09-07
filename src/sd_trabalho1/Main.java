/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_trabalho1;

/**
 *
 * @author CarolPeSena
 */
import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Random x = new Random();
        int randomPort = x.nextInt(6975) + 1025;
        
        Peer newPeer = new Peer(args[0],randomPort);
        System.out.println("Novo Peer criado");
        newPeer.sendMessage();
    }
}
