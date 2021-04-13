package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//Son 3 torres
	//Hanoi towers = 2^nd-1 donde nd es el número de discos
	//pre: d!=null,nd!=0 
	public String hanoiTowers(String d) {
		String states="";
		if (!d.isEmpty() && d!=null) {			
			int nd = Integer.parseInt(d);
			
			if (nd==1) {
				states ="1 0 0"+"\n0 0 1";
			}
		}		
		return states;
	}//End hanoiTowers	
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		
		String disks = br.readLine();
		
		while (disks!=null) {
			if (!disks.isEmpty()) {
				System.out.println(m.hanoiTowers(disks));				
			}
			disks = br.readLine();
		}
		
	}

}
