package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	private static int TIME_STARTINDEX = 11;
	
	public static int toSeconds(String timestr) {
	    String[] tid = timestr.substring(TIME_STARTINDEX, TIME_STARTINDEX + 8).split(":");

	    return Integer.parseInt(tid[0]) * 3600 + Integer.parseInt(tid[1]) * 60 + Integer.parseInt(tid[2]);
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		return new GPSPoint(toSeconds(timeStr), Double.parseDouble(latitudeStr), Double.parseDouble(longitudeStr), Double.parseDouble(elevationStr));
	}
}
