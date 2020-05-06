
package alacenadigital;
import javax.swing.*;

public class Hilo implements Runnable
{
    private Login log;
    private JLabel lb;
    private JProgressBar pg;
    private String user;
    private AlacenaDigital obj;
    public Hilo(JLabel lb,JProgressBar pg,String user,AlacenaDigital obj,Login log)
    {
        this.lb=lb;
        this.pg=pg;
        this.user=user;
        this.obj=obj;
        this.log=log;
    }

    @Override
    public void run()
    {
        try 
		{
                    pg.setVisible(true);
			for(int i=0;i<=100;i++) 
			{
				Thread.sleep(20);
				lb.setText(""+i);
				pg.setValue(i);
			}
			JOptionPane.showMessageDialog(null, "Inicio de se sesión correcto "+user);
                        pg.setVisible(false);
                        lb.setText("");
                        log.setVisible(false);
                        obj.frame.setVisible(true);
                        
                        /*bandera=true;
                        if(bandera==true)
                        {
                            lista.setModel(modelo);
                        }*/
                        //lista.setModel(modelo);
		}catch(Exception err) 
		{
			err.printStackTrace();
		}
    }
}
