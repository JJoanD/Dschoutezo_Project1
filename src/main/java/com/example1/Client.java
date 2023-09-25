package com.example1;

import java.io.*;
import java.net.*;

/**
 * Hello world!
 * 
 */
public class Client 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    String nomeServer = "nomeServer";
    int portaServer = 6789;
    Socket mioSocket;
    DataInputStream in;
    DataOutputStream out;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    BufferedReader inDalServer;
    


    public Socket connetti(){
      System.out.println("2 CLIENT partito in esecuzione");
    try{
        tastiera = new BufferedReader(new InputStreamReader(System.in));
         mioSocket = new Socket(nomeServer, portaServer);
    }catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Errore durante la connessione");
    }
    }
}
    