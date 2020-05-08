package ninechapter.binarysearch.optional;

public class DropEggs {
    // This problem is crap, but you can check out this https://www.youtube.com/watch?v=NGtt7GJ1uiM to
    // understand what exactly this problem means here
    public int dropEggs(int n) {
        return (int)Math.ceil(Math.sqrt(2d*n+0.25)-0.5);
    }
}
