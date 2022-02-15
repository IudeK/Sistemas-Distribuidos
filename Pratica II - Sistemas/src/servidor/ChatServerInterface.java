package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import cliente.ChatClienteInterface;

public interface ChatServerInterface extends Remote{
	
	void RegistrarCliente(ChatClienteInterface ChatCliente) throws RemoteException;
	
	void TransmitirMensagem(String mensagem) throws RemoteException;
	
}
