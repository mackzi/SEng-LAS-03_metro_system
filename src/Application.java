import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Application {
    private ArrayList<String> ticketTypeList;
    private ArrayList<Record> records;

    public Application() {
        ticketTypeList = new ArrayList<>();
        records = new ArrayList<>();
    }

    public void initTicketTypeList() {
        ticketTypeList.add("S");
        ticketTypeList.add("D");
        ticketTypeList.add("W");
        ticketTypeList.add("M");
        ticketTypeList.add("Y");
    }

    public void generateRecords() {
        for (int i = 0;i < Configuration.instance.maximumNumberOfRecords;i++) {
            int randomWeekDay = Configuration.instance.randomNumberGenerator.nextInt(1,7);
            String randomTicketType = ticketTypeList.get(Configuration.instance.randomNumberGenerator.nextInt(0,ticketTypeList.size()-1));
            int randomSource = Configuration.instance.randomNumberGenerator.nextInt(1,100);

            int randomDestination;
            do {
                randomDestination = Configuration.instance.randomNumberGenerator.nextInt(1,100);
            } while (randomDestination == randomSource);

            boolean randomIsOffPeak = Configuration.instance.randomNumberGenerator.nextBoolean();

            Record record = new Record(i+1,randomWeekDay,randomTicketType,randomSource,randomDestination,randomIsOffPeak,Configuration.instance.randomNumberGenerator.nextInt(0,3));
            records.add(record);
        }
    }

    public void generateToCSVFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Configuration.instance.dataPath + "records.csv")));

            for (int i = 0;i < Configuration.instance.maximumNumberOfRecords;i++)
                bufferedWriter.write(records.get(i).toString() + Configuration.instance.lineSeparator);

            bufferedWriter.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String... args) {
        // Application application = new Application();
        // application.initTicketTypeList();
        // application.generateRecords();
        // application.generateToCSVFile();
    }
}