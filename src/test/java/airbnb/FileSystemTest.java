package airbnb;

import org.junit.Test;

public class FileSystemTest {


    @Test
    public void test() {

        FileSystem fs = new FileSystem();
        System.out.println(fs.get("/a")); // -1
        System.out.println(fs.set("/a", 2)); // false
        System.out.println(fs.create("/a", 1)); // true
        System.out.println(fs.get("/a")); // 1
        System.out.println(fs.create("/a/b", 2)); // true
        System.out.println(fs.create("/b/c", 3)); // false
        System.out.println(fs.watch("/a/b", () -> {
            System.out.println("callback on /a/b");
//                System.exit(0);
        }));
        System.out.println(fs.watch("/a", () -> {
            System.out.println("callback on /a");
//            System.exit(0);
        }));
        System.out.println(fs.set("/a/b", 10)); // trigger 2 callbacks and true
    }


}
