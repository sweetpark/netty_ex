package server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientSocket extends Thread{

    private Socket socket;

    public ClientSocket(Socket socket){
        this.socket = socket;
    }

    public List<Object> getRequest(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();
            List<Object> list = new ArrayList<>();

            list.add(bufferedReader);
            list.add(message);

            return list;
        }catch(IOException e){
            System.out.println("request error \n" + e);
            return null;
        }
    }

    public BufferedWriter sendResponse(String message){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            return bufferedWriter;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }


    public void close(BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while(true){
            List<Object> request = getRequest();
            String requestMessage = (String)request.get(1);
            BufferedReader bufferedReader  = (BufferedReader)request.get(0);
            BufferedWriter bufferedWriter = sendResponse("hello client");

            System.out.println(requestMessage);

            if (requestMessage.equalsIgnoreCase("exit")){
                close(bufferedWriter, bufferedReader);
            }

        }
    }
}
