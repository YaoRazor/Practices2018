package stack;

import java.util.Stack;

public class SolveTheEquation {

    public String solveEquation(String equation) {

        // 先用等号split左右两边
        String[] arr = equation.split("=");

        Pair left = parseEquation(arr[0]);
        Pair right = parseEquation(arr[1]);

        if(left.coeffiecent==right.coeffiecent) {

            if(left.constNumber==right.constNumber) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }

        } else {
            return String.valueOf("x="+ (right.constNumber-left.constNumber)/(left.coeffiecent-right.coeffiecent));
        }

    }


    private Pair parseEquation(final String str) {

        // 需要一个symbol来记录正负号
        int symbol = 1;
        int i=0;
        // tmp用来parse数字
        int tmp = 0;

        // coeffiecent用来记录x的个数
        int coeffiecent = 0;

        // constNumber用来记录常数的个数
        int constNumber = 0;

        Stack<Integer> stack = new Stack<>();

        while(i<str.length()) {

            while(i<str.length() && Character.isDigit(str.charAt(i))) {
                tmp*=10;
                tmp+=str.charAt(i)-'0';
                i++;
            }

            if(tmp>0) {
                stack.push(tmp*symbol);
            }
            tmp = 0;

            if(i>=str.length()) {
                break;
            }


            if(str.charAt(i)=='x') {
                if(i>0 && Character.isDigit(str.charAt(i-1))) {
                    // Test case里有0x这种case
                    if(!stack.isEmpty()) {
                        coeffiecent+=stack.pop();
                    }
                } else {
                    coeffiecent+=1*symbol;
                }
            }

            if(str.charAt(i)=='+') {
                symbol = 1;
            }

            if(str.charAt(i)=='-') {
                symbol = -1;
            }

            i++;
        }

        while(!stack.isEmpty()) {
            constNumber+= stack.pop();
        }

        return new Pair(coeffiecent, constNumber);


    }


    class Pair {
        public int coeffiecent = 0;
        public int constNumber = 0;

        public Pair(final int coeffiecent, final int constNumber) {
            this.coeffiecent = coeffiecent;
            this.constNumber = constNumber;
        }

    }

}
