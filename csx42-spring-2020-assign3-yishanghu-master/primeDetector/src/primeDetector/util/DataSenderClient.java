package primeDetector.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class DataSenderClient implements DataSender {
    private InetAddress ip;
    private int port;
    private Socket socket;
    private PrintWriter writer;

    public DataSenderClient(InetAddress ip2, int port) throws UnknownHostException, IOException {
        this.ip = ip2;
        this.port = port;
        this.socket = new Socket(this.ip, this.port);
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void sendDate(int data) {
        try {
                if(data == -1) {
                    writer.close(); 
                    socket.close();
                }
                System.out.println("SendData" + data);
                writer.println(data);
                writer.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endOfFile(String data) {
        // TODO Auto-generated method stub
        try {
            writer.println(data);
            writer.flush();
        } catch(Exception e) {

        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }


}