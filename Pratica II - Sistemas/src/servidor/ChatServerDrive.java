package servidor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ChatServerDrive {

	public static void main(String[] args) throws IOException {
		LocateRegistry.createRegistry(32001);
		Naming.rebind("rmi://localhost:32001/ServidorChat", new ChatServer());
		System.out.println("servidor iniciado");
	}

}
