import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

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
        long count = records.stream()
                            .count();
        System.out.println("SQL 1: " + count);
        return count;
    }

    // count, where
    public long executeSQL02() {
        long count = records.stream()
                            .filter(x -> x.getWeekDay() <= 5 &&
                                         x.getSource() >= 50 &&
                                         x.getSource() <= 75 &&
                                         x.getDestination() >= 25 &&
                                         x.getDestination() <= 30)
                            .count();
        System.out.println("SQL 2: " + count);
        return count;
    }

    // count, where, in
    public long executeSQL03() {
        long count = records.stream()
                            .filter(x -> (x.getTicketType().equals("W") || x.getTicketType().equals("M") || x.getTicketType().equals("Y")) &&
                                    x.getSource() >= 25 &&
                                    x.getSource() <= 50 &&
                                    x.getDestination() >= 50 &&
                                    x.getDestination() <= 75 &&
                                    x.isOffPeak())
                            .count();
        System.out.println("SQL 3: " + count);
        return count;
    }

    // count, where, not in
    public long executeSQL04() {
        long count = records.stream()
                            .filter(x -> (!x.getTicketType().equals("M") && !x.getTicketType().equals("Y")) &&
                                    x.getSource() >= 5 &&
                                    x.getSource() <= 20 &&
                                    x.getDestination() >= 5 &&
                                    x.getDestination() <= 20 &&
                                    !x.isOffPeak())
                            .count();
        System.out.println("SQL 4: " + count);
        return count;
    }

    // id, where, in, order by desc limit
    public List<Integer> executeSQL05() {
        Comparator<Record> descendingComparator = (Record rec1, Record rec2) -> (rec2.getDestination() - rec1.getDestination());
        Collections.sort(records, descendingComparator);

        List<Integer> result = records.stream()
                .filter(x -> (x.getWeekDay() == 1) || (x.getWeekDay() == 2) &&
                        x.getTicketType().equals("S") &&
                        x.getSource() == 10 &&
                        x.getDestination() <= 50)
                .limit(3)
                .map(x -> x.getId()).collect(Collectors.toList());

        System.out.println(result);

        return result;
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