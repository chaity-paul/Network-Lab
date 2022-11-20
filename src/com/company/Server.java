package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Server connected");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                Object cmsg = ois.readObject();
                System.out.println("From Client : "+(String)cmsg);
                String smsg = (String)cmsg;
                smsg = smsg.toUpperCase();
                oos.writeObject(smsg);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
