public interface ISenderProtocol {

    public void buildMessage(String cmd, String convert);
    public void close(String forClose);
}
