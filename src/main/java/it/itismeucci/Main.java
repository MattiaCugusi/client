package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client e' partito");
        Socket mySocket = new Socket("localhost", 5673);
        System.out.println("il client si e' collegato");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
        
        out.writeBytes("prova collegamento \n");

        String stringaRicevuta = in.readLine();

        System.out.println(stringaRicevuta);

        mySocket.close();

    }
} 