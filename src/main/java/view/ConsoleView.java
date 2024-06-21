package view;

import model.Tarea;

import java.util.List;

public class ConsoleView {

    public void mostrarMenu() {
        System.out.println("1. Ingresar nueva tarea");
        System.out.println("2. Actualizar tarea existente");
        System.out.println("3. Listar tareas");
        System.out.println("4. Salir");
    }

    public void mostrarTareas(List<Tarea> tareas) {
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }
}