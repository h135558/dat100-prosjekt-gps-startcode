package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

    
    private static int TIME_STARTINDEX = 11; 

    public static int toSeconds(String timestr) {
        
          String tidsDel = timestr.substring(TIME_STARTINDEX, TIME_STARTINDEX + 8);
            
            String[] tidsDeler = tidsDel.split(":");
    
          
          int hrs = Integer.parseInt(tidsDeler[0]);
          int min = Integer.parseInt(tidsDeler[1]);
          int sec = Integer.parseInt(tidsDeler[2]);
          
          int totalSec = (hrs * 3600) + (min * 60) + sec;
          
          
          return totalSec;

        
    }

    public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
        
        int time = toSeconds(timeStr);
        double latitude = Double.parseDouble(latitudeStr);
        double longitude = Double.parseDouble(longitudeStr);
        double elevation = Double.parseDouble(elevationStr);
        
        
        GPSPoint gpsPoint  = new GPSPoint(time, latitude, longitude, elevation);
        
        return gpsPoint ;
    
    }
    
}
