package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static List<String> output;
	public static int origin;
	public static int middle=0;
	public static int destiny=0;	
	
	/*
	*Código basado en la información recolectada de la página: Runstone academy. 
	*Link: https://runestone.academy/runestone/static/pythoned/Recursion/LasTorresDeHanoi.html
	*
	*Código basado en la información recolectada de un archivo pdf sobre las Torres de Hanoi.
	*Autores del archivo pdf: Amaia Gil Lerchundi, Ester Landa Cillero, Oihane Ruiz Díaz y Josué Tonelli Cueto.
	*Link: https://tonellicueto.xyz/pdf/torres_hanoi.pdf
	*/
	//Son 3 torres
	//Hanoi towers = 2^nd-1 donde nd es el número de discos
	//pre: d!=null,nd!=0                   A              C                B   
	public void hanoiTowers(int d,String origen,String destino,String intermedio) throws FileNotFoundException {
				
		if (d==1) {
			hanoiDisk(origen,destino,d);
		}else {
			hanoiTowers(d-1,origen,intermedio,destino);
			hanoiDisk(origen,destino,d);
			hanoiTowers(d-1,intermedio,destino,origen);
		}
		
	}//End hanoiTowers	
	
	
	
	/*
	*Código basado en la información recolectada de la página: Runstone academy. 
	*Link: https://runestone.academy/runestone/static/pythoned/Recursion/LasTorresDeHanoi.html
	*
	*Código basado en la información recolectada de un archivo pdf sobre las Torres de Hanoi.
	*Autores del archivo pdf: Amaia Gil Lerchundi, Ester Landa Cillero, Oihane Ruiz Díaz y Josué Tonelli Cueto.
	*Link: https://tonellicueto.xyz/pdf/torres_hanoi.pdf
	*/
	public void hanoiDisk(String desde,String hacia,int d) throws FileNotFoundException {		
		if (desde.equals("A")) {
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
		
		String message = origin+" "+middle+" "+destiny;
		System.out.println(message);		
		output.add(message);
		
		
	}//End hanoiDisk
	
	//Import disks data (.txt)
	public void importData() throws IOException {
		File file  = new File("data/datos.txt");
		
		if (file!=null) {
    		System.out.println("Se importará la información del archivo txt");
    		try {
    			BufferedReader br = new BufferedReader(new FileReader(file));
    			String line = br.readLine();
    			while(line!=null){					
    				if (!line.isEmpty()) {
    					int numberDisks = Integer.parseInt(line);
    					System.out.println(numberDisks+" 0 0");
    					output.add(numberDisks+" 0 0");
    					destiny=0;
    					origin=numberDisks;				
    					hanoiTowers(numberDisks,"A","C","B");	
    				}
    				output.add("");
    				line = br.readLine();
    				System.out.print("\n");
    				
    			}
    			br.close();
    			System.out.println("La información se ha importado correctamente");
    			
    		}catch (IOException e) {
    			System.out.println("Hubo un problema. No se pudo importar la información");    			 			
    		}    		
    	}
		
	}
	
    //Export disks data
    public void exportData() throws IOException{
    	File file = new File ("data/output.txt"); 
    	PrintWriter pw =  new PrintWriter(file);
    	
    	if (file!=null) {    	
    		System.out.println("Se exportará la información del archivo txt");


    		for (int i=0;i<output.size();i++) {
    			pw.println(output.get(i));
    		}		
    		pw.close();
    		System.out.println("Se ha exportado exitosamente la información del archivo txt"); 		   	
    	}     			    
    }

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		output = new ArrayList<String>();		
		m.importData();
		m.exportData();		
	}

}
