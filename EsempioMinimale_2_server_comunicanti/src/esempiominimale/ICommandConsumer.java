/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package esempiominimale;

/**
 *
 * @author MULTI01
 */
public interface ICommandConsumer {

    void error(int code);

    void login(String username);

    void logout();

    void message(String message);

    void close();

}
