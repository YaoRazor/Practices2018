package miscellaneous;

import org.junit.Test;

public class ExcelSheetColumnTitleTest {

    @Test
    public void test() {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

        String s = excelSheetColumnTitle.convertToTitleOriginal(1353);
//        String s = excelSheetColumnTitle.convertToTitle(1379);
    }
}
