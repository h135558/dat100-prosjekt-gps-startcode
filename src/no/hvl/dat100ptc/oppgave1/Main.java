package no.hvl.dat100ptc.oppgave1;

public class Main {

    public static void main(String[] args) {
        GPSPoint point = new GPSPoint(1, 2.0, 3.0, 5.0);
        point.setTime(2);

        System.out.println("Tidspunkt: " + point.getTime());
        
        
        System.out.println(point.toString());
    
        
    }

}