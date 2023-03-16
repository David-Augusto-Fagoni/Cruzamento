package View;

import controller.Carros;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String args[])
	{
		Semaphore Mutex = new Semaphore(1);
		for(int J=0;J<4;J++){
			Carros C = new Carros(J,Mutex);
			C.start();
		}
		
	}
}
