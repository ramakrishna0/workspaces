import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyFuture {


    public MyFuture() {
    }


    public Set<Integer> trial1 () throws InterruptedException {
        System.out.println("trial1 sleep");
        Thread.sleep(2000);
        System.out.println(("trial1 active"));
        return new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3, 4}));
    }

    public Set<Integer> trial2 () throws InterruptedException {
        System.out.println("trial2 sleep");
        Thread.sleep(500);
        System.out.println(("trial2 active"));
        return new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
    }


}
