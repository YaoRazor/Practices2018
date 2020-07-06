package companies.zoox;

public class SouthwestAirline extends Airline{

    private static double PER_Mile_ADJUSTMENT = 1.0;

    @Override
    public double getBusinessClassAdjustment(BusinessClass businessClass, double mile) {
        return PER_Mile_ADJUSTMENT*mile;
    }

    @Override
    public double getOperationCost(BusinessClass businessClass, double mile) {
        return 0;
    }

}
