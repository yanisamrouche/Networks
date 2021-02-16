package helloDocker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class ServerTCPEcho {
    public static void main(String[] args) throws IOException {
        receiveFromClient();
    }

    public static void receiveFromClient() throws IOException {

        Scanner scanner = new Scanner(String.valueOf(System.out));
        ServerSocket socket = new ServerSocket(1234);
        Socket c = socket.accept();
        DataInputStream in = new DataInputStream(new BufferedInputStream(c.getInputStream()));
        String line;
        while (scanner.hasNextLine()){
           try{
               line = in.readUTF();
               System.out.println(">"+line);
           }catch (EOFException e){
               System.out.println(" ");
               break;
           }


        }

        c.close();
        socket.close();


  }
}
