package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

/**
 * Aplicação que recebe uma mensagem dado o nome JNDI global da fábrica e
 * o nome JNDI global da fila onde a mensagem (text) foi enviada. A aplicação
 * aguarda até que uma mensagem seja disponibilizada.
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public class ReceiveMsg {

//    @Resource(mappedName = "MinhaFabrica")
    private static ConnectionFactory connectionFactory;
//    @Resource(mappedName = "MinhaFila")
    private static Queue queue;

    public static void main(String[] args) throws Exception {
        InitialContext ctx = new InitialContext();
        connectionFactory = (ConnectionFactory) ctx.lookup(args[0]);
        queue = (Queue) ctx.lookup(args[1]);

        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer((Destination) queue);
        connection.start();
        TextMessage message = (TextMessage) consumer.receive();
        System.out.println("Recebido: " + message.getText());
        session.close();
        connection.stop();
        connection.close();
        System.exit(0);
    }
}
