package Pogledi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Main_Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu frame = new Main_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Legion\\Desktop\\Milan Buric fakultet\\MPAPP.png"));
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setTitle("MPAPP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 821, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLibrarians = new JButton("Librarians");
		btnLibrarians.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLibrarians.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Librarians LB = new Librarians();
				LB.setVisible(true);
			}
		});
		btnLibrarians.setBounds(286, 24, 154, 21);
		panel.add(btnLibrarians);
		
		JButton btnBooks = new JButton("List Of Books");
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				List_Of_Books LOB = new List_Of_Books();
				LOB.setVisible(true);
			}
		});
		btnBooks.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBooks.setBounds(286, 55, 154, 21);
		panel.add(btnBooks);
		
		JButton btnReaders = new JButton("Readers");
		btnReaders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Readers RD = new Readers();
				RD.setVisible(true);
			}
		});
		btnReaders.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReaders.setBounds(286, 86, 154, 21);
		panel.add(btnReaders);
		
		JButton btnGameMenu = new JButton("Game Menu");
		btnGameMenu.setIcon(null);
		btnGameMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Game_Menu GM = new Game_Menu();
				GM.setVisible(true);
			}
		});
		btnGameMenu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGameMenu.setBounds(286, 120, 154, 21);
		panel.add(btnGameMenu);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuit.setBounds(325, 512, 85, 21);
		panel.add(btnQuit);
	}
}
