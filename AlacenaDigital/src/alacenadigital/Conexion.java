
package alacenadigital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion 
{
	private int noCon;
	private String estatus=null;
	private Connection con;
	private String driver ="com.mysql.jdbc.Driver";
	private String conectionUrl="jdbc:mysql://localhost:3306/topicos";
	private String userName="root";
	private String password="240298";
	public Conexion() 
	{
		con=null;
		
	}
	public void conect() 
	{
		try 
		{
			Class.forName(driver);
			System.out.println("Hola");
			con=DriverManager.getConnection(conectionUrl,userName,password);
			if(con!=null) 
			{
				System.out.println("Conexión establecia");
			}
		}
		catch(ClassNotFoundException|SQLException e)
		{
			System.out.println("Error al conectar "+e);
		}
	}
	public void disconect() 
	{
		con=null;
		if(con==null) 
		{
			System.out.println("Conexión terminada");
		} 
	}
	public int getNoCon() {
		return noCon;
	}
	public void setNoCon(int noCon) {
		this.noCon = noCon;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public String getConectionUrl() {
		return conectionUrl;
	}
	public void setConectionUrl(String conectionUrl) {
		this.conectionUrl = conectionUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}


