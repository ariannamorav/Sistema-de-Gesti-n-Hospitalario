package caso_hospital;

import java.sql.*;
import java.util.ArrayList;

public class CLASSX {
    
    private Connection conexionBD = null;

    // Constructor
    public CLASSX() {
        this.conexionBD = conectar(); 
       
    }

    // Método para validar ID de Paciente
    public boolean validarIdPaciente(int idPaciente) {
        String query = "SELECT COUNT(*) FROM Paciente WHERE ID_Paciente = ?";
        try (PreparedStatement pstmt = conexionBD.prepareStatement(query)) {
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si hay al menos un registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;     
    }
    
    public ArrayList<String> obtenerPacientes() {
        ArrayList<String> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";
        
        try (Statement statement = conexionBD.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                int idPaciente = resultSet.getInt("ID_Paciente");
                String nombre = resultSet.getString("Nombre");
                int numeroSeguro = resultSet.getInt("Numero_Seguro");
                Date fechaNacimiento = resultSet.getDate("Fecha_Nacimiento");

                String paciente = "ID: " + idPaciente + ", Nombre: " + nombre + 
                                  ", Seguro: " + numeroSeguro + 
                                  ", Fecha Nacimiento: " + fechaNacimiento.toString();
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los pacientes: " + e.getMessage());
        }
        
        return pacientes;
    }
    
        public ArrayList<String> obtenerMedicos() {
        ArrayList<String> medicos = new ArrayList<>();
        String sql = "SELECT * FROM Medico";
    
    try (Statement statement = conexionBD.createStatement();
         ResultSet rs = statement.executeQuery(sql)) {
        
        while (rs.next()) {
            int idMedico = rs.getInt("ID_Medico");
            String nombre = rs.getString("Nombre");
            String colegiatura = rs.getString("Numero_Colegiatura");
            String especialidad = rs.getString("Especialidad");
            
            String medico = "ID: " + idMedico + ", Nombre: " + nombre + ", Colegiatura: " + colegiatura + ", Especialidad: " + especialidad;
            medicos.add(medico);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener médicos: " + e.getMessage());
    }
    
    return medicos;
}

        public ArrayList<String> obtenerRegistrosConsulta() throws SQLException {
    ArrayList<String> registros = new ArrayList<>();
    String query = "SELECT * FROM Consulta";
    
    try (Connection conn = this.conectar(); 
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int idConsulta = rs.getInt("ID_Consulta");
            int idPaciente = rs.getInt("ID_Paciente");
            int idMedico = rs.getInt("ID_Medico");
            String fecha = rs.getString("Fecha");
            String motivo = rs.getString("Motivo_Consulta");
            String diagnostico = rs.getString("Diagnostico");

            registros.add("ID Consulta: " + idConsulta + ", ID Paciente: " + idPaciente + 
                          ", ID Médico: " + idMedico + ", Fecha: " + fecha + 
                          ", Motivo: " + motivo + ", Diagnóstico: " + diagnostico);
        }
    }
    return registros;
}
        
        public ArrayList<String> obtenerRegistrosTratamientos() {
    ArrayList<String> registros = new ArrayList<>();
    String sql = "SELECT pt.ID_Paciente, t.ID_Tratamiento, t.Medicamento_Prescrito " +
                 "FROM Paciente_Tratamiento pt " +
                 "JOIN Tratamiento t ON pt.ID_Tratamiento = t.ID_Tratamiento";
    try (PreparedStatement statement = conexionBD.prepareStatement(sql);
         ResultSet rs = statement.executeQuery()) {
        while (rs.next()) {
            int idPaciente = rs.getInt("ID_Paciente");
            int idTratamiento = rs.getInt("ID_Tratamiento");
            String medicamentoPrescrito = rs.getString("Medicamento_Prescrito");
            // Formatear el registro en un formato legible
            registros.add("ID Tratamiento: " + idTratamiento + ", ID Paciente: " + idPaciente + 
                           ", Medicamento Prescrito: " + medicamentoPrescrito);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener registros: " + e.getMessage());
    }
    return registros;
}


        
    public boolean validarIdMedico(int idMedico) {
        String query = "SELECT COUNT(*) FROM Medico WHERE ID_Medico = ?";
        try (PreparedStatement pstmt = conexionBD.prepareStatement(query)) {
            pstmt.setInt(1, idMedico);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

  private Connection conectar() {
    String usuario = "root"; 
    String passwd = ""; 
    Connection conexionBD = null; 
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/Caso_Hospital"; 
        conexionBD = DriverManager.getConnection(url, usuario, passwd);
        System.out.println("Conexión exitosa");
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error de conexión: " + e.getMessage());
        e.printStackTrace();
    }
    return conexionBD; 
}


    public void insertarPaciente(int Id, String Nombre, int Seguro, String fecha) {
        String sql = "INSERT INTO Paciente (ID_Paciente, Nombre, Numero_Seguro, Fecha_Nacimiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexionBD.prepareStatement(sql)) {
            statement.setInt(1, Id);
            statement.setString(2, Nombre);
            statement.setInt(3, Seguro);
            statement.setString(4, fecha);  
            statement.executeUpdate();
            System.out.println("Paciente insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar paciente: " + e.getMessage());
        }
    }

    public void insertarMedico(int Id, String Nombre, String NumC, String Esp) {
        String sql = "INSERT INTO Medico (ID_Medico, Nombre, Numero_Colegiatura, Especialidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexionBD.prepareStatement(sql)) {
            statement.setInt(1, Id);
            statement.setString(2, Nombre);
            statement.setString(3, NumC);
            statement.setString(4, Esp);  
            statement.executeUpdate();
            System.out.println("Medico insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar médico: " + e.getMessage());
        }
    }

    public void insertarConsulta(int Id_C, int Id_P, int Id_M, String fecha, String mot, String diagnostico) {
        String sql = "INSERT INTO Consulta (ID_Consulta, ID_Paciente, ID_Medico, Fecha, Motivo_Consulta, Diagnostico) VALUES (?, ?, ?, ?,?, ?)";
        try (PreparedStatement statement = conexionBD.prepareStatement(sql)) {
            statement.setInt(1, Id_C);
            statement.setInt(2, Id_P);
            statement.setInt(3, Id_M);
            statement.setString(4, fecha);  
            statement.setString(5, mot);  
            statement.setString(6, diagnostico);  
            statement.executeUpdate();
            System.out.println("Consulta insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar consulta: " + e.getMessage());
        }
    }
    
       public void insertarTratamiento(int Id_T, String medicamento) {
        String sql = "INSERT INTO Tratamiento (ID_Tratamiento,Medicamento_Prescrito) VALUES (?, ?)";
        try (PreparedStatement statement = conexionBD.prepareStatement(sql)) {
            statement.setInt(1, Id_T);
            statement.setString(2, medicamento);
            statement.executeUpdate();
            System.out.println("Tratamiento insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar Tratamiento: " + e.getMessage());
        }
    }
    
        public void insertarPacienteTratamiento(int id_P, int id_T) {
    String sql = "INSERT INTO Paciente_Tratamiento (ID_Paciente, ID_Tratamiento) VALUES (?, ?)";
    try (PreparedStatement statement = conexionBD.prepareStatement(sql)) {
        statement.setInt(1, id_P);
        statement.setInt(2, id_T);
        statement.executeUpdate();
        System.out.println("Relación Paciente-Tratamiento insertada correctamente.");
    } catch (SQLException e) {
        System.out.println("Error al insertar relación Paciente-Tratamiento: " + e.getMessage());
    }
}
       
    

       // Método para obtener pacientes, médicos y consultas
    public ArrayList<String> obtenerPacientesMedicosConsultas() {
        ArrayList<String> registros = new ArrayList<>();
        String sql = "SELECT p.ID_Paciente, p.Nombre AS Nombre_Paciente, " +
                     "m.ID_Medico, m.Nombre AS Nombre_Medico, " +
                     "c.ID_Consulta, c.Motivo_Consulta, c.Fecha " +
                     "FROM Paciente p " +
                     "JOIN Consulta c ON p.ID_Paciente = c.ID_Paciente " +
                     "JOIN Medico m ON c.ID_Medico = m.ID_Medico";

        try (Statement statement = conexionBD.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String registro = "Paciente ID: " + resultSet.getInt("ID_Paciente") +
                                  ", Nombre: " + resultSet.getString("Nombre_Paciente") +
                                  ", Médico: " + resultSet.getString("Nombre_Medico") +
                                  ", Consulta ID: " + resultSet.getInt("ID_Consulta") +
                                  ", Motivo: " + resultSet.getString("Motivo_Consulta") +
                                  ", Fecha: " + resultSet.getString("Fecha");
                registros.add(registro);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener registros: " + e.getMessage());
        }
        return registros;
    }

    // Método para obtener pacientes con sus tratamientos
    public ArrayList<String> obtenerPacientesTratamientos() {
        ArrayList<String> registros = new ArrayList<>();
        String sql = "SELECT p.ID_Paciente, p.Nombre AS Nombre_Paciente, " +
                     "t.ID_Tratamiento, t.Medicamento_Prescrito " +
                     "FROM Paciente p " +
                     "JOIN Paciente_Tratamiento pt ON p.ID_Paciente = pt.ID_Paciente " +
                     "JOIN Tratamiento t ON pt.ID_Tratamiento = t.ID_Tratamiento";

        try (Statement statement = conexionBD.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String registro = "Paciente ID: " + resultSet.getInt("ID_Paciente") +
                                  ", Nombre: " + resultSet.getString("Nombre_Paciente") +
                                  ", Tratamiento ID: " + resultSet.getInt("ID_Tratamiento") +
                                  ", Medicamento: " + resultSet.getString("Medicamento_Prescrito");
                registros.add(registro);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener registros: " + e.getMessage());
        }
        return registros;
    }

   public boolean validarContrasenaMedico(int idMedico, String contrasena) {
    String query = "SELECT Contrasena FROM Usuario_Medico WHERE ID_Medico = ?";
    try (PreparedStatement pstmt = conexionBD.prepareStatement(query)) {
        pstmt.setInt(1, idMedico);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String contrasenaBD = rs.getString("Contrasena");
            return contrasenaBD.equals(contrasena);  // Comparar la contraseña ingresada con la almacenada en la base de datos
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;  // Retorna false si la contraseña no coincide o si ocurre un error
}

   
}

