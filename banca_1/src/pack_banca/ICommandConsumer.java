package pack_banca;
/*
 * Pillitu Luca
 * ICommandConsumer : interfaccia - da implementare nell'application
 *
 */

public interface ICommandConsumer {
    void login(String username,String password);

    void getSaldo(); //restituisce il saldo del conto
    void getEstratto(String movimenti);//-->int movimenti
    void doVersamento(String importo);//-->double importo
    void doPrelievo(String importo);//-->double importo
    void bonifico(String importo,String iban);//-->double importo
    void searchMovimento(String data1,String data2);//-->controllare date

    void error(int code);//-->int
    void close();
}
