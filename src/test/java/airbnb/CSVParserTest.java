package airbnb;

import org.junit.Test;

public class CSVParserTest {

    CSVParser csvParser = new CSVParser();


    @Test
    public void test() {

//        String result1 = csvParser.parseString("John,Smith,john.smith@gmail.com,Los Angeles,1");
        String result2 = csvParser.parseString("" +
                "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1");

        System.out.println(result2);

        return;

    }

//    @Test
//    public void printBackslash() {
//
//        System.out.println('');
//    }
}
