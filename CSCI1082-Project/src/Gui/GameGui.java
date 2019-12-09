package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameGui extends JFrame implements ActionListener{
	
	private JLabel label1 = new JLabel("Dungeon Battle");

	private Font font = new Font("", Font.BOLD, 50);
	private Font font1 = new Font("", Font.BOLD, 40);

	private JButton startBtn = new JButton("Start");
	private JButton quitBtn = new JButton("Quit");
	private JButton readyBtn = new JButton("Ready!");
	private JButton option1 = new JButton("Stab");
	private JButton option2 = new JButton("Punch");
	private JButton option3 = new JButton("Shoot");
	private JButton option4 = new JButton("Guard");

	private JTextArea output = new JTextArea();

	private JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel botPanel = new JPanel();
	private JPanel menuPanel = new JPanel(new GridLayout(4, 1));
	private JPanel newPanel = new JPanel(new GridLayout(2, 2));
	private JPanel textPanel = new JPanel(new GridLayout(1, 2));
	private JPanel prepPanel = new JPanel(new GridLayout(2, 1));

	public GameGui(String title) {
		super(title);
		setSize(800, 600);
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		createTopPanel();
		createMenuPanel();
		createNewPanel();
		createBotPanel();
		createTextPanel();
		createPrepPanel();
		addPanelsToFrame();
		additonalSettings();
		addActionListeners();

	}

	private void createTopPanel() {
		topPanel.setBackground(Color.black);
		topPanel.add(label1);
		label1.setFont(font);
		label1.setForeground(Color.white);
		topPanel.setBounds(250, 0, 500, 100);
		topPanel.add(textPanel, FlowLayout.CENTER);
		textPanel.setVisible(false);
	}

	private void createBotPanel() {
		botPanel.setBackground(Color.black);
		botPanel.add(menuPanel);
		botPanel.add(newPanel);
		botPanel.add(prepPanel);
		newPanel.setVisible(false);
		prepPanel.setVisible(false);
	}
	
	private void createPrepPanel() {
		prepPanel.setBackground(Color.black);
		prepPanel.add(readyBtn);
		newPanel.setVisible(false);
		
	}

	private void createMenuPanel() {
		menuPanel.setBackground(Color.black);
		menuPanel.setBounds(500, 550, 300, 100);
		menuPanel.add(startBtn);
		menuPanel.add(quitBtn);
		startBtn.setBackground(Color.black);
		startBtn.setForeground(Color.white);
		quitBtn.setBackground(Color.black);
		quitBtn.setForeground(Color.white);
	}

	private void createNewPanel() {
		newPanel.setBounds(0, 0, 500, 100);
		newPanel.add(option1);
		newPanel.add(option2);
		newPanel.add(option3);
		newPanel.add(option4);
	}

	private void createTextPanel() {
		textPanel.add(output);
	}

	private void addPanelsToFrame() {
		add(topPanel, BorderLayout.NORTH);
		add(botPanel, BorderLayout.CENTER);
	}

	private void addActionListeners() {
		startBtn.addActionListener(this);
		quitBtn.addActionListener(this);
		readyBtn.addActionListener(this);
		option1.addActionListener(this);
		option2.addActionListener(this);
		option3.addActionListener(this);
		option4.addActionListener(this);
	}

	private void additonalSettings() {
		output.setEditable(false);
		output.setBackground(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();

		if (callingBtn.equals("Start")) {
			topPanel.setBackground(Color.white);
			menuPanel.setVisible(false);
			prepPanel.setVisible(true);
			newPanel.setVisible(false);
			label1.setVisible(false);
			textPanel.setVisible(true);
			setLayout(new GridLayout(2, 2));
		} else if (callingBtn.equals("Quit")) {
			dispose();
		} else if (callingBtn.equals("Ready!")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			textPanel.setVisible(true);
			
		} else if (callingBtn.equals("Stab")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			textPanel.setVisible(true);
			output.append("You did 8 damage \n");
		} else if (callingBtn.equals("Punch")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			textPanel.setVisible(true);
			output.append("You did 5 damage \n");
		} else if (callingBtn.equals("Shoot")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			textPanel.setVisible(true);
			output.append("You did 3 damage \n");
		} else if (callingBtn.equals("Guard")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			textPanel.setVisible(true);
			output.append("You took no damage \n");
		}

	}

	public static void main(String[] args) {
		GameGui game = new GameGui("GAME");
		game.setVisible(true);
	}
}
