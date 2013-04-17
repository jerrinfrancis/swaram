/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author vsvineeth
 */
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class Chakka_main extends JFrame {
    
    JPanel panel = new JPanel();
    
    public Chakka_main()
    {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationByPlatform(true);
        initcomponents();
    }
    
  /*  public void Wait()
    {
         try {
    	    Thread.currentThread().sleep(12000);
    	} catch(InterruptedException ex) {
    	    Thread.currentThread().interrupt();
    	}
    }*/
    public void initcomponents()
    {
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.yellow);
        add(panel, BorderLayout.CENTER);
        
        //panel = new HomePage();
        panel.add(new HomePage(),BorderLayout.CENTER);
        panel.setVisible(true);
      
        
        
        
        
      //  Wait();
         
      /*  panel.add(new MainMenu(),BorderLayout.CENTER);
        panel.setVisible(true); */
        
    }
    
    
    public static void main(String args[]) 
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               JFrame frame = new Chakka_main();
               frame.setVisible(true);
            }
        });
    }
}
