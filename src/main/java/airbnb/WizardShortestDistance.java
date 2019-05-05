package airbnb;

import java.util.*;

public class WizardShortestDistance {

    // For Dijkstra
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {

        List<Integer> ans = new ArrayList<>();
        int[] parent = new int[wizards.size()];

        Map<Integer, Wizard> map = new HashMap<>();

        for(int i=0; i<wizards.size(); i++) {
            map.put(i, new Wizard(i));
            parent[i] = i;
        }

        PriorityQueue<Wizard> pq = new PriorityQueue<>();

        map.get(source).dist = 0;

        pq.offer(map.get(source));


        while (!pq.isEmpty()) {

            Wizard cur = pq.poll();

            for(Integer i : wizards.get(cur.id)) {

                Wizard next = map.get(i);
                int cost = (int)Math.pow(next.id-cur.id, 2);

                if(cur.dist+ cost< next.dist) {

                    pq.remove(next);

                    next.dist = cur.dist+ cost;

                    pq.offer(next);
                    parent[next.id] = cur.id;

                }
            }

        }


        int index = target;

        while (parent[index]!=index) {
            ans.add(index);
            index = parent[index];
        }

        ans.add(source);


        Collections.reverse(ans);

        return ans;

    }

//
//    public static void main(String[] args) {
//        WizardShortestDistance wsd = new WizardShortestDistance();
//        int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
//        List<List<Integer>> wizards = new ArrayList<>();
//        for (int i = 0; i < ids.length; i++) {
//            List<Integer> wizard = new ArrayList<>();
//            for (int j = 0; j < ids[i].length; j++) {
//                wizard.add(ids[i][j]);
//            }
//            wizards.add(wizard);
//        }
//
//        System.out.println(wsd.getShortestPath(wizards, 0, 9));
//    }
}

    // For Dijkstra
class Wizard implements Comparable<Wizard> {
  int id;
  int dist;
  Wizard(int id) {
    this.id = id;
    this.dist = Integer.MAX_VALUE;
  }

  @Override
  public int compareTo(Wizard that) {
    return this.dist - that.dist;
  }
}


