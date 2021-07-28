package mission;
import mission.Login;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class reliefMission extends JFrame implements ActionListener
{
        JLabel l1;
        JButton b1;
        public reliefMission()
        {
                setSize(1366,430);
                setLayout(null);
                setLocation(300,300);
                l1 = new JLabel("");
                b1 = new JButton("Next");
                
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mission/icons/firstwithlogo.png"));
                Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);

                b1.setBounds(1170,325,150,50);
                l1.setBounds(0, 0, 1366, 390);
                l1.add(b1);add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
    {
            new Login().setVisible(true);
            this.setVisible(false);
    }
    public static void main(String[] args)
    {
            reliefMission window = new reliefMission();
            window.setVisible(true);
	}
}
