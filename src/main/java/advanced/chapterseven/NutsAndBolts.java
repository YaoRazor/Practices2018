package advanced.chapterseven;

public class NutsAndBolts {

    interface NBComparator {
      public int cmp(String a, String b);
    }

    // TC: nlog(n), space O(1). non-stable sort
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if(nuts==null || nuts.length==0 || bolts==null || bolts.length==0 || nuts.length!=bolts.length) {
            return;
        }

        quickSort(nuts, bolts, compare, 0, nuts.length-1);
    }

    private void quickSort(String[] nuts, String[] bolts, NBComparator compare, int start, int end) {
        if(start>=end) {
            return;
        }

        int index = partition(bolts, nuts[start], compare, start, end);
        partition(nuts, bolts[index], compare, start, end);

        quickSort(nuts, bolts, compare, start, index-1);
        quickSort(nuts, bolts, compare, index+1, end);
    }

    private void swap(String[] array, int left, int right) {
        String tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }


    private int partition(String[] nutsOrBolts, String pivot, NBComparator compare, int start, int end) {
        for(int i=start; i<=end; i++) {
            if(compare.cmp(nutsOrBolts[i], pivot)==0 || compare.cmp(pivot, nutsOrBolts[i])==0) {
                swap(nutsOrBolts, start, i);
            }
        }

        int left = start;
        for(int i = start+1; i<=end; i++) {
            if(compare.cmp(nutsOrBolts[i], pivot)==-1 || compare.cmp(pivot, nutsOrBolts[i])==1) {
                swap(nutsOrBolts, ++left, i);
            }
        }
        swap(nutsOrBolts, left, start);
        return left;
    }
}
