package cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import servidor.ChatServerInterface;

public class ChatCliente extends UnicastRemoteObject implements ChatClienteInterface, Runnable {

	private ChatServerInterface chatserver;
	private String nome = null;
	
	protected ChatCliente(String nome, ChatServerInterface ChatServer) throws RemoteException {	
	this.nome=nome;
	this.chatserver=ChatServer;		
	chatserver.RegistrarCliente(this);
	}

	@Override
	public void ReceberMensagem(String mensagem) throws RemoteException {
		System.out.println(mensagem);
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String mensagem;
		while(true) {
			mensagem=scanner.nextLine();
			try {
				chatserver.TransmitirMensagem(nome+"  :  "+mensagem);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
