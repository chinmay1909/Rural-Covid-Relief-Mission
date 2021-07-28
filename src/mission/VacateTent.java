package mission;

import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class VacateTent extends JFrame
{
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1;
    Choice c1;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    VacateTent frame = new VacateTent();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }

    /**
     * Create the frame.
     * @throws SQLException
     */
    public VacateTent() throws SQLException
    {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 294);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mission/icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(300,0,500,225);
        add(l1);
        JLabel lblVacateTent = new JLabel("Vacate Tent ");
        lblVacateTent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVacateTent.setBounds(70, 11, 140, 35);
        contentPane.add(lblVacateTent);

        JLabel lblName = new JLabel("Number :");
        lblName.setBounds(20, 85, 80, 14);
        contentPane.add(lblName);
        c1 = new Choice();
        try
        {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from patient");
            while(rs.next())
            {
                c1.add(rs.getString("number"));
            }
        }
        catch(Exception e)
        {

        }
        c1.setBounds(130, 82, 150, 20);
        contentPane.add(c1);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("mission/icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l2 = new JButton(i6);
        l2.setBounds(290,82,20,20);
        add(l2);

        l2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println("Hi");
                try
                {
                    conn c = new conn();
                    String number = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from patient where number = "+number);
                    if(rs.next())
                    {
                        System.out.println("clicked");
                        t1.setText(rs.getString("tent_number"));
                    }
                }
                catch(Exception e)
                { }
            }
        });
        JLabel lblTentNo = new JLabel("Tent Number:");
        lblTentNo.setBounds(20, 132, 86, 20);
        contentPane.add(lblTentNo);
        t1 = new JTextField();
        t1.setBounds(130, 132, 150, 20);
        contentPane.add(t1);

        JButton btnVacate = new JButton("Vacate Tent");
        btnVacate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String id = c1.getSelectedItem();
                String s1 = t1.getText();
                String deleteSQL = "Delete from patient where number = "+id;
                String q2 = "update tent set availability = 'Available' where tent_number = "+s1;
                conn c = new conn();
                try
                {
                    c.s.executeUpdate(deleteSQL);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Tent Vacated");
                    new Reception().setVisible(true);
                    setVisible(false);
                }
                catch(SQLException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }
        });
        btnVacate.setBounds(50, 200, 100, 25);
        btnVacate.setBackground(Color.BLACK);
        btnVacate.setForeground(Color.WHITE);
        contentPane.add(btnVacate);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 200, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
        getContentPane().setBackground(Color.WHITE);
    }
}