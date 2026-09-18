
public interface ICommandConsumer {

    //metodi da implementare in application --> un metodo per ogni comando inseribile
    void maiuscolo(String message);
    void minuscolo(String message);
    void inversione(String message);
    void eliminaSpazi(String message);
    void eliminaVocali(String message);
    void eliminaConsonanti(String message);
    void close();
}
