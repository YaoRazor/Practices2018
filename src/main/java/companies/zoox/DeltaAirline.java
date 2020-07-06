package companies.zoox;

public class DeltaAirline extends Airline {

    private static double perMileAdujstMent = 0.5;

    @Override
    public double getBusinessClassAdjustment(BusinessClass businessClass, double mile) {
        return perMileAdujstMent * mile;
    }

}
