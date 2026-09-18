package serv;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.time.format.TextStyle;

public class AppicationDate implements ICommandConsumer{

    SenderProtocol sender;
    String formatoData = "yyyy-mm-dd";

    public AppicationDate(SenderProtocol s){
        this.sender = s;
    }

    @Override
    public void diffFromNow(String date) {
        try {
            LocalDate.parse(date);//se si parsa senza problemi allora il formato è corretto
            String[] splitDate = date.split("-");

            LocalDate istanteAttuale = LocalDate.now();
            LocalDate dataSpecifica = LocalDate.of(
                    Integer.parseInt(splitDate[0]),
                    Integer.parseInt(splitDate[1]),
                    Integer.parseInt(splitDate[2]));

            // Ottieni il momento istantaneo (data e ora attuale)

            //Period giorni = Period.between(dataSpecifica, LocalDate.from(istanteAttuale));
            //int day = giorni.getDays(); //giorni tradotti in int da period

            String dayString = String.valueOf(dataSpecifica.until(istanteAttuale).getDays());// oppure --> String.valueOf(giorni.getDays());
            sender.buildMessage("diffFromNow", date, dayString);

        }catch (DateTimeParseException e){
            //nel caso non sia una stringa adatta al formato per la data, entra nell'eccezione
            sender.buildErrorFormat(date);
        }
    }


    @Override
    public void diffDates(String date) {
        //splittare le date da un  ' | '
        String[] splitDate=date.split("|");

        try{
        LocalDate.parse(splitDate[0]);
        String[] dataDivisa1 =splitDate[0].split("-");

        LocalDate.parse(splitDate[1]);
        String[] dataDivisa2 = splitDate[1].split("-");

        LocalDate data1 = LocalDate.of(
                Integer.parseInt(dataDivisa1[0]),
                Integer.parseInt(dataDivisa1[1]),
                Integer.parseInt(dataDivisa1[2]));

        LocalDate data2 = LocalDate.of(
                Integer.parseInt(dataDivisa2[0]),
                Integer.parseInt(dataDivisa2[1]),
                Integer.parseInt(dataDivisa2[2]));

        //giorni di differenza tra prima e seconda data
        String daysDifference = String.valueOf(data1.until(data2).getDays());

        daysDifference += " giorni di differenza";
        sender.buildMessage("DiffDate", date, daysDifference);

        } catch (DateTimeParseException e){
            sender.buildErrorFormat(date);
        }
    }

    @Override
    public void daysOfWeek(String data) {

        try {
            LocalDate.parse(data);//se si parsa senza problemi allora il formato è corretto
            String[] splitDate = data.split("-");

            LocalDate date = LocalDate.of(
                    Integer.parseInt(splitDate[0]),
                    Integer.parseInt(splitDate[1]),
                    Integer.parseInt(splitDate[2]));

            String giornoSettimana = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);//??

            sender.buildMessage("DayOfWeek", data, giornoSettimana);

        }catch (DateTimeParseException e){
            sender.buildErrorFormat(data);
        }
    }

    @Override
    public void close() {
        sender.close("quit#quit");
    }
}
