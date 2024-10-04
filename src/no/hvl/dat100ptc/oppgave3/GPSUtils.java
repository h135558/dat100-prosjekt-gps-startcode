package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {
	private static final int R = 6371000; // jordens radius
	private static int TEXTWIDTH = 10;

	public static double findMax(double[] da) {
		double max = da[0];

		for (double d : da)
			if (d > max)
				max = d;

		return max;
	}

	public static double findMin(double[] da) {
		double min = da[0];

		for (double d : da)
			if (d < min)
				min = d;

		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double[] lat = new double[gpspoints.length];

		for (int i = 0; i < lat.length; i++)
			lat[i] = gpspoints[i].getLatitude();

		return lat;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		double[] lon = new double[gpspoints.length];

		for (int i = 0; i < lon.length; i++)
			lon[i] = gpspoints[i].getLongitude();

		return lon;
	}

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		return R * compute_c(compute_a(toRadians(gpspoint1.getLatitude()), toRadians(gpspoint2.getLatitude()),
				toRadians(gpspoint2.getLatitude() - gpspoint1.getLatitude()),
				toRadians(gpspoint2.getLongitude() - gpspoint1.getLongitude())));
	}

	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		return pow(sin(deltaphi / 2), 2) + cos(phi1) * cos(phi2) * pow(sin(deltadelta / 2), 2);
	}

	private static double compute_c(double a) {
		return 2 * atan2(sqrt(a), sqrt(1 - a));
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		return distance(gpspoint1, gpspoint2) / (gpspoint2.getTime() - gpspoint1.getTime());
	}

	public static String formatTime(int secs) {
		return String.format("%" + TEXTWIDTH + "s", java.time.LocalTime.ofSecondOfDay(secs).toString());
	}

	public static String formatDouble(double d) {
		return String.format("%" + TEXTWIDTH + ".2f", d);
	}
}