package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int origin;
	public static int middle=0;
	public static int destiny=0;
	
	//Son 3 torres
	//Hanoi towers = 2^nd-1 donde nd es el número de discos
	//pre: d!=null,nd!=0                   A              C                B   
	
	/*
	*Código basado en la información recolectada de la página: Runstone academy. 
	*Link: https://runestone.academy/runestone/static/pythoned/Recursion/LasTorresDeHanoi.html
	*
	*Código basado en la información recolectada de un archivo pdf sobre las Torres de Hanoi.
	*Autores del archivo pdf: Amaia Gil Lerchundi, Ester Landa Cillero, Oihane Ruiz Díaz y Josué Tonelli Cueto.
	*Link: https://tonellicueto.xyz/pdf/torres_hanoi.pdf
	*/
	public void hanoiTowers(int d,String origen,String destino,String intermedio) {
				
		if (d==1) {
			hanoiDisk(origen,destino,d);
		}else {
			hanoiTowers(d-1,origen,intermedio,destino);
			hanoiDisk(origen,destino,d);
			hanoiTowers(d-1,intermedio,destino,origen);
		}
		
	}//End hanoiTowers	
	
	public void hanoiDisk(String desde,String hacia,int d) {
		//System.out.println("middle: "+middle+", destiny: "+destiny);
			
		if (desde.equals("A")) {
			//System.out.println("origin dentro del metodo: "+origin);
			origin-=1;			
		}
		if (desde.equals("B")) {
			if (middle>0) {
				middle-=1;
			}
		}
		if (desde.equals("C")) {
			if (destiny>0) {
				destiny-=1;
			}
		}
		
		if (hacia.equals("A")) {
			origin+=1;
		}
		
		if (hacia.equals("B")) {
			middle+=1;
		}
		
		if (hacia.equals("C")) {
			destiny+=1;			
		}	
		
		//System.out.println("mover disco de "+desde+" a "+hacia);
		System.out.println(origin+" "+middle+" "+destiny);
	}
	
	public static void main(String[] args) throws IOException {		
		Main m = new Main();
		
		String disks = br.readLine();
		System.out.print("\n");
		
		while (disks!=null) {
			if (!disks.isEmpty()) {
				int discs = Integer.parseInt(disks);
				System.out.println(disks+" 0 0");
				destiny=0;
				origin=discs;				
				//System.out.println("discs y origin:"+origin);
				m.hanoiTowers(discs,"A","C","B");				
			}
			disks = br.readLine();
			System.out.print("\n");
		}
		
	}

}
