/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javax.microedition.rms.RecordStore;

/**
 *
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public class Servicos {

    public static String rms1() {
        int size = -1;
        try {
            RecordStore rs = RecordStore.openRecordStore("teste", true);
            size = rs.getSizeAvailable();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Integer.toString(size);
    }
}
