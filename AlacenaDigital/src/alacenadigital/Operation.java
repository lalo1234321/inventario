
package alacenadigital;

import alacenadigital.Store.Tienda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Operation extends Conexion
{
	public void insert(String clase,String nombre,int cantidad,double precio,int limInf,String fecha,int id) throws  Exception
	{
		String sql="insert into Inventario(clase,nombre,cantidad,precio,limInf,fecha,id) values(?,?,?,?,?,?,?)";
		Connection aux=null;
		conect();
		aux=getCon();
		PreparedStatement ps=aux.prepareStatement(sql);
		ps.setString(1,clase );
		ps.setString(2,nombre);
                ps.setInt(3, cantidad);
		ps.setDouble(4, precio);
		ps.setInt(5, limInf);
                ps.setString(6,fecha);
                ps.setInt(7,id);
		ps.execute();
		if(aux!=null) 
		{
			try 
			{
				disconect();
			}
			catch(Exception e)
			{
				System.out.println("Error "+e);
			}
			
		}
	}
	public void updatePrice(int id,int cantidad) throws Exception 
	{
		Connection aux=null;
		conect();
		aux=getCon();
		String sql="UPDATE Inventario SET cantidad=? WHERE id=?; ";
		PreparedStatement ps=aux.prepareStatement(sql);
		ps.setInt(1,cantidad);
                ps.setInt(2, id);
		
		ps.execute();
		if(aux!=null) 
		{
			try 
			{
				disconect();
			}
			catch(Exception e)
			{
				System.out.println("Error "+e);
			}
			
		}
	}
	
	public void delete(int id) throws Exception 
	{
		Connection aux=null;
		conect();
		aux=getCon();
		String sql="delete from cocinero where  id=?";
		PreparedStatement ps=aux.prepareStatement(sql);
		ps.setInt(1,id);
		ps.execute();
		if(aux!=null) 
		{
			try 
			{
				disconect();
			}
			catch(Exception e)
			{
				System.out.println("Error "+e);
			}
			
		}
	}
	public ArrayList<Tienda> query() throws Exception
	{
		ArrayList<Tienda> producto=new ArrayList<Tienda>();
		Connection aux=null;
		conect();
		aux = getCon();
		Statement s = aux.createStatement();
		ResultSet rs=s.executeQuery("select * from Inventario");
		while(rs.next()) 
		{
			Tienda pr=new Tienda() {
                            @Override
                            public void LeerDatos()
                            {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public String PrintDatos()
                            {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void FuncionAgregada1()
                            {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void FuncionAgregada2()
                            {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        };
			pr.setClasePertenencia(rs.getString(1));
			pr.setNombreProducto(rs.getString(2));
			pr.setCantidadRequerida(rs.getInt(3));
			pr.setPrecio(rs.getDouble(4));
                        pr.setLimInf(rs.getInt(5));
                        pr.setDate(rs.getString(6));
                        pr.setID(rs.getInt(7));
			producto.add(pr);
		}
		if(aux!=null) 
		{
			try 
			{
				disconect();
			}
			catch(Exception e)
			{
				System.out.println("Error "+e);
			}
			
		}
		return producto;
		
		
	}
}
