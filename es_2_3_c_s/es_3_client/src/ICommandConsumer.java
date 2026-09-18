public interface ICommandConsumer {

    //metodi da implementare in application --> un metodo per ogni comando inseribile

    void show(String command, String string);
    void close();
}
