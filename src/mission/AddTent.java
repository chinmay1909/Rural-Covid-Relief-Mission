package mission;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddTent extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args)
    {
        new AddTent().setVisible(true);
    }

    public AddTent()
    {
        setBounds(450, 200, 1000, 450);
	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mission/icons/twelve.jpg"));
	    Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
	    ImageIcon i2 = new ImageIcon(i3);
	    JLabel l15 = new JLabel(i2);
	    l15.setBounds(400,30,500,370);
	    add(l15);
	    JLabel l10 = new JLabel("Add Tents");
	    l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	    l10.setBounds(194, 10, 120, 22);
	    contentPane.add(l10);
	    JLabel l1 = new JLabel("Tent Number");
	    l1.setForeground(new Color(25, 25, 112));
	    l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    l1.setBounds(64, 70, 102, 22);
	    contentPane.add(l1);
	    t4 = new JTextField();
	    t4.setBounds(174, 70, 156, 20);
	    contentPane.add(t4);
	    JLabel l2 = new JLabel("Availability");
	    l2.setForeground(new Color(25, 25, 112));
	    l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	    l2.setBounds(64, 110, 102, 22);
	    contentPane.add(l2);
	    comboBox = new JComboBox(new String[] { "Vacant", "Occupied" });
	    comboBox.setBounds(176, 110, 154, 20);
	    contentPane.add(comboBox);
	    JLabel l3 = new JLabel("Ready Status");
	    l3.setForeground(new Color(25, 25, 112));
	    l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	    l3.setBounds(64, 150, 102, 22);
	    contentPane.add(l3);
	    comboBox_2 = new JComboBox(new String[] { "Ready", "Not yet ready" });
	    comboBox_2.setBounds(176, 150, 154, 20);
	    contentPane.add(comboBox_2);
	    JLabel l4 = new JLabel("Price");
	    l4.setForeground(new Color(25, 25, 112));
	    l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	    l4.setBounds(64, 190, 102, 22);
	    contentPane.add(l4);
	    t2 = new JTextField();
	    t2.setBounds(174, 190, 156, 20);
	    contentPane.add(t2);
	    b1 = new JButton("Add");
	    b1.addActionListener(this);
	    b1.setBounds(64, 321, 111, 33);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
	    contentPane.add(b1);
	    b2 = new JButton("Back");
	    b2.addActionListener(this);
	    b2.setBounds(198, 321, 111, 33);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
	    contentPane.add(b2);
	    contentPane.setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if(ae.getSource() == b1)
            {
                try
                {
                    conn c = new conn();
                    String tent = t4.getText();
                    String available = (String)comboBox.getSelectedItem();
                    String status = (String)comboBox_2.getSelectedItem();
                    String price  = t2.getText();
                    String str = "INSERT INTO tent values( '"+tent+"', '"+available+"', '"+status+"','"+price+"')";
		            c.s.executeUpdate(str);
		            JOptionPane.showMessageDialog(null, "Tent Successfully Added");
                    this.setVisible(false);
                }
                catch(Exception ee)
                {
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2)
            {
                this.setVisible(false);
            }
        }
        catch(Exception eee)
        {
            
        }
    }
}
