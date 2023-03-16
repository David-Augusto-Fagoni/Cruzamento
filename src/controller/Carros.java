package controller;

import java.util.concurrent.Semaphore;

public class Carros extends Thread {
	
	private int J;
	private Semaphore Mutex;
	public Carros (int j, Semaphore Mutex){
		this.J = j;
		this.Mutex = Mutex; 
	}
	public void run() {
		Cruzamento();
	}
	public void Cruzamento() {
		String Direção = null;
		switch(J) {
		case 0 -> Direção = "Norte para sul";
		case 1 -> Direção = "Sul para Norte";
		case 2 -> Direção = "Leste para Oeste";
		case 3 -> Direção = "Oeste para Leste";
		}
		try {
			Mutex.acquire();
			System.out.println("Carro Nº"+(J+1)+" cruzou de "+Direção);
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Mutex.release();
		}
		
	}

}
