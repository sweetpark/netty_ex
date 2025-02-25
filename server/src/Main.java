import server.ClientSocket;
import server.Server;

import java.net.Socket;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Server server = new Server(5555);

        while(true){
            Socket socket = server.waitClient();
            ClientSocket clientSocket = new ClientSocket(socket);
            clientSocket.start();
        }
        
    }
}