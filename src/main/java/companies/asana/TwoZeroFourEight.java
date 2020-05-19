package companies.asana;

import java.util.*;

import static companies.asana.TwoZeroFourEight.DIRECTION.LEFT;
import static companies.asana.TwoZeroFourEight.DIRECTION.UP;


public class TwoZeroFourEight {

    class Cell {
        int value;

        public boolean merge(Cell c2) {
            if(c2.value==this.value && c2.value!=0) {
                this.value = 2*this.value;
                c2.value = 0;
                return true;
            }

            return false;
        }

    }

    class Pair {
        int start;
        int step;

        public Pair(int start, int step) {
            this.start = start;
            this.step = step;
        }
    }

    enum DIRECTION {
        LEFT, RIGHT, UP, DOWN;
    }


    class Board {
        Cell[][] data= new Cell[4][4];

        Pair positiveDirection = new Pair(0, 1);
        Pair negativerightDirection = new Pair(3, -1);


        public Pair getPair(DIRECTION direction) {
            if(LEFT.equals(direction) || UP.equals(direction)) {
                return positiveDirection;
            } else {
                return negativerightDirection;
            }

        }

        public void merge(DIRECTION direction) {
            Pair order = getPair(direction);
            if(LEFT.equals(direction) || DIRECTION.RIGHT.equals(direction)) {

                for(int i=0; i<4; i++) {
                    List<Integer> tmp = new LinkedList<>();
                    for(int j=order.start; j<4 && j>=0; j+=order.step) {
                        if(data[i][j].value!=0) {
                            tmp.add(data[i][j].value);
                        }

                        for(int k=0; i<tmp.size()-1; k++) {
                            if(tmp.get(k)!=tmp.get(k+1)){
                                continue;
                            }

                            tmp.set(k, tmp.get(k)*2);
                            tmp.remove(k+1);
                            break;
                        }

                        for(int k=0; i<tmp.size(); k++) {
                            data[i][j].value = tmp.get(i);
                        }
                    }
                }

            } else {

                for(int i=0; i<4; i++) {
                    List<Integer> tmp = new LinkedList<>();
                    for(int j=order.start; j<4 && j>=0; j+=order.step) {
                        if(data[j][i].value!=0) {
                            tmp.add(data[i][j].value);
                        }

                        for(int k=0; i<tmp.size()-1; k++) {
                            if(tmp.get(k)!=tmp.get(k+1)){
                                continue;
                            }

                            tmp.set(k, tmp.get(k)*2);
                            tmp.remove(k+1);
                            break;
                        }

                        for(int k=0; i<tmp.size(); k++) {
                            data[j][i].value = tmp.get(i);
                        }
                    }
                }


            }


        }





    }


}
