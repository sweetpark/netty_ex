package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{
    private ServerSocket server;
    public Server(Integer port){
        try{
            server = new ServerSocket(port);
        }catch(IOException e){
            System.out.println("error : \n" + e);
        }
    }

    public Socket waitClient(){
        try{
            return server.accept();
        }catch(IOException e){
            System.out.println("비정상적 종료 \n" + e);
            return null;
        }
    }



}
