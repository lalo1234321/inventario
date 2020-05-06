
package alacenadigital;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CeldaColor extends DefaultTableCellRenderer
{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        JLabel lb=(JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        
        /*if(table.getValueAt(row, column).getClass().equals(Integer.class))
        {
            int valor=Integer.parseInt((String)table.getValueAt(row, column));
            if(valor<5)
            {
                setBackground(Color.red);
                setForeground(Color.white);
            }
        }*/
        if(value instanceof String)
        {
            String s=(String)value;
            
            
            if(s.equals("no"))
            {
                lb.setBackground(Color.green);
                lb.setForeground(Color.black);
            }
            if(s.equals("si"))
            {
                lb.setBackground(Color.red);
                lb.setForeground(Color.white);
            }
            
            /*else
            {
                setBackground(Color.white);
                setForeground(Color.black);
            }*/
        }
        
        return  lb;
    }
    
}
