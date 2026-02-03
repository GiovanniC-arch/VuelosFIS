package app;

import DAO.VueloArchivoDAO;
import Service.VueloService;
import Service.VueloServiceImpl;
import opp.Controller.VueloController;
import opp.View.VistaMain;

public class Main {

    public static void main(String[] args) {

        // DAO
        VueloArchivoDAO vueloDAO = new VueloArchivoDAO();

        // Service
        VueloService vueloService = new VueloServiceImpl(vueloDAO);

        // Controller
        VueloController controller = new VueloController(vueloService);

        // Vista
        java.awt.EventQueue.invokeLater(() -> {
            new VistaMain(controller).setVisible(true);
        });
    }
}
