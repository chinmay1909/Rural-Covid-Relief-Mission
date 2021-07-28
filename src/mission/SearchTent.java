package mission;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchTent extends JFrame
{
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField txt_Type;
	private JTable table;
	Choice c1;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					SearchTent frame = new SearchTent();
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
	public SearchTent() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchForTent = new JLabel("Search For Tent");
		lblSearchForTent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForTent.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForTent);
		
		JLabel lblTentType = new JLabel("Tent Number");
		lblTentType.setBounds(23, 162, 96, 14);
		contentPane.add(lblTentType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		contentPane.add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);
		
		JCheckBox checkTent = new JCheckBox("Only display Available");
		checkTent.setBounds(400, 69, 205, 23);
                checkTent.setBackground(Color.WHITE);
		contentPane.add(checkTent);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String SQL = "select * from tent";
				String SQL2 = "select * from tent where availability = 'Available'";
				try
				{
					conn c = new conn();
					rs = c.s.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));

					if(checkTent.isSelected())
					{
						rs = c.s.executeQuery(SQL2);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
			}catch (SQLException ss)
			{
				ss.printStackTrace();
			}
			
			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		contentPane.add(table);
		
		JLabel lblReadyStatus = new JLabel("Ready Status");
		lblReadyStatus.setBounds(306, 162, 96, 14);
		contentPane.add(lblReadyStatus);

		getContentPane().setBackground(Color.WHITE);
	}
}