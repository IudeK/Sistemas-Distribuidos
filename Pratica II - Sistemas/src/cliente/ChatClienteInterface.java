package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClienteInterface extends Remote{
	
	void ReceberMensagem(String mensagem) throws RemoteException;

}
