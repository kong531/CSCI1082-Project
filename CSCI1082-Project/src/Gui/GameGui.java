package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Assets.Enemy;
import Assets.Player;

public class GameGui extends JFrame implements ActionListener{
	
Random rand = new Random();
	
	int enemyAttackDamage = 25;
	int myAttackDamage = 50;
	
	
	private JLabel label1 = new JLabel("Dungeon Battle"); 

	private Font font = new Font("", Font.BOLD, 64);
	private Font font1 = new Font("", Font.PLAIN, 15);

	private JButton startBtn = new JButton("Start");
	private JButton quitBtn = new JButton("Quit");
	private JButton readyBtn = new JButton("Ready!");
	private JButton option1 = new JButton("Stab");
	private JButton option2 = new JButton("Punch");
	private JButton option3 = new JButton("Shoot");
	private JButton option4 = new JButton("Guard");
	
	private Dimension btnSize = new Dimension(100,50);

	private JTextArea output = new JTextArea();
	private JTextArea playerInfo = new JTextArea();
	private JTextArea enemyInfo = new JTextArea();
	private JTextArea info = new JTextArea();
	
	private JScrollPane scroll = new JScrollPane(output);

	private JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel botPanel = new JPanel();
	private JPanel menuPanel = new JPanel(new GridLayout(2, 1));
	private JPanel newPanel = new JPanel(new GridLayout(2, 2));
	private JPanel textPanel = new JPanel(new GridLayout(1,1));
	private JPanel prepPanel = new JPanel(new GridLayout(2, 1));
	private JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	private Combat combat = new Combat();
	private Player player = new Player(100, 50, "Long Sword", "Warrior");
	private Enemy enemy = new Enemy(200, "Sword", "Warrior");
	
	public GameGui(String title) {
		super(title);
		setSize(1000, 700);
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setVisible(true);
		createTopPanel();
		createMenuPanel();
		createNewPanel();
		createBotPanel();
		createTextPanel();
		createPrepPanel();
		createPlayerInfo();
		createEnemyInfo();
		createInfoPanel();
		addPanelsToFrame();
		additonalSettings();
		addActionListeners();

	}

	

	private void createTopPanel() {
		topPanel.setBackground(Color.black);
		topPanel.add(label1);
		label1.setFont(font);
		label1.setForeground(Color.white);
		topPanel.add(textPanel);
		textPanel.setVisible(false);
		topPanel.add(infoPanel);
		infoPanel.setVisible(false);
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
		readyBtn.setBackground(Color.black);
		readyBtn.setForeground(Color.white);
		readyBtn.setPreferredSize(new Dimension(btnSize));
		newPanel.setVisible(false);
		
	}

	private void createMenuPanel() {
		menuPanel.setBackground(Color.black);
		menuPanel.setBounds(500, 550, 300, 100);
		menuPanel.add(startBtn);
		menuPanel.add(quitBtn);
		startBtn.setBackground(Color.black);
		startBtn.setForeground(Color.white);
		startBtn.setPreferredSize(new Dimension(btnSize));
		quitBtn.setBackground(Color.black);
		quitBtn.setForeground(Color.white);
	}

	private void createNewPanel() {
		newPanel.setBounds(0, 0, 500, 100);
		newPanel.add(option1);
		option1.setPreferredSize(btnSize);
		option1.setBackground(Color.black);
		option1.setForeground(Color.white);
		newPanel.add(option2);
		option2.setPreferredSize(btnSize);
		option2.setBackground(Color.black);
		option2.setForeground(Color.white);
		newPanel.add(option3);
		option3.setPreferredSize(btnSize);
		option3.setBackground(Color.black);
		option3.setForeground(Color.white);
		newPanel.add(option4);
		option4.setPreferredSize(btnSize);
		option4.setBackground(Color.black);
		option4.setForeground(Color.white);
	}

	private void createTextPanel() {
		textPanel.add(playerInfo);
		playerInfo.setPreferredSize(new Dimension(320,330));
		playerInfo.setForeground(Color.white);
		textPanel.add(scroll, BorderLayout.EAST);
		textPanel.add(enemyInfo);
		enemyInfo.setForeground(Color.white);
	}
	
	private void createPlayerInfo() {
		playerInfo.setBackground(Color.white);
		playerInfo.setForeground(Color.black);
		playerInfo.append(player.toString());
	}
	
	private void createEnemyInfo() {
		enemyInfo.setBackground(Color.white);
		enemyInfo.setForeground(Color.black);
		enemyInfo.append(enemy.toString());
	}
	
	private void createInfoPanel() {
		infoPanel.add(info);
		info.setPreferredSize(new Dimension(900, 200));
		info.append("Welcome adventurer! There’s a dungeon full of valuable treasures, don’t come back empty handed! "
				+ "Be warned, the wicked \ncreatures that lurks within will try to stop any trespassers. "
				+ "Remember, you are an adventurer, if those monsters give you trouble, \nshow em who's boss.\n\n"
				+ "Instructions:\r\n" + 
				"You have four sets of actions, each having their own effects that help you combat the various creatures that dares to stop you.");
		info.setFont(font1);
		info.setBackground(Color.white);
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
		info.setEditable(false);
		info.setBackground(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();

		if (callingBtn.equals("Start")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(true);
			newPanel.setVisible(false);
			label1.setVisible(false);
			infoPanel.setVisible(true);
			
		} else if (callingBtn.equals("Quit")) {
			dispose();
		} else if (callingBtn.equals("Ready!")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			infoPanel.setVisible(false);
			textPanel.setVisible(true);
			
		} else if (callingBtn.equals("Stab")) {
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			textPanel.setVisible(true);
			int damageGiven = rand.nextInt(myAttackDamage);
			int health = enemy.getHealth() - damageGiven;
			enemy.setHealth(health);
			output.append("Enemy HP: ");
			output.append(String.valueOf(enemy.getHealth()));
			output.append(String.valueOf(damageGiven)); 
			output.append(" Damage was given");
			int damageTaken = rand.nextInt(enemyAttackDamage);
			int health2 = player.getHealth() - damageTaken;
			player.setHealth(health2);
			output.append("Player HP: ");
			output.append(String.valueOf(player.getHealth()));
			output.append("\nYou took  ??? amount of damage\n");
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
