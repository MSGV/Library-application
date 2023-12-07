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
import javax.swing.table.DefaultTableModel;

import Zajednicko.Helper;
import Zajednicko.HelperPrikaz;

public class Readers extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPhoneN;
	private JTextField txtEmail;
	private JTextField txtHomeA;
	private JTextField txtPTT;
	static Helper Helper = new Helper();
	HelperPrikaz HelperP = new HelperPrikaz();
	private JTable table;
	private int ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Readers frame = new Readers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Prikaz() {
		String query = "SELECT * FROM readers";
		HelperP.PopuniTabelu(query, table);
	}
	
	public Readers() {
		initComponents();
		Prikaz();
	}

	public void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Legion\\Desktop\\Milan Buric fakultet\\Readers.jpg"));
		setTitle("Readers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1206, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1190, 711);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 112, 165, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 137, 165, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(20, 163, 165, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email Adress");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(20, 188, 165, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Home Adress");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(20, 213, 165, 13);
		panel.add(lblNewLabel_5);
		
		txtName = new JTextField();
		txtName.setBounds(175, 110, 235, 19);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(175, 135, 235, 19);
		panel.add(txtSurname);
		txtSurname.setColumns(10);
		
		txtPhoneN = new JTextField();
		txtPhoneN.setBounds(175, 161, 235, 19);
		panel.add(txtPhoneN);
		txtPhoneN.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(175, 186, 235, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtHomeA = new JTextField();
		txtHomeA.setBounds(175, 211, 235, 19);
		panel.add(txtHomeA);
		txtHomeA.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main_Menu MM = new Main_Menu();
				MM.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(10, 680, 153, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
if(txtName.getText().equals("") || txtSurname.getText().equals("") || txtEmail.getText().equals("") ||txtHomeA.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please Enter the necessary Information!");
				}else { 
					String Name = txtName.getText();
					String Surname = txtSurname.getText();
					String Phone_Number = txtPhoneN.getText();
					String Home_Address = txtHomeA.getText();
					String Email = txtEmail.getText();
					String PTT = txtPTT.getText();
					
					txtName.setText("");
					txtSurname.setText("");
					txtPhoneN.setText("");
					txtEmail.setText("");
					txtHomeA.setText("");
					txtPTT.setText("");
					
					Connection conn = Helper.DBSetup();
					String query = "INSERT INTO readers(Name, Surname, Phone_Number, Email, Home_Adress, PNR) VALUES ('"+Name+"', '"+Surname+"','"+Integer.valueOf(Phone_Number)+"', '"+Home_Address+"',"
							+ " '"+Email+"', '"+Integer.valueOf(PTT)+"')";
					
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
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(20, 320, 153, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name = txtName.getText();
				String Surname = txtSurname.getText();
				String PhNumb = txtPhoneN.getText();
				String Adress = txtHomeA.getText();
				String Email = txtEmail.getText();
				String PTT = txtPTT.getText();
				
				Connection connect = Helper.DBSetup();
				
				String sql = "UPDATE readers SET Name = '"+Name+"', Surname = '"+Surname+"', '" + "Phone_Number = '"+PhNumb+"', PN = '"+PTT+"', Adress = '"+Adress+"', Email_Adress = '"+Email+"' WHERE ID = '"+ID+"'";
						
		
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
		btnNewButton_2.setBounds(203, 320, 153, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	int i = Readers.getSelectedRow();
			//	if(i >= 0) {
					
				//	model.removeRow(i);
				//	JOptionPane.showMessageDialog(null, "Information Successfully Deleted!");
					
				//}else {
				//	JOptionPane.showMessageDialog(null, "Please Select The Row in the Table You Wish To Delete!");
				//}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(20, 366, 153, 21);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CLEAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtName.setText("");
				txtSurname.setText("");
				txtPhoneN.setText("");
				txtEmail.setText("");
				txtHomeA.setText("");
				txtPTT.setText("");
				
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setBounds(203, 366, 153, 21);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("READERS");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(10, 10, 221, 52);
		panel.add(lblNewLabel_6);
		
		txtPTT = new JTextField();
		txtPTT.setBounds(175, 235, 235, 20);
		panel.add(txtPTT);
		txtPTT.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("PTT");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(20, 237, 165, 14);
		panel.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(441, 25, 727, 660);
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
		        	String Phone = table.getModel().getValueAt(selRow, 3).toString();
		        	String PTT = table.getModel().getValueAt(selRow, 6).toString();
		        	String Email = table.getModel().getValueAt(selRow, 5).toString();
		        	String Address = table.getModel().getValueAt(selRow, 4).toString();
		        	int idForEdit = Integer.parseInt(table.getModel().getValueAt(selRow, 0).toString());
		        	//Phone email addres ptt
		        	txtName.setText(Name);
		        	txtSurname.setText(Surname);
					txtPhoneN.setText(Phone);
					txtPTT.setText(PTT);
					txtEmail.setText(Email);
					txtHomeA.setText(Address);
					ID = idForEdit;
		        	//String Surname = Integer.parseInt(table.getModel().getValueAt(selRow, 1).toString());
		        	JOptionPane.showMessageDialog(null,String.valueOf(idForEdit));
		        	//txtNazivPredstave.setText(NazivP);
		        }
		      }

		    });
		
	}
}
