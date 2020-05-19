package ninechapter.hash_and_heap.optional;

import java.util.*;

public class LoadBalancer {
    List<Integer> list;
    Map<Integer, Integer> map;

    public LoadBalancer() {
        list = new ArrayList<>();
        map = new HashMap<>();
        // do intialization if necessary
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        list.add(server_id);
        map.put(server_id, list.size()-1);

    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        int index = map.get(server_id);
        map.remove(server_id);

        // Exchange the position and using HashMap to track the index,
        // this is the key to this problem
        if(index<list.size()) {
            int value = list.get(list.size()-1);
            map.put(value, index);
            list.set(index, value);
        }

        list.remove(list.size()-1);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        Random random= new Random();
        int index = random.nextInt(list.size());
        int server_id = list.get(index);
        return server_id;
    }
}
