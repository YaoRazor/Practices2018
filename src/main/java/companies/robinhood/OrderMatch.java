package companies.robinhood;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.PriorityQueue;

public class OrderMatch {

//      ['150', '5', 'buy'],    # Order A
//  ['190', '1', 'sell'],   # Order B
//  ['200', '1', 'sell'],   # Order C
//  ['100', '9', 'buy'],    # Order D
//  ['140', '8', 'sell'],   # Order E 5
//        ['210', '4', 'buy'],    # Order F 3 + 1

    class Order {
        int price;
        int share;
        Order(final int price, final int share) {
            this.price = price;
            this.share = share;
        }
    }


    int order_book(String[][] orders) {
        if(orders==null || orders.length==0 || orders[0]==null || orders[0].length==0) {
            return 0;
        }


        PriorityQueue<Order> buyOrders = new PriorityQueue<>((o1, o2)-> o2.price-o1.price);
        PriorityQueue<Order> sellOrders = new PriorityQueue<>((o1, o2)-> o1.price-o2.price);
        int ans = 0;


        for(String[] order: orders) {
            int price = Integer.parseInt(order[0]);
            int share = Integer.parseInt(order[1]);

            if("buy".equals(order[2])) {
                while(!sellOrders.isEmpty() && sellOrders.peek().price<=price && share>0) {
                    Order sellOrder = sellOrders.poll();
                    if(sellOrder.share > share) {
                        ans+=share;
                        sellOrder.share-=share;
                        sellOrders.offer(sellOrder);
                        share = 0;
                    } else {
                        ans+=sellOrder.share;
                        share-=sellOrder.share;
                    }
                }

                if(share>0) {
                    buyOrders.offer(new Order(price, share));
                }
            } else {
                while (!buyOrders.isEmpty() && buyOrders.peek().price>=price && share>0) {
                    Order buyOrder = buyOrders.poll();
                    if(buyOrder.share> share) {
                        ans+=share;
                        buyOrder.share-=share;
                        buyOrders.offer(buyOrder);
                        share = 0;
                    } else {
                        ans+=buyOrder.share;
                        share-=buyOrder.share;
                    }
                }

                if(share>0) {
                    sellOrders.offer(new Order(price, share));
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String[][] orders ={{"150", "10", "buy"}, {"165", "7", "sell"}, {"168", "3", "buy"}, {"155", "5", "sell"}, {"166", "8", "buy"}};

        OrderMatch orderMatch = new OrderMatch();
        System.out.println(orderMatch.order_book(orders));
    }
}
