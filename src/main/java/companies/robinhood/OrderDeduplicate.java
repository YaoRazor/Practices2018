package companies.robinhood;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.*;

public class OrderDeduplicate {

//    private Comparator<String> comparator;
//
//    OrderDeduplicate(Comparator<String> comparator) {
//        this.comparator = comparator;
//    }

    private int compare(String houseOrder, String streetOrder) {
        return houseOrder.compareTo(streetOrder);
//        return comparator.compare(houseOrder, streetOrder);
    }

    List<String> helper(List<String> house, List<String> street, Comparator<String> comparator) {
        Collections.sort(house);
        Collections.sort(street);

        int i=0;
        int j = 0;

        List<String> ans = new ArrayList<>();

        while(i<house.size() && j<street.size()) {
            String houseOrder = house.get(i);
            String streetOrder = street.get(j);

            if(comparator.compare(houseOrder, streetOrder)<0) {
                ans.add(houseOrder);
                i++;
            } else if(comparator.compare(houseOrder, streetOrder)>0) {
                ans.add(streetOrder);
                j++;
            } else {
                i++;
                j++;
            }
        }

        while(i<house.size() || j<street.size()) {
            if(i<house.size()) {
                ans.add(house.get(i++));
            }

            if(j<street.size()) {
                ans.add(street.get(j++));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        OrderDeduplicate orderDeduplicate = new OrderDeduplicate();
        String[] houseOrder = {"AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"};
        String[] streetOrder = {" FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123"};

//        System.out.println(orderDeduplicate.deduplicate(Arrays.asList(houseOrder), Arrays.asList(streetOrder)));
    }

}
