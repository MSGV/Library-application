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

public class List_Of_Books extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtGenre;
	private JTextField txtStock;
	private int ID;
	
	static Helper Helper = new Helper();
	HelperPrikaz HelperP = new HelperPrikaz();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_Of_Books frame = new List_Of_Books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public List_Of_Books() {
		initComponents();
		Prikaz();
	}
	
	public void Prikaz() {
		String query = "SELECT * FROM books";
		HelperP.PopuniTabelu(query, table);
	}
	
		private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Legion\\Desktop\\Milan Buric fakultet\\LOB.png"));
		setTitle("List Of Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1151, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(36, 99, 75, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Genre");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(36, 124, 75, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Stock");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(36, 149, 75, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Title");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(36, 73, 75, 13);
		panel.add(lblNewLabel_4);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(146, 73, 186, 19);
		panel.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtAuthor = new JTextField();
		txtAuthor.setBounds(146, 99, 186, 19);
		panel.add(txtAuthor);
		txtAuthor.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setBounds(146, 124, 186, 19);
		panel.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(146, 149, 186, 19);
		panel.add(txtStock);
		txtStock.setColumns(10);

		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main_Menu MM = new Main_Menu();
				MM.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(10, 650, 146, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(txtTitle.getText().equals("") || txtAuthor.getText().equals("") || txtGenre.getText().equals("") || txtStock.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please Enter the necessary Information!");
				}else { 
					
					String Title = txtTitle.getText();
					String Genre = txtGenre.getText();
					String Author = txtAuthor.getText();
					String Stock = txtStock.getText();
					
					txtTitle.setText("");
					txtGenre.setText("");
					txtAuthor.setText("");
					txtStock.setText("");
					
					Connection conn = Helper.DBSetup();
					String query = "INSERT INTO books(Title, Author, Genre, Stock) VALUES ('"+Title+"', '"+Author+"', '"+Genre+"', '"+Integer.valueOf(Stock)+"')";
					
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
		btnNewButton_1.setBounds(10, 280, 145, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Title = txtTitle.getText();
				String Genre = txtGenre.getText();
				String Author = txtAuthor.getText();
				String Stock = txtStock.getText();
				
				Connection connect = Helper.DBSetup();
				
				String sql = "UPDATE books SET title='"+Title+"', Genre = '"+Genre+"', Author='"+Author+"', Stock = '"+Integer.valueOf(Stock)+"' WHERE IDN = '"+ID+"'";
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
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(186, 280, 145, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connect = Helper.DBSetup();
				String sql = "DELETE FROM books WHERE IDN = "+ID+"";
				System.out.print(sql);
				
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
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(10, 324, 145, 21);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CLEAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtTitle.setText("");
				txtAuthor.setText("");
				txtGenre.setText("");
				txtStock.setText("");
				JOptionPane.showMessageDialog(null, "Information Successfully Added!");
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setBounds(187, 324, 145, 21);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("LIST OF BOOKS");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(10, 0, 266, 60);
		panel.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 24, 761, 632);
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
		        	String Title = table.getModel().getValueAt(selRow, 1).toString();
		        	String Genre = table.getModel().getValueAt(selRow, 2).toString();
		        	String Author = table.getModel().getValueAt(selRow, 3).toString();
		        	String Stock = table.getModel().getValueAt(selRow, 4).toString();
		        	int idForEdit = Integer.parseInt(table.getModel().getValueAt(selRow, 0).toString());
		        	//Phone email addres ptt
		        	txtTitle.setText(Title);
		        	txtGenre.setText(Genre);
		        	txtAuthor.setText(Author);
					txtStock.setText(Stock);
					ID = idForEdit;
		        	//String Surname = Integer.parseInt(table.getModel().getValueAt(selRow, 1).toString());
		        	JOptionPane.showMessageDialog(null,String.valueOf(idForEdit));
		        	//txtNazivPredstave.setText(NazivP);
		        }
		      }

		    });
	}
}
