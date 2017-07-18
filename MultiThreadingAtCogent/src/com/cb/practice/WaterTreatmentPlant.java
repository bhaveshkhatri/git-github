package com.cb.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WaterTreatmentPlant {
	
	static int numOfStations, i, j;
	
	

	public static void main(String[] args) throws IOException {
		
		Map<Integer, Station> stations = new HashMap<>();
		Map<Integer, Pipe> pipes = new HashMap<>();
				
		
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader("E:/NEW/Assignment2AtCogent/bin/com/cb/practice/config.txt");			
			br = new BufferedReader(fr);
		
			numOfStations = Integer.parseInt(br.readLine());
			
			
			
			for(i=0; i<numOfStations;i++) {
				pipes.put(i, new Pipe("Pipe-"+i));
			}
			
			for(i=0; i<numOfStations;i++) {
				j=i+1; if(j==3) j=0;
				stations.put(i, new Station("Station-"+i, Integer.parseInt( br.readLine()), pipes.get(i), pipes.get(j)));
				
			}
			//System.out.println(stations);
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(i=0; i < stations.size(); i++) {
			
			stations.get(i).doWork();
		}

	}

}
