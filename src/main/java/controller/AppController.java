package controller;

import model.GestorTareas;
import model.Tarea;
import model.TareaDAO;
import view.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class AppController {
    private GestorTareas gestorTareas;
    private ConsoleView view;
    private TareaDAO tareaDAO;
    private Scanner scanner;

    public AppController(GestorTareas gestorTareas, ConsoleView view, TareaDAO tareaDAO) {
        this.gestorTareas = gestorTareas;
        this.view = view;
        this.tareaDAO = tareaDAO;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ingresarTarea();
                    break;
                case 2:
                    actualizarTarea();
                    break;
                case 3:
                    listarTareas();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void ingresarTarea() {
        System.out.print("Ingrese código: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese prioridad (alta, media, baja): ");
        String prioridad = scanner.nextLine();
        System.out.print("Ingrese estado (pendiente, en progreso, completada): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese fecha límite (YYYY-MM-DD): ");
        String fechaLimite = scanner.nextLine();
        System.out.print("Ingrese responsable: ");
        String responsable = scanner.nextLine();

        Tarea tarea = new Tarea(codigo, descripcion, prioridad, estado, fechaLimite, responsable);
        gestorTareas.agregarTarea(tarea);
        tareaDAO.agregarTarea(tarea);
    }

    private void actualizarTarea() {
        System.out.print("Ingrese código de la tarea: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese nueva descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese nueva prioridad (alta, media, baja): ");
        String prioridad = scanner.nextLine();
        System.out.print("Ingrese nuevo estado (pendiente, en progreso, completada): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese nueva fecha límite (YYYY-MM-DD): ");
        String fechaLimite = scanner.nextLine();
        System.out.print("Ingrese nuevo responsable: ");
        String responsable = scanner.nextLine();

        Tarea tarea = new Tarea(codigo, descripcion, prioridad, estado, fechaLimite, responsable);
        gestorTareas.actualizarTarea(codigo, descripcion, prioridad, estado, fechaLimite, responsable);
        tareaDAO.actualizarTarea(tarea);
    }

    private void listarTareas() {
        List<Tarea> tareas = tareaDAO.listarTareas();
        view.mostrarTareas(tareas);
    }
}