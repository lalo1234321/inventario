
package alacenadigital;

import alacenadigital.Store.Tienda;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class HiloAgregar implements Runnable
{
    
    private JProgressBar pg;
    private JLabel lb;
    private JTable tb;
    private DefaultTableModel dt;
    private ArrayList<Tienda> Almacen ;
    private Object[]fila;
    public HiloAgregar(JLabel lb,JProgressBar pg)
    {
        this.lb=lb;
        this.pg=pg;
    }

    @Override
    public void run()
    {
        pg.setVisible(true);
            for(int i=0;i<=100;i++) 
            {
            try
            {
                Thread.sleep(20);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(HiloAgregar.class.getName()).log(Level.SEVERE, null, ex);
            }
		lb.setText(""+i);
		pg.setValue(i);
            }
	JOptionPane.showMessageDialog(null,"Creación completada de producto");		
			
        pg.setVisible(false);
        lb.setText("");
          
    }
}
