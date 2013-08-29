import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase simple que se encarga de pasar la conexión a la base de datos.
 * @author Gustavo Hernández Salinas
 */
public final class BaseDeDatos {
 
 /**
  * Conecta a una base de datos en la ruta pasada como argumento.
  * Si el archivo señalado en la ruta no existe, se crea.
  * @param ruta - La ruta de la DB a conectar.
  * @return La conexión a la ruta.
  */
 public static Connection conectarA(String ruta){
  try {
   //Aquí cargamos el driver de SQLITE.
   Class.forName("org.sqlite.JDBC");
  }
  catch (ClassNotFoundException e) {
   //Esto se ejecuta si hay un error con el driver de la base de datos.
   e.printStackTrace();
  }
  
  //Declaramos la conexión:
  Connection conn = null;

  try {
   //Aquí se obtiene la conexión:
   conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
   //Un mensaje en la consola para saber si se realizó la conexión y donde está el archivo:
   System.out.println("Conexión realizada correctamente - Ruta de base de datos: " + ruta);
  }
  catch (SQLException e) {
   //Esto se ejecuta si hay un error en la base de datos:
   e.printStackTrace();
  }
  
  //Devolvemos la conexión:
  return conn;
 }
 
 public static void main(String[] args) {
  //Pasamos una ruta a la cual conectar:
  Connection conn = BaseDeDatos.conectarA("C:\\Users\\carlos\\Desktop\\test.db3");
  
  /*
   * Aquí se supone que hacemos lo que necesitamos en la base de datos
   * ya sea una consulta, creación de una tabla, actualización de la
   * misma, etc.
   */
  
  try {
   //Y para terminar cerramos la conexión
   conn.close();
  }
  catch (SQLException e) {
   //Esto se ejecuta si hay algún problema al realizar la conexión.
   e.printStackTrace();
  }
 }
}
