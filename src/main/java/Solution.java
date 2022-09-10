import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Solution {
    public static void main(String[] args) {
        try{
            ServerSocket socket = new ServerSocket(8084);
            Socket accept = socket.accept();
            while(true){
                InputStream inputStream = accept.getInputStream();
                DataInputStream dataInputStream =
                        new DataInputStream(inputStream);
                String line = dataInputStream.readUTF();
                System.out.println("Server got from client this message: " + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
