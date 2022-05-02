import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Server started!..");
        int port = 8089;
        var serverSocket = new ServerSocket(port);

        while(true) {
            Socket clientSocket = serverSocket.accept();
            var out = new PrintWriter(clientSocket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.printf("New connection accepted. Port # %d%n", clientSocket.getPort());

            out.println("Write your name");
            final String name = in.readLine();
            out.println("Are you a child? (yes/no)");
            String answer = in.readLine();
            if(answer.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            }
            if(answer.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
            else {
                out.println("Please use the answer: 'yes' or 'no'. Are you a child? ");
            }
        }
    }
}
