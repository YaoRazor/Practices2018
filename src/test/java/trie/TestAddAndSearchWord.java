package trie;

import org.junit.Test;

public class TestAddAndSearchWord {


    @Test
    public void test() {

        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();

        addAndSearchWord.addWord("a");
        addAndSearchWord.addWord("a");
        addAndSearchWord.search(".a");

    }
}
