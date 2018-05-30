package miscellaneous;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yawang on 4/12/18.
 */
public class ExcelSheetColumnNumberTest {

    @Test
    public void test() {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();


        assertEquals(52, excelSheetColumnNumber.titleToNumber("AZ"));

    }
}
