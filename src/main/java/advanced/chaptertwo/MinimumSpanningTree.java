package advanced.chaptertwo;

import java.util.*;


// Kruskal algorithm
// https://www.jianshu.com/p/76df4f166ce2
public class MinimumSpanningTree {
    class Connection {
        public String city1, city2;
        public int cost;

        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    Map<String, String> father;

    private String find(String x) {
        String ans = x;
        while(!father.get(ans).equals(ans)) {
            ans = father.get(ans);
        }

        // path compression
        while(!father.get(x).equals(ans)) {
            String tmp = father.get(x);
            father.put(x, ans);
            x = tmp;
        }

        return ans;
    }


    class ConnectionComparator implements Comparator<Connection> {

        @Override
        public int compare(Connection c1, Connection c2) {
            if(c1.cost==c2.cost) {
                if(c1.city1.equals(c2.city1)) {
                    return c1.city2.compareTo(c2.city2);
                } else {
                    return c1.city1.compareTo(c2.city1);
                }
            } else {
                return c1.cost-c2.cost;
            }
        }

    }

    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> ans = new ArrayList<>();
        father = new HashMap<>();


        for(Connection connection: connections) {
            father.put(connection.city1, connection.city1);
            father.put(connection.city2, connection.city2);
        }

        Collections.sort(connections, new ConnectionComparator());

        // This is the total number of cities in the graph
        int n = father.size();

        for(Connection connection: connections) {
            String fx = find(connection.city1);
            String fy = find(connection.city2);

            if(!fx.equals(fy)) {
                ans.add(connection);
                father.put(fx, fy);
            }
        }

        if(ans.size()==n-1) {
            return ans;
        } else {
            return new ArrayList<>();
        }

    }
}
