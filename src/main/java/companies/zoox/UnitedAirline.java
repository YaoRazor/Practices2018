package companies.zoox;

public class UnitedAirline extends Airline {

    private static double PER_MILE_ADJUSTMENT = 0.75;
    private static double PER_MILE_ADJUSTMENT_EXTRA = 0.10;

    @Override
    public double getBusinessClassAdjustment(BusinessClass businessClass, double mile) {
        if(BusinessClass.Premium.equals(businessClass)) {
            return (PER_MILE_ADJUSTMENT+PER_MILE_ADJUSTMENT_EXTRA)*mile;
        } else {
            return PER_MILE_ADJUSTMENT*mile;
        }
    }
}
