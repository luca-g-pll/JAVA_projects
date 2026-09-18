package senderPack;

public interface ICommandConsumer {

    public void calculate(String operator, int op1, int op2);

    public void close();


}
