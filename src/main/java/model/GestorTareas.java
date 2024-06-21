package model;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> listaTareas;

    public GestorTareas() {
        this.listaTareas = new ArrayList();
    }

    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    public void actualizarTarea(String codigo, String descripcion, String prioridad, String estado, String fechaLimite, String responsable) {
        for (Tarea tarea : listaTareas) {
            if (tarea.getCodigo().equals(codigo)) {
                tarea.setDescripcion(descripcion);
                tarea.setPrioridad(prioridad);
                tarea.setEstado(estado);
                tarea.setFechaLimite(fechaLimite);
                tarea.setResponsable(responsable);
                break;
            }
        }
    }

    public List<Tarea> listarTareas() {
        return listaTareas;
    }
}