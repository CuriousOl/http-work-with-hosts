import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;

        try(var clientSocket = new Socket(host, port);
            var out = new PrintWriter(clientSocket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String resp = in.readLine();
            System.out.println(resp);
            out.println("Olesya");
            System.out.println("Olesya");
            resp = in.readLine();
            System.out.println(resp);
            out.println("no");
            System.out.println("no");
            resp = in.readLine();
            System.out.println(resp);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
