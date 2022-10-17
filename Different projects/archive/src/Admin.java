import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("localhost", 8000));
            Scanner scanner = new Scanner(socket.getInputStream());
             while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
    }
}
