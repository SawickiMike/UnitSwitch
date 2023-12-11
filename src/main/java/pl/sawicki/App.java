package pl.sawicki;

import pl.sawicki.common.Distance;
import pl.sawicki.common.DistanceUnits;
import pl.sawicki.common.Volume;
import pl.sawicki.common.VolumeUnits;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Distance metry = new Distance(100, DistanceUnits.METER);
        System.out.println("100 metrów to " + metry.getInFeet() + " stóp");


        Volume basen = new Volume(3_500_000, VolumeUnits.LITER);

        System.out.println(basen.toString());
        Volume basenInCubicMeter = new Volume(basen.getIntoCubicMeter(),VolumeUnits.CUBIC_METER);
        Volume basenInCubicCentimeter = new Volume(basen.getIntoCubicCentimeter(),VolumeUnits.CUBIC_CENTIMETER);
        System.out.println(basen.toString());
        System.out.println(basenInCubicMeter.toString());
        Volume newBasen = new Volume(3500,VolumeUnits.CUBIC_METER);
        System.out.println(newBasen.toString());

        System.out.println(basen.equals(basenInCubicMeter));
        System.out.println(basenInCubicCentimeter.equals(basenInCubicMeter));
        System.out.println(newBasen.equals(basen));


    }
}
