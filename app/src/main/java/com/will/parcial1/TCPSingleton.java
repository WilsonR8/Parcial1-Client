package com.will.parcial1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSingleton extends Thread{


    private static TCPSingleton unico;

    public static TCPSingleton getInstance(){
         if(unico == null){
             unico = new TCPSingleton();
         }
         return unico;
    }

    private TCPSingleton(){}


    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public void run(){
        try {
            //2.enviar solicitud de conexion
            socket = new Socket("192.168.1.33", 5000);
            //3.Cliente y server conect

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            reader = new BufferedReader(isr);

            OutputStream os =socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            writer = new BufferedWriter(osw);

            while(true) {
                System.out.println("perate pue..");
                String line=reader.readLine();
                System.out.println("Recibido...");
                System.out.println("Recibido:"+line);
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        new Thread(
                ()->{
                    try {

                        writer.write(msg+"\n");
                        writer.flush();

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }

}







