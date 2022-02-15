import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    
	int porta;
	
	Server(int porta) {
        this.porta = porta;
    }
	
	 public void run() {
	        try {
	        	long start = System.currentTimeMillis();
	            ServerSocket server = new ServerSocket(this.porta);

	            	System.out.println("Servidor Iniciado");
	            while (true) {
	            	System.out.println("Esperando conexao");
	                Socket client = server.accept();
	                System.out.println("Conectado!");
	                ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
	     	        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
	     	        
	     	        
	     			String nome = input.readUTF();
	     	        long somatorio = 0;
	     	        for(int i=0; i < 1000000 ; i++){ 
	     	        	long numero = input.read();
	     	        	somatorio = somatorio + numero;
	     	        } 
	     	        
	     	        System.out.println("somatorio do " + nome + " : " + somatorio);
	     	        long elapsed = System.currentTimeMillis() - start;
	     			System.out.println("Tempo em millisegundos: " + elapsed);
	     	        output.flush();   
	                client.close();
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
    
    
    	

   