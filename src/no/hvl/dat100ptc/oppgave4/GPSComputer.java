package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
			distance += GPSUtils.distance(gpspoints[i],gpspoints[i+1]);
			
		}
		return distance;
	

	}

	public double totalElevation() {

		double elevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			double diff = gpspoints[i+1].getElevation() - gpspoints[i].getElevation();
			if (diff > 0) {
				elevation += diff;
			}
		}
		return elevation;
		
	}

	public int totalTime() {

		return gpspoints[gpspoints.length - 1].getTime() - gpspoints[0].getTime(); // Tar altså differetnasen mellom siste og første punktet :)
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		for (int i = 0; i < gpspoints.length -1; i++) {
			double distanse = GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			int time = gpspoints[i+1].getTime() - gpspoints[i].getTime();
			speeds[i] = distanse / time;
				}
		return speeds;
	}
	
	public double maxSpeed() {
		
		double[] speeds = speeds();
		return GPSUtils.findMax(speeds);
	
	}

	public double averageSpeed() {
		double totalDistance = totalDistance();
		int totalTime = totalTime();
		return totalDistance / totalTime * 3.6; // * 3.6 kovertere det til Kmh
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double met = 0;		
		double speedmph = speed * MS;

		if (speedmph < 10) {
			met = 4.0;
		} else if (speedmph < 12) {
			met = 6.0;
		} else if (speedmph < 14) {
			met = 8.0;
		} else if (speedmph < 16) {
			met = 10.0;
		} else if (speedmph < 20) {
			met = 12;
		} else {
			met = 16.0;
		}
		
		double hours = secs / 3600.0;
		return met * weight * hours; // Regnesstykke for kcal
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
