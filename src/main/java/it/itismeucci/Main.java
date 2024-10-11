package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client e' partito");
        Socket mySocket = new Socket("localhost", 5673);
        System.out.println("il client si e' collegato");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        String stringaRicevuta;

        do{

        System.out.println("inserire riga:");
        String input = sc.nextLine();
        out.writeBytes(input + "\n");
        stringaRicevuta = in.readLine();
        System.out.println(stringaRicevuta);

        }while(!stringaRicevuta.equals("!"));

        mySocket.close();

    }
} 