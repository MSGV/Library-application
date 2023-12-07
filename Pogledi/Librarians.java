package Pogledi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Zajednicko.Helper;
import Zajednicko.HelperPrikaz;

public class Librarians extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSur;
	private JTextField txtSSN;
	private JTextField txtPN;
	private JTextField txtEmail;
	private JTextField txtHome;
	private JTable table;
	private int ID;
	
	static Helper Helper = new Helper();
	HelperPrikaz HelperP = new HelperPrikaz();
	private JTextField txtPTT;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarians frame = new Librarians();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Prikaz() {
		String query = "SELECT * FROM librarians";
		HelperP.PopuniTabelu(query, table);
	}
	
	public Librarians() {
		initComponents();
		Prikaz();
	}
	
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Legion\\Desktop\\Milan Buric fakultet\\Librarians.jpg"));
		setTitle("Librarians");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1205, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1189, 632);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(41, 159, 168, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(41, 186, 168, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Social Security Number");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(41, 213, 168, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(41, 238, 168, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email Adress");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(41, 263, 168, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Home Adress");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(41, 288, 168, 13);
		panel.add(lblNewLabel_5);
		
		
		txtName = new JTextField();
		txtName.setBounds(234, 157, 168, 19);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtSur = new JTextField();
		txtSur.setBounds(234, 184, 168, 19);
		panel.add(txtSur);
		txtSur.setColumns(10);
		
		txtSSN = new JTextField();
		txtSSN.setBounds(234, 211, 168, 19);
		panel.add(txtSSN);
		txtSSN.setColumns(10);
		
		txtPN = new JTextField();
		txtPN.setBounds(234, 236, 168, 19);
		panel.add(txtPN);
		txtPN.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(234, 261, 168, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtHome = new JTextField();
		txtHome.setBounds(234, 286, 168, 19);
		panel.add(txtHome);
		txtHome.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().equals("") || txtSur.getText().equals("") || txtSSN.getText().equals("") || txtEmail.getText().equals("") ||txtHome.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please Enter the necessary Information!");
				}
				else {
					
					String Name = txtName.getText();
					String Surname = txtSur.getText();
					String PhNumb = txtPN.getText();
					String Adresse = txtHome.getText();
					String Email = txtEmail.getText();
					String SSN = txtSSN.getText();
					String PTT = txtPTT.getText();
					
					Connection conn = Helper.DBSetup();
					String query = "INSERT INTO librarians(Name, Surname, Phone_Number, Adress, Email_Adress, PN, SSN) VALUES ('"+Name+"', '"+Surname+"', '"+Integer.valueOf(PhNumb)+"', '"+Adresse+"', '"+Email+"', '"+Integer.valueOf(PTT)+"', '"+Integer.valueOf(SSN)+"')";
					
					try {
						java.sql.Statement stm = conn.createStatement();
						stm.execute(query);
						Prikaz();
					}
					catch(Exception be){
							be.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Information Successfully Added!");
				}
			
		}});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(26, 375, 168, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name = txtName.getText();
				String Surname = txtSur.getText();
				String PhNumb = txtPN.getText();
				String Adresse = txtHome.getText();
				String Email = txtEmail.getText();
				String SSN = txtSSN.getText();
				String PTT = txtPTT.getText();
				
				Connection connect = Helper.DBSetup();
				
				String sql = "UPDATE librarians SET Name = '"+Name+"', Surname = '"+Surname+"', SSN = '"+Integer.valueOf(SSN)+"'"
						+ "Phone_Number = '"+PhNumb+"', PN = '"+PTT+"', Adress = '"+Adresse+"', Email_Adress = '"+Email+"' WHERE ID = '"+ID+"'";
						
		
					try { 
						Statement stm = connect.createStatement();
				    	stm.execute(sql);
				    
				    	Prikaz();
				    
						connect.close();
				    
	
					}   
					catch(SQLException ex) {
						System.out.println(ex.getMessage());
					}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(234, 375, 168, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connect = Helper.DBSetup();
				
				String sql = "DELETE FROM librarians WHERE ID = '"+ID+"'";
				
				try { 
					Statement stm = connect.createStatement();
			    	stm.execute(sql);
			    
			    	Prikaz();
			    
					connect.close();
			    

				}   
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}		
				
			}
		});
		btnNewButton_2.setBounds(26, 426, 168, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtName.setText("");
				txtSur.setText("");
				txtSSN.setText("");
				txtPN.setText("");
				txtEmail.setText("");
				txtHome.setText("");
				txtPTT.setText("");
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(234, 426, 168, 21);
		panel.add(btnNewButton_3);
		
		JButton btnExit = new JButton("BACK");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main_Menu MM = new Main_Menu();
				MM.setVisible(true);
			}
		});
		btnExit.setBounds(10, 601, 123, 21);
		panel.add(btnExit);
		
		JLabel lblNewLabel_6 = new JLabel("LIBRARIANS");
		lblNewLabel_6.setIcon(null);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setBounds(10, 13, 168, 41);
		panel.add(lblNewLabel_6);
		
		txtPTT = new JTextField();
		txtPTT.setBounds(234, 312, 168, 20);
		panel.add(txtPTT);
		txtPTT.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("PTT");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(41, 315, 168, 14);
		panel.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(422, 13, 757, 608);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ListSelectionModel rowSelectionModel = table.getSelectionModel();

		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        			        
		        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		        		        
		        if(lsm.isSelectionEmpty()) {
		        	//JOptionPane.showMessageDialog(null, "No Selection");
		        }
		        else {
		        	int selRow = table.getSelectedRow();
		        	String Name = table.getModel().getValueAt(selRow, 1).toString();
		        	String Surname = table.getModel().getValueAt(selRow, 2).toString();
		        	String SSN = table.getModel().getValueAt(selRow, 7).toString();
		        	String Phone = table.getModel().getValueAt(selRow, 3).toString();
		        	String PTT = table.getModel().getValueAt(selRow, 6).toString();
		        	String Email = table.getModel().getValueAt(selRow, 5).toString();
		        	String Address = table.getModel().getValueAt(selRow, 4).toString();
		        	int idForEdit = Integer.parseInt(table.getModel().getValueAt(selRow, 0).toString());
		        	//Phone email addres ptt
		        	txtName.setText(Name);
		        	txtSur.setText(Surname);
		        	txtSSN.setText(SSN);
					txtPN.setText(Phone);
					txtPTT.setText(PTT);
					txtEmail.setText(Email);
					txtHome.setText(Address);
					ID = idForEdit;
		        	//String Surname = Integer.parseInt(table.getModel().getValueAt(selRow, 1).toString());
		        	JOptionPane.showMessageDialog(null,String.valueOf(idForEdit));
		        	//txtNazivPredstave.setText(NazivP);
		        }
		      }

		    });
	}
}
