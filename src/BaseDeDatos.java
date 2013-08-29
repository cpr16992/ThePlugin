import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase simple que se encarga de pasar la conexi�n a la base de datos.
 * @author Gustavo Hern�ndez Salinas
 */
public final class BaseDeDatos {
 
 /**
  * Conecta a una base de datos en la ruta pasada como argumento.
  * Si el archivo se�alado en la ruta no existe, se crea.
  * @param ruta - La ruta de la DB a conectar.
  * @return La conexi�n a la ruta.
  */
 public static Connection conectarA(String ruta){
  try {
   //Aqu� cargamos el driver de SQLITE.
   Class.forName("org.sqlite.JDBC");
  }
  catch (ClassNotFoundException e) {
   //Esto se ejecuta si hay un error con el driver de la base de datos.
   e.printStackTrace();
  }
  
  //Declaramos la conexi�n:
  Connection conn = null;

  try {
   //Aqu� se obtiene la conexi�n:
   conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
   //Un mensaje en la consola para saber si se realiz� la conexi�n y donde est� el archivo:
   System.out.println("Conexi�n realizada correctamente - Ruta de base de datos: " + ruta);
  }
  catch (SQLException e) {
   //Esto se ejecuta si hay un error en la base de datos:
   e.printStackTrace();
  }
  
  //Devolvemos la conexi�n:
  return conn;
 }
 
 public static void main(String[] args) {
  //Pasamos una ruta a la cual conectar:
  Connection conn = BaseDeDatos.conectarA("C:\\Users\\carlos\\Desktop\\test.db3");
  
  /*
   * Aqu� se supone que hacemos lo que necesitamos en la base de datos
   * ya sea una consulta, creaci�n de una tabla, actualizaci�n de la
   * misma, etc.
   */
  
  try {
   //Y para terminar cerramos la conexi�n
   conn.close();
  }
  catch (SQLException e) {
   //Esto se ejecuta si hay alg�n problema al realizar la conexi�n.
   e.printStackTrace();
  }
 }
}
