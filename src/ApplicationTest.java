import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    Application application = new Application();

    @Test
    public void doTest01() {
        assertEquals(1000000, application.executeSQL01());
    }

    @Test
    public void doTest02() {
        assertEquals(11135, application.executeSQL02());
    }

    @Test
    public void doTest03() {
        assertEquals(20634, application.executeSQL03());
    }

    @Test
    public void doTest04() {
        assertEquals(7187, application.executeSQL04());
    }

    @Test
    public void doTest05() {
        long long1 = 92607;
        long long2 = 83512;
        long long3 = 642154;

        assertTrue(application.executeSQL05().contains(long1));
        assertTrue(application.executeSQL05().contains(long2));
        assertTrue(application.executeSQL05().contains(long3));
    }

    @Test
    public void doTest06() {
        long long1 = 360163;
        long long2 = 422231;
        long long3 = 926865;
        long long4 = 618665;
        long long5 = 396282;
        long long6 = 873231;
        long long7 = 382998;

        assertTrue(application.executeSQL06().contains(long1));
        assertTrue(application.executeSQL06().contains(long2));
        assertTrue(application.executeSQL06().contains(long3));
        assertTrue(application.executeSQL06().contains(long4));
        assertTrue(application.executeSQL06().contains(long5));
        assertTrue(application.executeSQL06().contains(long6));
        assertTrue(application.executeSQL06().contains(long7));
    }

    @Test
    public void doTest07() {
        Map<Boolean, Long> test07 = new TreeMap<>();
        long long1 = 499551;
        long long2 = 500449;

        test07.put(false, long1);
        test07.put(true, long2);

        assertEquals(application.executeSQL07(), test07);
    }

    @Test
    public void doTest08() {
        Map<String, Long> test08 = new TreeMap<>();
        long long1 = 3464;
        long long2 = 3454;
        long long3 = 3401;
        long long4 = 3567;
        long long5 = 3413;

        test08.put("M", long1);
        test08.put("S", long2);
        test08.put("W", long3);
        test08.put("Y", long4);
        test08.put("D", long5);

        assertEquals(application.executeSQL08(), test08);
    }

    
}
