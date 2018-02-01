import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ApplicationTest {

    Application application = new Application();

    @Before
    public void init() {
        List<Record> records = new ArrayList<>(application.loadRecords());
    }

    @Test
    public void doTest01() {
        assertEquals(1000000, application.executeSQL01());
    }

    @Test
    public void doTest02() {
        
    }


}
