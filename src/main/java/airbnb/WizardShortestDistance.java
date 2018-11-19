package airbnb;

import java.util.*;

public class WizardShortestDistance {

    static class Num {
        int dis;   // Wizard与第一个wizard的距离
        int val;   // Wizard编号

        public Num(int d, int v) {
            this.dis = d;
            this.val = v;
        }
    }

    public static int getMinCost(List<List<Integer>> list) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Num> pq = new PriorityQueue<>((n1, n2) -> n1.dis - n2.dis);

        for (int i : list.get(0)) {
            pq.add(new Num(i * i, i));
        }
        visited.add(0);
        while (!pq.isEmpty()) {
            Num num = pq.poll();
            visited.add(num.val);
            if (num.val == 9) {
                return num.dis;
            }
            for (int i : list.get(num.val)) {
                if (!visited.contains(i)) {
                    pq.add(new Num(num.dis + (i - num.val) * (i - num.val), i));
                }
            }
        }
        return Integer.MAX_VALUE;
    }


    // For Dijkstra
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        List<Integer> path = new ArrayList<>();

        int[] parent = new int[wizards.size()];
        Map<Integer, Wizard> map = new HashMap<>();
        for (int i = 0; i < wizards.size(); i++) {
            parent[i] = i;
            map.put(i, new Wizard(i));
        }

        map.get(source).dist = 0;
        Queue<Wizard> heap = new PriorityQueue<>();
        heap.offer(map.get(source));

        while (!heap.isEmpty()) {
            Wizard cur = heap.poll();
            List<Integer> neighbors = wizards.get(cur.id);
            for (int neighbor : neighbors) {
                Wizard next = map.get(neighbor);
                int weight = (int) Math.pow(cur.id - next.id, 2);
                if (cur.dist + weight < next.dist) {
                    heap.remove(next);
                    parent[next.id] = cur.id;
                    next.dist = cur.dist + weight;
                    heap.offer(next);
                }
            }
        }

        int index = target;
        while (index != source) {
            path.add(index);
            index = parent[index];
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }


    public static void main(String[] args) {
        WizardShortestDistance wsd = new WizardShortestDistance();
        int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            List<Integer> wizard = new ArrayList<>();
            for (int j = 0; j < ids[i].length; j++) {
                wizard.add(ids[i][j]);
            }
            wizards.add(wizard);
        }

        System.out.println(wsd.getShortestPath(wizards, 0, 9));
    }
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


