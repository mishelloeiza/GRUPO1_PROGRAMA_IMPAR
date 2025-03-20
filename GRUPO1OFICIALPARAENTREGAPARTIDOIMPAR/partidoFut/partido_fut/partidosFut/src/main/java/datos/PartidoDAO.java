package datos;

import domain.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PartidoDAO {

    private static final String SQL_SELECT = "SELECT id, equipo, partidos_jugados, ganados, empatados, perdidos, goles_favor, goles_contra, puntos FROM resultados";
    private static final String SQL_INSERT = "INSERT INTO resultados( equipo, partidos_jugados, ganados, empatados, perdidos, goles_favor, goles_contra, puntos) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE resultados SET equipo=?, partidos_jugados=?, ganados=?, empatados=?, perdidos=?, goles_favor=?, goles_contra=?, puntos=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM resultados WHERE id=?";
    private static final String SQL_QUERY = "SELECT id, equipo, partidos_jugados, ganados, empatados, perdidos, goles_favor, goles_contra, puntos FROM resultados WHERE id = ?";

    // Método para contar el número de registros en la tabla 'resultados'
    public int countPartidos() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM resultados";  // Consulta para contar los registros
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);  // Obtener el conteo de registros
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return count;
    }

    // Método para insertar un partido, con validación para no permitir más de 6 registros
    public int insert(Partido partido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        // Verificar si ya hay 6 registros en la base de datos
        if (countPartidos() >= 6) {
            JOptionPane.showMessageDialog(null, "Ya se han registrado 6 partidos. No se pueden registrar más.");
            return 0;  // No insertar si ya hay 6 registros
        }

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, partido.getEquipo());
            stmt.setString(2, partido.getPartidos_jugados());
            stmt.setString(3, partido.getGanados());
            stmt.setString(4, partido.getEmpatados());
            stmt.setString(5, partido.getPerdidos());
            stmt.setString(6, partido.getGoles_favor());
            stmt.setString(7, partido.getGoles_contra());
            stmt.setString(8, partido.getPuntos());

            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    // Método para seleccionar los partidos
    public List<Partido> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Partido partido = null;
        List<Partido> partidos = new ArrayList<Partido>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String equipo = rs.getString("equipo");
                String partidos_jugados = rs.getString("partidos_jugados");
                String ganados = rs.getString("ganados");
                String empatados = rs.getString("empatados");
                String perdidos = rs.getString("perdidos");
                String goles_favor = rs.getString("goles_favor");
                String goles_contra = rs.getString("goles_contra");
                String puntos = rs.getString("puntos");

                partido = new Partido();
                partido.setId(id);
                partido.setEquipo(equipo);
                partido.setPartidos_jugados(partidos_jugados);
                partido.setGanados(ganados);
                partido.setEmpatados(empatados);
                partido.setPerdidos(perdidos);
                partido.setGoles_favor(goles_favor);
                partido.setGoles_contra(goles_contra);
                partido.setPuntos(puntos);

                partidos.add(partido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return partidos;
    }

    // Método para actualizar un partido
    public void update(Partido partidoAActualizar) {
        // Este método ya estaba generado en tu código original
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Método para eliminar todos los registros de la base de datos
    public void eliminarTodos() {
        String query = "DELETE FROM resultados";  // Consulta para eliminar todos los registros
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
}
