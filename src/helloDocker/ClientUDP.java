package helloDocker;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] argv){
        sendToServerUDP(argv[0], Integer.parseInt(argv[1]));
    }

    public static void sendToServerUDP(String serveur, int port){

        Scanner scanner = new Scanner(System.in);


        {
            try {
                DatagramSocket socket = new DatagramSocket();
                InetAddress localhost = InetAddress.getByName(serveur);
                String string ;
                while (scanner.hasNextLine()) {
                    string = scanner.nextLine();
                    byte[] msg = string.getBytes();
                    DatagramPacket output = new DatagramPacket(msg,  msg.length, localhost, port);
                    socket.send(output);
                }
                socket.close();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
