package companies.zoox;

enum BusinessClass {
    Economy,
    Business,
    Premium;

    public static BusinessClass from(String input) {
        if(Economy.toString().equalsIgnoreCase(input)) {
            return Economy;
        } else if(Business.toString().equalsIgnoreCase(input)) {
            return Business;
        } else if(Premium.toString().equalsIgnoreCase(input)) {
            return Premium;
        } else {
            return Economy;
        }
    }
}


public abstract class Airline {

    abstract double getBusinessClassAdjustment(BusinessClass businessClass, double mile);

    double getOperationCost(BusinessClass businessClass, double mile) {
        switch (businessClass) {
            case Economy:
                return 0d;
            case Business:
                 return 0.25*mile+50.0;
            case Premium:
                 return 25;
        }

        throw new IllegalArgumentException();
    }

    double getCost(BusinessClass businessClass, double mile) {
        return getOperationCost(businessClass, mile) + getBusinessClassAdjustment(businessClass, mile);
    };
}



