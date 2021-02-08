package helloDocker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class ServerUDP {
    public static void main(String[] args){
        receiveFromClientUDP();

    }
    public static void receiveFromClientUDP(){
        Scanner scanner = new Scanner(String.valueOf(System.out));
        try {
            DatagramSocket s = new DatagramSocket(1234);
            while (scanner.hasNextLine()){
                byte msg[] = new byte[100];
                DatagramPacket input = new DatagramPacket(msg,100);
                s.receive(input);
                System.out.println(">"+new String(msg));
                System.out.println("From port:"+input.getPort());
            }




        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
