import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
    public void executeSQL01() {
    }

    // count, where
    public void executeSQL02() {
    }

    // count, where, in
    public void executeSQL03() {
    }

    // count, where, not in
    public void executeSQL04() {
    }

    // id, where, in, order by desc limit
    public void executeSQL05() {
    }

    // id, where, in, order by desc, order by asc
    public void executeSQL06() {
    }

    // count, group by
    public void executeSQL07() {
    }

    // count, where, group by
    public void executeSQL08() {
    }

    // count, where, in, group by
    public void executeSQL09() {
    }

    // count, where, not in, group by
    public void executeSQL10() {
    }

    // sum, where, not in, in, group by
    public void executeSQL11() {
    }

    // avg, where, in, in, group by
    public void executeSQL12() {
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