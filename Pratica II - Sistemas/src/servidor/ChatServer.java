package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import cliente.ChatClienteInterface;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClienteInterface> ChatClientes;
	
	protected ChatServer() throws RemoteException {
		ChatClientes = new ArrayList<ChatClienteInterface>();
	}

	public synchronized void RegistrarCliente(ChatClienteInterface ChatCliente) throws RemoteException {
		this.ChatClientes.add(ChatCliente);
	}


	public synchronized void TransmitirMensagem(String mensagem) throws RemoteException {
		int i=0;
		while(i< ChatClientes.size()) {
			ChatClientes.get(i++).ReceberMensagem(mensagem);
		}
		
	}

}
