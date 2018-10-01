package airbnb;

import org.junit.Test;

public class IPToCIDRTest {


    @Test
    public void test() {

        IPToCIDR ipToCIDR = new IPToCIDR();

//        255.0.0.7

        ipToCIDR.ipToCIDR("255.0.0.7", 10);

    }
}
