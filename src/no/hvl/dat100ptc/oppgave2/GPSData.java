package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {
		gpspoints = new GPSPoint[antall];
		this.antall = 0;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	protected boolean insertGPS(GPSPoint gpspoint) {
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			return true;
		}

		return false;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		return insertGPS(GPSDataConverter.convert(time, latitude, longitude, elevation));
	}

	public void print() {
		System.out.println("====== GPS Data - START ======");
		for (int i = 0; i < antall; i++) {
			System.out.println(gpspoints[i].toString());
		}

		System.out.println("====== GPS Data - SLUTT ======");
	}
}
