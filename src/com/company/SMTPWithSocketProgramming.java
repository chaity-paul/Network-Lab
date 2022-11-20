package com.company;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Base64;

public class SMTPWithSocketProgramming {

    private static DataOutputStream dos;

    public static void main(String[] args) throws Exception {

        int delay = 1000;
        String user = "s1912576125@ru.ac.bd";
        String pass = "19*125*76*125*";
        String username = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("smtp.gmail.com", 465);

        final BufferedReader br = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        dos = new DataOutputStream(sslSocket.getOutputStream());

        send("EHLO smtp.gmail.com\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());

        send("AUTH LOGIN\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send(username + "\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send(password + "\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("MAIL FROM:<s1912576125@ru.ac.bd>\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("RCPT TO:<chaity.paul193@gmail.com>\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("DATA\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        Thread.sleep(delay);
        send("Subject : test\r\n");

        Thread.sleep(delay);
        send("hello\r\n");

        send(".\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("QUIT\r\n");

    }
    private static void send(String s) throws Exception {
        dos.writeBytes(s);
        System.out.println("CLlENT: "+s);
    }
}
