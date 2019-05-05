package airbnb;


import java.util.HashMap;
import java.util.Map;

//create(path, value), set(path, value), get(path), watch(path, callback)
//
//Example
//create("/a",1)
//get("/a") //得到1
//create("/a/b",2)
//get("/a/b") //得到2
//create("/c/d",1) //Error，因为它的上一级“/c”并不存在
//get("/c") //Error,因为“/c”不存在
//
//follow up是写一个watch函数，比如watch("/a",new Runnable(){System.out.println("helloword");})后，
//每当create("/a/b"，1) 等在/a之下的目录不产生error的话，都会执行绑在“/a”上的callback函数
//
//比如 watch("/a",System.out.println("yes"))
//watch("/a/b",System.out.println("no"))
//当create("/a/b/c",1)时，两个callback函数都会被触发，会output yes 和no

public class FileSystem {

    Map<String, Integer> inMemoryFileSystem = new HashMap<>();
    Map<String, Runnable> callBackMap = new HashMap<>();


    public FileSystem() {
        inMemoryFileSystem.put("", 0);
    }

    //
    public boolean create(final String path, final int value) {

        if(inMemoryFileSystem.containsKey(path)) {
            return false;
        }

        String parent = path.substring(0, path.lastIndexOf('/'));

        if(!inMemoryFileSystem.containsKey(parent)) {
            return false;
        }

        inMemoryFileSystem.put(path, value);
        return true;
    }


    public int get(final String path) {

        if(!inMemoryFileSystem.containsKey(path)) {
            return -1;
        } else {
            return inMemoryFileSystem.get(path);
        }

    }


    public boolean set(String path, final int value) {

        if(!inMemoryFileSystem.containsKey(path)) {
            return false;
        }

        inMemoryFileSystem.put(path, value);

        while (!"".equals(path)) {

            if(callBackMap.containsKey(path)) {
                callBackMap.get(path).run();
            }
            path = path.substring(0, path.lastIndexOf('/'));
        }

        return true;
    }

    public boolean watch(String path, Runnable callback) {
        if (!inMemoryFileSystem.containsKey(path)) {
            return false;
        }

        callBackMap.put(path, callback);
        return true;
    }


}
