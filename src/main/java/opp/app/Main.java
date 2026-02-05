package opp.app;

import javax.swing.SwingUtilities;
import opp.View.VistaLogin;




public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VistaLogin login = new VistaLogin();
                login.setVisible(true);
            }
        });
    }
    
}
