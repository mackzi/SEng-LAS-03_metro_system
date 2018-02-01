import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application implements IQuery{
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
        System.out.println("SQL  1: " + count);
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
        System.out.println("SQL  2: " + count);
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
        System.out.println("SQL  3: " + count);
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
        System.out.println("SQL  4: " + count);
        return count;
    }

    // id, where, in, order by desc limit
    public List<Integer> executeSQL05() {
        Comparator<Record> descendingComparator = (Record rec1, Record rec2) -> rec2.getDestination() - rec1.getDestination();
        records.sort(descendingComparator);

        List<Integer> result = records.stream()
                                      .filter(x -> ((x.getWeekDay() == 1) || (x.getWeekDay() == 2)) &&
                                              x.getTicketType().equals("S") &&
                                              x.getSource() == 10 &&
                                              x.getDestination() <= 50)
                                      .map(Record::getId)
                                      .limit(3)
                                      .collect(Collectors.toList());

        System.out.println("SQL  5: " + result);
        return result;
    }

    // id, where, in, order by desc, order by asc
    public List<Integer> executeSQL06() {
        Comparator<Record> ascendingComparator = Comparator.comparingInt(Record::getDestination);
        Comparator<Record> descendingComparator = (Record rec1, Record rec2) -> rec2.getSource() - rec1.getSource();
        records.sort(ascendingComparator);
        records.sort(descendingComparator);

        List<Integer> result = records.stream()
                                      .filter(x -> x.getWeekDay() == 7 &&
                                              x.getTicketType().equals("S") &&
                                             (x.getSource() == 1 || x.getSource() == 3) &&
                                             (x.getDestination() == 1 || x.getDestination() == 3 || x.getDestination() == 5) &&
                                              x.isOffPeak())
                                      .map(Record::getId)
                                      .collect(Collectors.toList());

        System.out.println("SQL  6: " + result);
        return result;
    }

    // count, group by
    public Map<Boolean, Long> executeSQL07() {

        Map<Boolean,Long> result = records.stream().collect(Collectors.partitioningBy(Record::isOffPeak,Collectors.counting()));

        System.out.println("SQL  7: " + result);
        return result;
    }

    // count, where, group by
    public Map<String, Long> executeSQL08() {

        Map<String, Long> result = records.stream()
                                          .filter(x -> x.getWeekDay() <= 5 &&
                                                  x.getSource() >= 5 &&
                                                  x.getSource() <= 20 &&
                                                  x.getDestination() >=5 &&
                                                  x.getDestination() <= 20)
                                          .collect(Collectors.groupingBy(Record::getTicketType, Collectors.counting()));

        System.out.println("SQL  8: " + result);
        return result;
    }

    // count, where, in, group by
    public Map<Integer, Long> executeSQL09() {
        Map<Integer, Long> result = records.stream()
                                           .filter(x -> x.getSource() == 3 &&
                                                  (x.getDestination() == 1 || x.getDestination() == 3 || x.getDestination() == 5) &&
                                                   x.isOffPeak())
                                           .collect(Collectors.groupingBy(Record::getWeekDay, Collectors.counting()));

        System.out.println("SQL  9: " + result);
        return result;
    }

    // count, where, not in, group by
    public Map<Integer, Long> executeSQL10() {

        Map<Integer, Long> result = records.stream()
                .filter(x -> !(x.getWeekDay() == 1 || x.getWeekDay() == 5 || x.getWeekDay() == 6 || x.getWeekDay() == 7) &&
                        x.getTicketType().equals("Y") &&
                        x.getSource() == 15 &&
                        x.getDestination() >= 20 &&
                        x.getDestination() <= 25 &&
                        x.isOffPeak())
                .collect(Collectors.groupingBy(Record::getDestination, Collectors.counting()));

        System.out.println("SQL 10: " + result);
        return result;
    }

    // sum, where, not in, in, group by
    public Map<String, Long> executeSQL11() {

        Map<String, Long> result = records.stream()
                .filter(x -> !(x.getWeekDay() == 1 || x.getWeekDay() == 5 || x.getWeekDay() == 6 || x.getWeekDay() == 7) &&
                        (x.getTicketType().equals("W") || x.getTicketType().equals("M")) &&
                        x.getSource() == 5 &&
                        x.getDestination() >= 5 &&
                        x.getDestination() <= 10 &&
                        !x.isOffPeak())
                .collect(Collectors.groupingBy(Record::getTicketType, Collectors.summingLong(Record::getNumberOfRegisteredChildren)));

        System.out.println("SQL 11: " + result);
        return result;
    }

    // avg, where, in, in, group by
    public Map<String, Long> executeSQL12() {

        Map<String, Long> result = records.stream()
                .filter(x -> x.getWeekDay() == 7 &&
                        (x.getSource() == 1 || x.getSource() == 5 || x.getSource() == 15 || x.getSource() == 90 || x.getSource() == 95 || x.getSource() == 100) &&
                        (x.getDestination() == 1 || x.getDestination() == 5 || x.getDestination() == 10 || x.getDestination() == 15 || x.getDestination() == 20 || x.getDestination() == 25))
                .collect(Collectors.groupingBy(Record::getTicketType,
                        Collectors.averagingInt(Record::getNumberOfRegisteredChildren)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().longValue()));

        System.out.println("SQL 12: " + result);
        return result;
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