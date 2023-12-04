package pl.sawicki;

import pl.sawicki.common.Distance;
import pl.sawicki.common.DistanceUnits;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Distance metry = new Distance(100, DistanceUnits.METER);
        System.out.println("100 metrów to " + metry.getInFeet() + " stóp");
    }
}
