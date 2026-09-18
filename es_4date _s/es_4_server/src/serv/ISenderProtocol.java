package serv;

public interface ISenderProtocol {

    public void buildMessage(String cmd, String date, String result);

    public void buildErrorCmd(String errore);

    public void buildErrorFormat(String errore);

    public void close(String forClose);

}
