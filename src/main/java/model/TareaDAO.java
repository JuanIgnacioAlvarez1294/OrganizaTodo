package model;

import untils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {
    private Connection connection;

    public TareaDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public void agregarTarea(Tarea tarea) {
        String query = "INSERT INTO tareas (codigo, descripcion, prioridad, estado, fecha_limite, responsable) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tarea.getCodigo());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setString(3, tarea.getPrioridad());
            stmt.setString(4, tarea.getEstado());
            stmt.setDate(5, Date.valueOf(tarea.getFechaLimite()));
            stmt.setString(6, tarea.getResponsable());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarTarea(Tarea tarea) {
        String query = "UPDATE tareas SET descripcion = ?, prioridad = ?, estado = ?, fecha_limite = ?, responsable = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tarea.getDescripcion());
            stmt.setString(2, tarea.getPrioridad());
            stmt.setString(3, tarea.getEstado());
            stmt.setDate(4, Date.valueOf(tarea.getFechaLimite()));
            stmt.setString(5, tarea.getResponsable());
            stmt.setString(6, tarea.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarea> listarTareas() {
        List<Tarea> tareas = new ArrayList<>();
        String query = "SELECT * FROM tareas";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Tarea tarea = new Tarea(
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getString("prioridad"),
                        rs.getString("estado"),
                        rs.getDate("fecha_limite").toString(),
                        rs.getString("responsable")
                );
                tareas.add(tarea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareas;
    }
}