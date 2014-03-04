import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class GXDparserOI {

	public static void main(String[] args) {

	try
	{
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/agem_31","root", "1609");
		Statement s = conexion.createStatement(); 
		ResultSet rs = s.executeQuery ("select * from tbvg_mgi_gxd_structure where _Parent_key in (select _Structure_key from tbvg_mgi_gxd_structure where _Parent_key = 7005);");
		while (rs.next()) 
		{ 
		    System.out.println (rs.getInt (1)); 
		}
		conexion.close();
	} catch (Exception e)
	{
		e.printStackTrace();
	}
}
}
