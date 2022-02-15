
public class Threads {

	public static void main(String[] args) {
		
	/*	//************************ Com MultiThread no Servidor *****************************
	
		Server s1 = new Server(3333);
		s1.start();
		
		Cliente cliente1 = new Cliente("Cliente #1" ,3333); // Tempo com 1 Clientes = 14369 millisegundos
		Thread t1 = new Thread(cliente1);
		t1.start();
		
		//**************************
		
		
		Server s2 = new Server(6666);
		s2.start();
		
		
		Cliente cliente2 = new Cliente("Cliente #2",6666); // Tempo com 2 Clientes  = 8251 millisegundos
		Thread t2 = new Thread(cliente2);
		t2.start();
		
		//***************************
		
		Server s3 = new Server(9999);
		s3.start();
		
		Cliente cliente3 = new Cliente("Cliente #3",9999); // Tempo com 3 Clientes  = 11416 millisegundos
		Thread t3 = new Thread(cliente3);
		t3.start();
	*/
		//**************************** TODOS NO MESMO SERVIOR AGR *******************************
		Server s4 = new Server(8888);
		s4.start();
		
		Cliente cliente4 = new Cliente("Cliente #4",8888); //Tempo com 1 Cliente = 16245 millisegundos
		Thread t4 = new Thread(cliente4);
		t4.start();
		
		Cliente cliente5 = new Cliente("Cliente #5",8888); //Tempo com 2 Clientes = 44847 millisegundos
		Thread t5 = new Thread(cliente5);
		t5.start();
		
		Cliente cliente6 = new Cliente("Cliente #6",8888); // Tempo com 3 Clientes = 90744 millisegundos
		Thread t6 = new Thread(cliente6);
		t6.start();
		
	}
	
}
