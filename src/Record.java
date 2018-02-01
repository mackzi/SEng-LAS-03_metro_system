public class Record {
    private int id;
    private int weekDay;
    private String ticketType;
    private int source;
    private int destination;
    private boolean isOffPeak;
    private int numberOfRegisteredChildren;

    public Record(int id,int weekDay,String ticketType,int source,int destination,boolean isOffPeak,int numberOfRegisteredChildren) {
        this.id = id;
        this.weekDay = weekDay;
        this.ticketType = ticketType;
        this.source = source;
        this.destination = destination;
        this.isOffPeak = isOffPeak;
        this.numberOfRegisteredChildren = numberOfRegisteredChildren;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id).append(";").append(weekDay).append(";").append(ticketType).append(";");
        stringBuilder.append(source).append(";").append(destination).append(";").append(isOffPeak).append(";");
        stringBuilder.append(numberOfRegisteredChildren);
        return stringBuilder.toString();
    }
}