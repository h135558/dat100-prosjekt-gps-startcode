package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	private static int TIME_STARTINDEX = 11;
	
	public static int toSeconds(String timestr) {
		return java.time.LocalTime.parse(timestr.substring(TIME_STARTINDEX, TIME_STARTINDEX + 8)).toSecondOfDay();
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		return new GPSPoint(toSeconds(timeStr), Double.parseDouble(latitudeStr), Double.parseDouble(longitudeStr), Double.parseDouble(elevationStr));
	}
}
