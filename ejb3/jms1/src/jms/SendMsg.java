/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

/**
 * Aplicação que envia uma mensagem dado o nome JNDI global da fábrica,
 * o nome JNDI global da fila e a mensagem a ser enviada (texto).
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public class SendMsg {

//    @Resource(mappedName = "MinhaFabrica")
    private static ConnectionFactory connectionFactory;
//    @Resource(mappedName = "MinhaFila")
    private static Queue queue;

    public static void main(String[] args) throws Exception {
        InitialContext ctx = new InitialContext();
        connectionFactory = (ConnectionFactory) ctx.lookup(args[0]);
        queue = (Queue) ctx.lookup(args[1]);

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer((Destination) queue);
            TextMessage message = session.createTextMessage(args[2]);
            producer.send(message);
            producer.close();
            session.close();
            connection.stop();
            connection.close();
        } catch (Exception e) {
            System.out.println("Houve uma excecao!!!!!");
            return;
        }
        System.out.println("Enviado: " + args[2]);
        System.exit(0);
    }
}
