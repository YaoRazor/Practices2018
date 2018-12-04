package airbnb;

import java.util.*;

class StreamIterator {

    class Point {

        int value;
        int index;

        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }

    List<Iterator<Integer>> iterators = new ArrayList<>();

    PriorityQueue<Point> pq;

    public StreamIterator(List<List<Integer>> integerList) {

        pq = new PriorityQueue<>(



                Comparator.comparingInt(a->a.value)



        );


        for(List<Integer> l: integerList) {

            if(l!=null) {
                iterators.add(l.iterator());
            }

        }


        for(int i=0; i<iterators.size(); i++) {

            Iterator<Integer> iterator = iterators.get(i);



            if(iterator.hasNext())  {


                pq.offer(new Point(iterator.next(), i));

            }

        }


    }


    public boolean hasNext() {

        return !pq.isEmpty();

    }

    public int next() {


        Point point = pq.poll();

        int ans = point.value;

        int index = point.index;

        Iterator<Integer> iterator = iterators.get(index);

        if(iterator.hasNext()) {
            pq.offer(new Point(iterator.next(), index));

        }


        return ans;

    }




}


// I lost you
class Solution {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(5);
        list2.add(12);


        List<List<Integer>> input = new ArrayList<>();

        input.add(list1);
        input.add(list2);

        StreamIterator streamIterator = new StreamIterator(input);

        while (streamIterator.hasNext()) {

            System.out.println(streamIterator.next());

        }


    }
}
