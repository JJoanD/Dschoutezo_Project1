package com.example1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringModifica = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi(){
        try{
            System.out.println("1 SERVER partito in esecuzione");
            server = new ServerSocket(6782);

            client = server.accept();
            
            server.close();
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica(){
        try{
            System.out.println("3 benvenuto client , scrivi una frase e la trasformo in maiuscolo.Attendo");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("6 ricevuta la stringa dal cliente: " + stringaRicevuta);
            stringModifica = stringaRicevuta.toUpperCase();
            System.out.println("7 invio la string modificata al client ");
            outVersoClient.writeBytes(stringModifica+"/n");
            System.out.println("9 SERVER : fine elaborazione");
            client.close();
        }catch(Exception e){};
    }
}
