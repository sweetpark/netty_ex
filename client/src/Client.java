import java.io.*;
import java.net.Socket;

public class Client {
    private Socket client;

    public Client(String ip, Integer port) {
        try {
            this.client = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest(String message) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.client.getOutputStream()));
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            if (message.equalsIgnoreCase("exit")){
                bufferedWriter.close();
                close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getRecvMessage() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            String message = bufferedReader.readLine();
            return message;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close(/*-1?*/) {
        try {
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}