package dropbox;

import org.junit.Test;

public class DesignPhoneDirectoryTest {


    @Test
    public void test() {
        DesignPhoneDirectory designPhoneDirectory = new DesignPhoneDirectory(5);

        designPhoneDirectory.get();
        designPhoneDirectory.get();
        designPhoneDirectory.get();


        System.out.println(designPhoneDirectory.check(4));
        System.out.println(designPhoneDirectory.check(1));

    }
}
