package array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class FizzBuzz {

    interface Rule{
        boolean apply(int i);
    }
    private Map<Rule, String> ruleContainers = new HashMap();
    private Set<Rule> rules  = new HashSet();

    public FizzBuzz() {
        addRule(i -> i % 15 == 0, "FizzBuzz");
        addRule(i -> i % 3 == 0, "Fizz");
        addRule(i -> i % 5 == 0, "Buzz");
    }

    public void addRule(Rule rule, String res) {
        rules.add(rule);
        ruleContainers.put(rule, res);
    }

    public String getValue(int i) {
        for (Rule rule : rules) {
            if (rule.apply(i)) {
                return ruleContainers.get(rule);
            }
        }
        return String.valueOf(i);
    }

    //then the origin code should be as follows:
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        for(int i = 1; i <= n; i++){
            res.add(getValue(i));
        }
        return res;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));

    }


//    public List<String> fizzBuzz(int n) {
//
//        List<String> ans = new ArrayList<>();
//
//        for(int i=1; i<=n; i++) {
//
//            if(i%3==0) {
//
//                if(i%5==0) {
//                    ans.add("FizzBuzz");
//                } else {
//                    ans.add("Fizz");
//                }
//
//            } else if(i%5==0) {
//                ans.add("Buzz");
//            } else {
//                ans.add(String.valueOf(i));
//            }
//
//        }
//
//        return ans;
//
//    }
}
