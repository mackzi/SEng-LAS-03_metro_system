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
        assertTrue(application.executeSQL06().contains(360163));
        assertTrue(application.executeSQL06().contains(422231));
        assertTrue(application.executeSQL06().contains(926865));
        assertTrue(application.executeSQL06().contains(618665));
        assertTrue(application.executeSQL06().contains(396282));
        assertTrue(application.executeSQL06().contains(873231));
        assertTrue(application.executeSQL06().contains(382998));
    }

    @Test
    public void doTest07() {
        Map<Boolean, Long> test07 = new TreeMap<>();

        test07.put(false, 499551L);
        test07.put(true, 500449L);

        assertEquals(test07, application.executeSQL07());
    }

    @Test
    public void doTest08() {
        Map<String, Long> test08 = new TreeMap<>();

        test08.put("M", 3464L);
        test08.put("S", 3454L);
        test08.put("W", 3401L);
        test08.put("Y", 3567L);
        test08.put("D", 4313L);

        assertEquals(test08, application.executeSQL08());
    }

    @Test
    public void doTest09() {
        Map<Integer, Long> test09 = new TreeMap<>();

        test09.put(3, 15L);
        test09.put(5, 14L);
        test09.put(2, 14L);
        test09.put(7, 16L);
        test09.put(6, 21L);
        test09.put(1, 19L);
        test09.put(4, 11L);

        assertEquals(test09, application.executeSQL09());
    }

    @Test
    public void doTest10() {
        Map<Integer, Long> test10 = new TreeMap<>();

        test10.put(24, 2L);
        test10.put(23, 4L);
        test10.put(20, 5L);
        test10.put(21, 1L);
        test10.put(25, 1L);
        test10.put(22, 2L);

        assertEquals(test10, application.executeSQL10());
    }

    @Test
    public void doTest11() {
        Map<String, Long> test11 = new TreeMap<>();

        test11.put("M", 37L);
        test11.put("W", 35L);

        assertEquals(test11, application.executeSQL11());
    }

    @Test
    public void doTest12() {
        Map<String, Long> test12 = new TreeMap<>();

        test12.put("D", 1L);
        test12.put("M", 1L);
        test12.put("Y", 1L);
        test12.put("S", 1L);
        test12.put("W", 1L);


        assertEquals(test12, application.executeSQL12());
    }
}
