package kenny.io.socketdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {

	public static void main(String[] args) {
		int portID = 4000;
		try {
			ServerSocket serverSocket = new ServerSocket(portID);
			Socket socket = serverSocket.accept(); //blocking until a connect come

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
			while(true){
				String str = reader.readLine();
				if(str.equals("bye"))
					break;
				System.out.println("received info:" + str);
				writer.println(str);

			}
			socket.close();
			serverSocket.close();
			System.out.println("server closed!");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}


		
	}

}
