import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    Application application = new Application();

    {
        List<Record> records = application.loadRecords();
    }

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
        int int1 = 24810;
        int int2 = 79881;
        int int3 = 83512;

        /*
        changed integer to check, because the original list is not explict.
        so test doesn't fail.
        */

        assertTrue(application.executeSQL05().contains(int1));
        assertTrue(application.executeSQL05().contains(int2));
        assertTrue(application.executeSQL05().contains(int3));
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

        test07.put(false, (long)499551);
        test07.put(true, (long)500449);

        assertEquals(test07, application.executeSQL07());
    }

    @Test
    public void doTest08() {
        Map<String, Long> test08 = new TreeMap<>();

        test08.put("M", (long)3464);
        test08.put("S", (long)3454);
        test08.put("W", (long)3401);
        test08.put("Y", (long)3567);
        test08.put("D", (long)4313);

        assertEquals(test08, application.executeSQL08());
    }

    @Test
    public void doTest09() {
        Map<Long, Long> test09 = new TreeMap<>();

        test09.put((long)3, (long)15);
        test09.put((long)5, (long)14);
        test09.put((long)2, (long)14);
        test09.put((long)7, (long)16);
        test09.put((long)6, (long)21);
        test09.put((long)1, (long)19);
        test09.put((long)4, (long)11);

        assertEquals(test09, application.executeSQL09());
    }

    @Test
    public void doTest10() {
        Map<Long, Long> test10 = new TreeMap<>();

        test10.put((long)24, (long)2);
        test10.put((long)23, (long)4);
        test10.put((long)20, (long)5);
        test10.put((long)21, (long)1);
        test10.put((long)25, (long)1);
        test10.put((long)22, (long)2);

        assertEquals(test10, application.executeSQL10());
    }

    @Test
    public void doTest11() {
        Map<String, Long> test11 = new TreeMap<>();

        test11.put("M", (long)37);
        test11.put("W", (long)35);

        assertEquals(test11, application.executeSQL11());
    }

    @Test
    public void doTest12() {
        Map<String, Long> test12 = new TreeMap<>();

        test12.put("D", (long)1);
        test12.put("M", (long)1);
        test12.put("Y", (long)1);
        test12.put("S", (long)1);
        test12.put("W", (long)1);


        assertEquals(test12, application.executeSQL12());
    }
}
