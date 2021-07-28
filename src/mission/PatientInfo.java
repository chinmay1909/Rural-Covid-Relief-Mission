package mission;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PatientInfo extends JFrame
{
	Connection conn = null;
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JLabel lblGender;
	private JTable table;
	private JLabel lblTent;
	private JLabel lblStatus;
	private JLabel lblNewLabel_1;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PatientInfo frame = new PatientInfo();
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
	public PatientInfo() throws SQLException
	{
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Reception().setVisible(true);
				setVisible(false);
			}
		});

		btnExit.setBounds(450, 510, 120, 30);
		btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					conn c  = new conn();
					String displayPatientSQL = "select * from patient";
					ResultSet rs = c.s.executeQuery(displayPatientSQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		btnLoadData.setBounds(300, 510, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		contentPane.add(lblId);
                
        JLabel l1 = new JLabel("Number");
		l1.setBounds(150, 11, 46, 14);
		contentPane.add(l1);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(270, 11, 65, 14);
		contentPane.add(lblNewLabel);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(360, 11, 46, 14);
		contentPane.add(lblGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		contentPane.add(table);
		
		lblTent = new JLabel("Tent");
		lblTent.setBounds(600, 11, 46, 14);
		contentPane.add(lblTent);
		
		lblStatus = new JLabel("Admit Status");
		lblStatus.setBounds(680, 11, 100, 14);
		contentPane.add(lblStatus);
		
		lblNewLabel_1 = new JLabel("Deposit");
		lblNewLabel_1.setBounds(800, 11, 100, 14);
		contentPane.add(lblNewLabel_1);

		getContentPane().setBackground(Color.WHITE);
	}
}