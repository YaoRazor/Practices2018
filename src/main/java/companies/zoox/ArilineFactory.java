package companies.zoox;
import java.util.*;

public class ArilineFactory {

    private static Map<String, Airline> map = new HashMap<String, Airline>() {{
        put("delta", new DeltaAirline());
        put("southwest", new SouthwestAirline());
        put("united", new UnitedAirline());
    }};


    public static Airline getAirLine(String input) {
      input = input.toLowerCase();
      return map.get(input);
    }

    public static void main(String args[]) {
        String[] input = {"United", "150.0" , "Premium"};

        System.out.println("Current airline cost "+ getCost(input)+" dollars");

        String[] input2 = {"Delta", "60.0", "Business"};

        System.out.println("Current airline cost "+ getCost(input2)+" dollars");

        String[] input3 = {"Southwest", "1000.0", "Economy"};

        System.out.println("Current airline cost "+ getCost(input3)+" dollars");
    }

    static double getCost(String[] input) {
        Airline airline = ArilineFactory.getAirLine(input[0]);
        double cost = airline.getCost(BusinessClass.valueOf(input[2]), Double.parseDouble(input[1]));
        return cost;
    }
}
