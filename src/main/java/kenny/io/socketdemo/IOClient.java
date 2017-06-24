package kenny.io.socketdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class IOClient {


	public static void main(String[] args) {
		int portID = 4000;

		try {
			Socket socket = new Socket(InetAddress.getByName("localhost"), portID);

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

			writer.println("Hello Server,I am " + "kangminghong");
			System.out.println(reader.readLine());

			writer.println("byebye");

			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}



	}

}
