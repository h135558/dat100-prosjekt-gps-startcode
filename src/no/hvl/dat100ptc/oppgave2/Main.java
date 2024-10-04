package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {
		GPSPoint point1 = new GPSPoint(3600, 60.5131, 5.2331, 50.0);
		GPSPoint point2 = new GPSPoint(7400, 54.2221, 7.3371, 70.0);
		GPSData gpsData = new GPSData(2);
		
		gpsData.insertGPS(point1);
		gpsData.insertGPS(point2);
		
		gpsData.print();
	}
}
