package mission;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard()
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

        JMenu syshello1 = new JMenu("ADMIN");
        syshello1.setForeground(Color.RED);
        menuBar.add(syshello1);
        
        JMenuItem entryhello1 = new JMenuItem("ADD EMPLOYEE");
        syshello1.add(entryhello1);
        
        entryhello1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    new AddEmployee().setVisible(true);
                }
                catch(Exception e )
                {

                }
            }
	    });
        JMenuItem syshello2 = new JMenuItem("ADD TENTS");
	    syshello1.add(syshello2);
        
        syshello2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    new AddTent().setVisible(true);
                }
                catch(Exception e )
                {

                }
            }
	    });
        entry.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new Reception();
            }
	    });

        JMenuItem syshello3 = new JMenuItem("ADD DRIVERS");
	    syshello1.add(syshello3);

	    syshello3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    new AddDrivers().setVisible(true);
                }
                catch(Exception e )
                {

                }
            }
	    });
	    setSize(1950,1090);
	    setVisible(true);
	    getContentPane().setBackground(Color.WHITE);
    }
}
