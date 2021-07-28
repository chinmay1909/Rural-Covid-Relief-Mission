package mission;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateTent extends JFrame
{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Ava;
	private JTextField txt_Status;
	private JTextField txt_Tent;
    Choice c1;

	public UpdateTent() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mission/icons/seventh.jpg"));
		Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(400,80,600,250);
		add(l1);

		JLabel lblUpdateTentStatus = new JLabel("Update Tent Status");
		lblUpdateTentStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateTentStatus.setBounds(85, 11, 206, 34);
		contentPane.add(lblUpdateTentStatus);

		JLabel lblNewLabel = new JLabel("Patient ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);

		c1 = new Choice();
		try{
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from patient");
			while(rs.next()){
				c1.add(rs.getString("number"));
			}
		}catch(Exception e){ }
		c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);

		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(27, 187, 90, 14);
		contentPane.add(lblAvailability);

		JLabel lblReadyStatus = new JLabel("Ready Status:");
		lblReadyStatus.setBounds(27, 240, 90, 14);
		contentPane.add(lblReadyStatus);
		
		txt_Ava = new JTextField();
		txt_Ava.setBounds(160, 184, 140, 20);
		contentPane.add(txt_Ava);
		txt_Ava.setColumns(10);

		txt_Status = new JTextField();
		txt_Status.setBounds(160, 237, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);

		txt_Tent = new JTextField();
		txt_Tent.setBounds(160, 130, 140, 20);
		contentPane.add(txt_Tent);
		txt_Tent.setColumns(10);

		JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String s1 = c1.getSelectedItem();
					conn c = new conn();
					ResultSet rs1 = c.s.executeQuery("select * from patient where number = "+s1);

					while(rs1.next())
					{
						txt_Tent.setText(rs1.getString("tent_number"));
					}
				}
				catch(Exception ee)
				{
					
				}
				try
				{
					conn c  = new conn();
					ResultSet rs2 = c.s.executeQuery("select * from tent where tent_number = " + txt_Tent.getText());
					while(rs2.next())
					{
						txt_Ava.setText(rs2.getString("availability"));
						txt_Status.setText(rs2.getString("ready_status"));
					}
				}
				catch(Exception ee)
				{
					
				}
			}
		});
		b1.setBounds(120, 315, 89, 23);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) throws NumberFormatException
			{
				try
				{
					conn c = new conn();
					String str = "update tent set ready_status = '"+txt_Status.getText()+"' where tent_number = "+txt_Tent.getText();
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Update Successful");
					new Reception().setVisible(true);
					setVisible(false);
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(60, 355, 89, 23);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(180, 355, 89, 23);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		JLabel lblTentID = new JLabel("Tent Number:");
		lblTentID.setBounds(27, 133, 100, 14);
		contentPane.add(lblTentID);

		getContentPane().setBackground(Color.WHITE);
	}
    
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UpdateTent frame = new UpdateTent();
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
	

}