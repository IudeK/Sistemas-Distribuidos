package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import servidor.ChatServerInterface;

public class ChatClienteDriver {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		System.out.println("Qual seu nome?");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();
		
		ChatServerInterface chatserver = (ChatServerInterface) Naming.lookup("rmi://localhost:32001/ServidorChat");
		new Thread(new ChatCliente(nome, chatserver)).start();
		
		
		
	}
	

}
