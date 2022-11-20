package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started...");
        Socket socket = new Socket("localhost",3333);
        System.out.println("Client Connected...");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        oos.writeObject(msg);
        try {
            Object smsg = ois.readObject();
            System.out.println("From Server : "+(String)smsg);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
