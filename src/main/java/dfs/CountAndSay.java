package dfs;

public class CountAndSay {
    public static String countAndSay(int n) {
        if(n==1) {
            return "1";
        }

        String preivous = "1";

        for(int i= 1; i<n; i++) {
            Character pre = preivous.charAt(0);
            int count = 1;
            StringBuilder builder = new StringBuilder();

            for(int j=1; j < preivous.length(); j++) {

                if(pre.equals(preivous.charAt(j))) {
                    count++;
                } else {
                    builder.append(count);
                    builder.append(pre);
                    pre = preivous.charAt(j);
                    count = 1;
                }
            }

            builder.append(count);
            builder.append(pre);

            preivous = builder.toString();
        }

        return preivous;

    }


    public static void main(String[] args){

        String s = countAndSay(4);
        return;
    }
}
