package dropbox;

import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebCrawler {

}

class BlockingQueue {

    private List<String> queue = new LinkedList<>();
    private int  limit = 10; // Default value

    public BlockingQueue(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(String item)
            throws InterruptedException  {
        while(this.queue.size() == this.limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized String dequeue()
            throws InterruptedException{
        while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);
    }

}



class CrawlerWorker implements Runnable {

    BlockingQueue blockingQueue;
    private final AtomicBoolean stopped = new AtomicBoolean(false);
    private final ConcurrentHashMap<String, Boolean> concurrentHashMap;


    public CrawlerWorker(final BlockingQueue blockingQueue, final ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        this.blockingQueue = blockingQueue;
        this.concurrentHashMap = concurrentHashMap;
    }


    public void stop() {
        stopped.set(true);
    }


    @Override
    public void run() {

//            final String className = this.getClass().getName();
//            LOGGER.info()
//                  .setEvent("RedisQueueProcessor.run")
//                  .addContext("processor", className)
//                  .log();
            while (!stopped.get()) {

                       try {
                        String url = blockingQueue.dequeue();
                        List<String> urls = handleMessage(url);

                        for(String newUrl: urls)  {
                            if(!concurrentHashMap.containsKey(newUrl)) {
                                blockingQueue.enqueue(newUrl);
                            }
                        }

                        }
                        catch (Exception e) {

                        }
            }

        }


        private List<String> handleMessage(final String url) throws IOException {

            // There will be two steps here
            // Parse url and save content to db
            // get List of sub urls out and return;
            concurrentHashMap.put(url, true);
            return parse(url);
        }

        private List<String> parse(final String url) {

            return ImmutableList.of();
        }

}




class MyWaitNotify3{

    class MonitorObject {

    }

    MonitorObject myMonitorObject = new MonitorObject();
    boolean wasSignalled = false;

    // wait and notify必须被synchronized这个关键词包裹着
    public void doWait(){
        //
        synchronized(myMonitorObject){
            while(!wasSignalled){
                try{
                    myMonitorObject.wait();
                } catch(InterruptedException e){
                    // Logic to handle Interruptedexception
                }
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }

    public void doNotify(){
        synchronized(myMonitorObject){
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
}
