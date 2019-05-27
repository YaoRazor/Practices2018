package design;


class Vector2D {

    private int i=0;
    private int j=0;
    private int[][] v;

    public Vector2D(int[][] v) {
        i = 0;
        j = 0;
        this.v = v;
    }

    public int next() {
        if(hasNext()) {
            return v[i][j++];
        }

        throw new RuntimeException();
    }

    public boolean hasNext() {
        if(v==null || v.length==0) {
            return false;
        }

        if(j<v[i].length) {
            return true;
        } else {

            while(i<v.length-1) {
                i++;
                if(v[i]==null || v[i].length==0) {
                    continue;
                } else {
                    j = 0;
                    return true;
                }
            }

            return false;
        }
    }
}
