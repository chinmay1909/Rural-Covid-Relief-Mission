package mission;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userDashboard extends JFrame
{
    public static void main(String[] args) {
        new userDashboard().setVisible(true);
    }
    public userDashboard()
    {
        super("RURAL COVID RELIEF MISSION");
        setForeground(Color.CYAN);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mission/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000);
        add(NewLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu sys = new JMenu("MISSION");
        sys.setForeground(Color.BLUE);
        menuBar.add(sys);

        JMenuItem entry = new JMenuItem("RECEPTION");
        sys.add(entry);

        entry.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new Reception();
            }
        });

        setSize(1950,1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
