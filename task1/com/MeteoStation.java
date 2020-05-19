package com;

public class MeteoStation{
	public static void main(String[] args){
		MeteoStore meteoDb = new MeteoStore();
		
		MeteoSensor ms200_1 = new MS200(1);
		meteoDb.save(ms200_1);

		ST500Adapter st500Adapter= new ST500Adapter(new ST500Info().getData());
		meteoDb.save(st500Adapter);

	}
}