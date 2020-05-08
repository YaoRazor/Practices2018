package ninechapter.dfs.optional;

import java.util.*;

public class Factorization {
    public List<List<Integer>> getFactors(int n) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        return getFactors(n, map);
    }

    public List<List<Integer>> getFactors(int n, Map<Integer, List<List<Integer>>> map) {
        if(map.containsKey(n)) {
            return map.get(n);
        }

        List<List<Integer>> ans = new ArrayList<>();
        if(n==1) {
            map.put(n, ans);
            return ans;
        } else if(n==2 || n==3) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(n);
            ans.add(tmp);
            map.put(n, ans);
            return ans;
        }

        int i=2;
        int upper = (int)Math.sqrt(n);
        while(i<=upper) {
            if(n%i==0) {
                List<Integer> first = Arrays.asList(new Integer[]{i, n/i});
                ans.add(first);

                List<List<Integer>> cur = getFactors(n/i);

                for(List<Integer> tmp: cur) {
                    if(i>tmp.get(0) || (tmp.size()==1 && tmp.get(0)==n/i)) {
                        continue;
                    }

                    LinkedList<Integer> list = new LinkedList<>(tmp);

                    list.addFirst(i);
                    ans.add(list);
                }
            }

            i++;
        }

        map.put(n, ans);

        return ans;
    }

    public static void main(String args[]) {
        Factorization factorization = new Factorization();

        List<List<Integer>> ans =factorization.getFactors(6718464);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
