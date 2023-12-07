package Pogledi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;

public class Game_Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_Menu frame = new Game_Menu();
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
	public Game_Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Legion\\Desktop\\Milan Buric fakultet\\Game menu.png"));
		setTitle("Game Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPacman = new JButton("Pacman");
		btnPacman.setIcon(new ImageIcon("C:\\Users\\Legion\\eclipse-workspace\\Seminarski rad Projektovanje softvera\\src\\Images\\left.gif"));
		btnPacman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pacman PM = new Pacman();
				PM.setVisible(true);
				
				
			}
		});
		btnPacman.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPacman.setBounds(10, 47, 196, 59);
		contentPane.add(btnPacman);
		
		JButton btnSpace = new JButton("Space Invaders");
		btnSpace.setIcon(new ImageIcon("C:\\Users\\Legion\\eclipse-workspace\\Seminarski rad Projektovanje softvera\\src\\Images\\shipSkin.gif"));
		btnSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SpaceInvaders SI = new SpaceInvaders();
				SI.setVisible(true);
			}
		});
		btnSpace.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSpace.setBounds(422, 47, 196, 59);
		contentPane.add(btnSpace);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main_Menu MM = new Main_Menu();
				MM.setVisible(true);
			}
		});
		btnBack.setBounds(197, 490, 177, 37);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Snake");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Legion\\eclipse-workspace\\Seminarski rad Projektovanje softvera\\Images\\Snake icon resized2.jpg"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Snake SN = new Snake();
				SN.setVisible(true);
			}
		});
		btnNewButton.setBounds(216, 47, 196, 59);
		contentPane.add(btnNewButton);
	}
}
