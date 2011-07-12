package gui;


import javax.swing.*;

import org.codehaus.groovy.tools.shell.Main;

import utils.ImageUtils;

import java.awt.*;

/**
 * 
 * @author Miguel Corona
 *
 */
public class SplashWindow2 extends JWindow
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SplashWindow2(String filename)
    {
        JLabel l = new JLabel(new ImageUtils().createImageIcon(filename, "Splash"));
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));
    
        
        setVisible(true);
            
    }
}
