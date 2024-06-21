import controller.AppController;
import model.GestorTareas;
import model.TareaDAO;
import view.ConsoleView;

public class App {
    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();
        ConsoleView view = new ConsoleView();
        TareaDAO tareaDAO = new TareaDAO();
        AppController controller = new AppController(gestorTareas, view, tareaDAO);

        controller.iniciar();
    }
}