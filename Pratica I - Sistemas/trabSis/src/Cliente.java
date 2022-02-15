import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.random.*;

public class Cliente implements Runnable{
	
String nome;	
int porta;

Cliente(String nome, int porta){
	
 this.nome = nome;	
 this.porta = porta;
}
    
public void run(){
	 	
    Random gerador = new Random();
    try {
        

        //cria conexão cliente-servidor
        Socket socket = new Socket("localhost",porta);

        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        
        output.writeUTF(nome);;
        output.flush();

        for(int i=0; i < 1000000 ; i++){ 
        	int a = gerador.nextInt(1001);
            output.write(a);
            output.flush();
        }
        
        input.close();
        output.close();
        socket.close();

    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

 }

 }

