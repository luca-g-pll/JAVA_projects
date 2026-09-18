package server;

public interface ICommandConsumer {

    public void calculate(String oper, int op1, int op2);

    public void close();
}