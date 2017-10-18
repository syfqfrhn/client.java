import java.net.*;
import java.io.*;

public class GreetingClient {
	public static void main (String [] args){
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		try{
			System.out.println("Bersambung kepada " + 192.168.132.128 +" on port " + 6066);
			Socket client = new Socket(serverName,port);

			System.out.println("Terhubung kepada "+client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Helo dari "+ client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server berkata "+ in.readUTF());
			client.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
