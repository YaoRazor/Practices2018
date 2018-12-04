package amazon;

import org.junit.Test;

public class SubstringKDistinctCharactersTest {


    @Test
    public void test() {

        SubstringKDistinctCharacters sol = new SubstringKDistinctCharacters();
        System.out.println(sol.findSubstringKDistinct("abccdef", 2));
        System.out.println(sol.findSubstringKDistinct("awaglknagawunagwkwagl", 4));
        System.out.println(sol.findSubstringKDistinct("", 1));
        System.out.println(sol.findSubstringKDistinct("aaaaaaa", 2));
        System.out.println(sol.findSubstringKDistinct("aaaaaaa", 1));
        System.out.println(sol.findSubstringKDistinct(null, 1));
        System.out.println(sol.findSubstringKDistinct(null, -1));
        System.out.println(sol.findSubstringKDistinct("aaaabbb", 0));


    }


}
