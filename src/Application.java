import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    private List<Record> records = new ArrayList<>();

    public List<Record> loadRecords() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Configuration.instance.dataPath+"records.csv"));
            String read;
            while((read = br.readLine()) != null) {
                String[] temp = read.split(";");
                records.add(new Record(Integer.parseInt(temp[0]),
                        Integer.parseInt(temp[1]),
                        temp[2],
                        Integer.parseInt(temp[3]),
                        Integer.parseInt(temp[4]),
                        Boolean.parseBoolean(temp[5]),
                        Integer.parseInt(temp[6])));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // count
    public long executeSQL01() {
        long count = records.stream().count();
        System.out.println(count);
        return count;
    }

    // count, where
    public long executeSQL02() {
        long count = 0;
        System.out.println(count);
        return count;
    }

    // count, where, in
    public long executeSQL03() {
        return 0;
    }

    // count, where, not in
    public long executeSQL04() {
        return 0;
    }

    // id, where, in, order by desc limit
    public List<Long> executeSQL05() {
        return null;
    }

    // id, where, in, order by desc, order by asc
    public List<Long> executeSQL06() {
        return null;
    }

    // count, group by
    public Map<Boolean, Long> executeSQL07() {
        return null;
    }

    // count, where, group by
    public Map<String, Long> executeSQL08() {
        return null;
    }

    // count, where, in, group by
    public Map<Long, Long> executeSQL09() {
        return null;
    }

    // count, where, not in, group by
    public Map<Long, Long> executeSQL10() {
        return null;
    }

    // sum, where, not in, in, group by
    public Map<String, Long> executeSQL11() {
        return null;
    }

    // avg, where, in, in, group by
    public Map<String, Long> executeSQL12() {
        return null;
    }

    public void execute() {
        loadRecords();
        executeSQL01();
        executeSQL02();
        executeSQL03();
        executeSQL04();
        executeSQL05();
        executeSQL06();
        executeSQL07();
        executeSQL08();
        executeSQL09();
        executeSQL10();
        executeSQL11();
        executeSQL12();
    }

    public static void main(String... args) {
        Application application = new Application();
        application.execute();
    }
}