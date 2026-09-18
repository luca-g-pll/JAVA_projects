package serv;

public interface ICommandConsumer {

    void diffFromNow(String date);

    void diffDates(String date);

    void daysOfWeek(String date);

    void close();

}
