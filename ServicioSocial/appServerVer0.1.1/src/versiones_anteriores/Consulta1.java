package versiones_anteriores;

import java.sql.*;
import java.util.Scanner;

public class Consulta1 {
    private String dbName = null;
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet resultset = null;
    private Scanner entrada;
    private String in = null;
    private int i = 0;

    public Consulta1() {

    }

    public Consulta1(Connection conn){
        this.conn = conn;
    }

    public void Consultar() {
        try{
            System.out.println("Ingrese el nombre de la tabla a la cual va a consultar datos");
            System.out.print("");
            entrada = new Scanner(System.in);
            in = entrada.nextLine();
            switch(in){
                case "alumno":
                    pstmt = conn.prepareStatement("SELECT * FROM alumno");
                    resultset = pstmt.executeQuery();//Se muestran las tablas de la base de datos
                    while (resultset.next()) {
                        System.out.println("Numero de cuenta: "+resultset.getInt("num_cta")+" Nombre: "+resultset.getString("nombre"));
                    }
                    System.out.print("Fin del listado\n");
                    break;
                default:
                    System.out.println("La tabla no existe");
                    break;
            }
        }catch(SQLException e){
            System.out.println("Error durante la consulta de datos");
            e.printStackTrace();
        }
    }

    public void Insertar() {
        try {
            System.out.println("Ingrese el nombre de la tabla a la cual agregara nuevos datos");
            System.out.print("");
            entrada = new Scanner(System.in);
            in = entrada.nextLine();
            switch(in){
                case "alumno":
                    pstmt = conn.prepareStatement("INSERT INTO alumno VALUES (?,?)");
                    System.out.println("Ingrese el numero de cuenta");
                    pstmt.setInt(1,new Scanner(System.in).nextInt());
                    System.out.println("Ingrese el nombre");
                    pstmt.setString(2,new Scanner(System.in).nextLine());
                    pstmt.executeUpdate();
                    System.out.println("Insercion realizada");
                    break;
                default:
                    System.out.println("La tabla no existe");
                    break;
            }
        }catch(SQLException e){
            System.out.println("Error al insertar nuevos datos");
            e.printStackTrace();
        }
    }

    public void Eliminar() {
        try {
            System.out.println("Ingrese el nombre de la tabla a la cual se eliminan datos");
            System.out.print("");
            entrada = new Scanner(System.in);
            in = entrada.nextLine();
            switch(in){
                case "alumno":
                    pstmt = conn.prepareStatement("DELETE FROM alumno WHERE num_cta=?");
                    System.out.println("Ingrese el numero de cuenta del alumno a borrar de la tabla");
                    i = new Scanner(System.in).nextInt();
                    pstmt.setInt(1,i);
                    pstmt.executeUpdate();
                    System.out.println("Borrado del registro realizado");
                    break;
                default:
                    System.out.println("La tabla no existe");
                    break;
            }
        }catch(SQLException e){
            System.out.println("Error al borrar datos");
            e.printStackTrace();
        }
    }

    public void Crear(){

    }

    public void Modificar(){
        try {
            System.out.println("Ingrese el nombre de la tabla donde hara el update");
            System.out.print("");
            entrada = new Scanner(System.in);
            in = entrada.nextLine();
            switch(in){
                case "alumno":
                    System.out.println("Update general");
                    pstmt = conn.prepareStatement("UPDATE alumno SET num_cta=?, nombre=? WHERE num_cta=?");
                    System.out.println("Ingrese el nuevo numero de cuenta");
                    pstmt.setInt(1,new Scanner(System.in).nextInt());
                    System.out.println("Ingrese el nuevo nombre");
                    pstmt.setString(2,new Scanner(System.in).nextLine());
                    System.out.println("Ingrese el num_cta de del registro del alumno a modificar");
                    pstmt.setInt(3,new Scanner(System.in).nextInt());
                    pstmt.executeUpdate();
                    System.out.println("Modificacion realizada");
                    break;
                default:
                    System.out.println("La tabla no existe");
                    break;
            }
        }catch(SQLException e){
            System.out.println("Error al modificar los datos");
            e.printStackTrace();
        }
    }

}