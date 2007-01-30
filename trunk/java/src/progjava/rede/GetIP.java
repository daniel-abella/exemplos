package progjava.rede;

import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public final class GetIP {
    private GetIP() {
    }

    public static void main(final String[] args) {
        String machineName;

        machineName = JOptionPane.showInputDialog("Nome da máquina:");

        if (machineName == null) {
            machineName = "software.inf.ufg.br";
        }

        try {
            System.out.println(machineName);
            System.out.println(InetAddress.getByName(machineName));
        } catch (IOException ioe) {
        } finally {
            System.exit(0);
        }
    }
}