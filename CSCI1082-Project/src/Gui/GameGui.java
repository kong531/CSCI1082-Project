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
	
	private JLabel label1 = new JLabel("Dungeon Battle");

	private Font font = new Font("", Font.BOLD, 64);
	private Font font1 = new Font("", Font.PLAIN, 15);
	
	private JButton startBtn = new JButton("Start");
	private JButton quitBtn = new JButton("Quit");
	private JButton readyBtn = new JButton("Ready!");
	private JButton option1 = new JButton("Stab");
	private JButton option2 = new JButton("Punch");
	private JButton option3 = new JButton("Kick");
	private JButton option4 = new JButton("Guard");
	private JButton exitBtn = new JButton("Return");
	
	private Dimension btnSize = new Dimension(100,50);

	public JTextArea output = new JTextArea(10, 10);
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
	private JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

	private Player player = new Player();
	private Enemy enemy = new Enemy();
	
	private Random rand = new Random();
	
	private int damage = 0;
	private int taken = 0;
	private int block = 0;
	public int playerHealth = player.health;
	public int enemyHealth = enemy.health;
	public int playerDamage = player.attackdmg;
	public int enemyDamage = enemy.damage;
	public String playerWeapon = player.weapon;
	public String playerClass = player.playerclass;
	public String enemyWeapon = enemy.weapon;
	public String enemyClass = enemy.enemyclass;

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
		createExitPanel();
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
		botPanel.add(exitPanel);
		newPanel.setVisible(false);
		prepPanel.setVisible(false);
		exitPanel.setVisible(false);
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
		playerInfo.setPreferredSize(new Dimension(320,200));
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
	
	private void createExitPanel() {
		exitPanel.add(exitBtn);
		exitBtn.setPreferredSize(btnSize);
		exitBtn.setBackground(Color.white);
		exitBtn.setForeground(Color.black);
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
		exitBtn.addActionListener(this);
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
			output.setText("");
			menuPanel.setVisible(false);
			prepPanel.setVisible(false);
			newPanel.setVisible(true);
			label1.setVisible(false);
			infoPanel.setVisible(false);
			textPanel.setVisible(true);
			
		} else if (callingBtn.equals("Stab")) {
			damage = rand.nextInt(player.attackdmg);
			taken = rand.nextInt(enemy.getDamage());
			
			output.append("You deal " + damage + " damage\n");
			output.append("The enemy dealt " + taken + " to you\n");
			
			playerHealth -= taken;
			enemyHealth -= damage;
			
			damage = 50;
			enemyDamage = 20;
			
			player = new Player(playerHealth, damage, playerWeapon, playerClass);
			enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
			playerInfo.setText("");
			enemyInfo.setText("");
			playerInfo.append(player.toString());
			enemyInfo.append(enemy.toString());
			
			if (playerHealth <= 0) {
				playerHealth = 0;
				player = new Player(playerHealth, damage, playerWeapon, playerClass);
				playerInfo.setText("");
				playerInfo.append(player.toString());
				output.append("You are dead! Game over!");
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
			
			else if (enemyHealth <= 0) {
				enemyHealth = 0;
				enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
				output.append("You have defeated the enemy!\n");
				enemyInfo.setText("");
				enemyInfo.append(enemy.toString());
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
			
		} else if (callingBtn.equals("Punch")) {
			damage = rand.nextInt(20);
			taken = rand.nextInt(enemy.getDamage());
			
			output.append("You deal " + damage + " damage\n");
			output.append("The enemy dealt " + taken + " to you\n");
			
			playerHealth -= taken;
			enemyHealth -= damage;
			
			damage = 50;
			enemyDamage = 20;
			
			player = new Player(playerHealth, damage, playerWeapon, playerClass);
			enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
			playerInfo.setText("");
			enemyInfo.setText("");
			playerInfo.append(player.toString());
			enemyInfo.append(enemy.toString());
			
			if (playerHealth <= 0) {
				playerHealth = 0;
				player = new Player(playerHealth, damage, playerWeapon, playerClass);
				output.append("You are dead! Game over!");
				playerInfo.setText("");
				playerInfo.append(player.toString());
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
			
			else if (enemyHealth <= 0) {
				enemyHealth = 0;
				enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
				output.append("You have defeated the enemy!\n");
				enemyInfo.setText("");
				enemyInfo.append(enemy.toString());
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
			
		} else if (callingBtn.equals("Kick")) {
			damage = rand.nextInt(10);
			taken = rand.nextInt(enemy.getDamage());
			
			output.append("You deal " + damage + " damage\n");
			output.append("The enemy dealt " + taken + " to you\n");
			
			playerHealth -= taken;
			enemyHealth -= damage;
			
			damage = 50;
			enemyDamage = 20;
			
			player = new Player(playerHealth, damage, playerWeapon, playerClass);
			enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
			playerInfo.setText("");
			enemyInfo.setText("");
			playerInfo.append(player.toString());
			enemyInfo.append(enemy.toString());
			
			if (playerHealth <= 0) {
				playerHealth = 0;
				player = new Player(playerHealth, damage, playerWeapon, playerClass);
				output.append("You are dead! Game over!");
				playerInfo.setText("");
				playerInfo.append(player.toString());
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
			
			else if (enemyHealth <= 0) {
				enemyHealth = 0;
				enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
				output.append("You have defeated the enemy!\n");
				enemyInfo.setText("");
				enemyInfo.append(enemy.toString());
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
			
		} else if (callingBtn.equals("Guard")) {
			damage = rand.nextInt(player.attackdmg);
			taken = rand.nextInt(enemy.getDamage());
			block = 10;
			int diff = taken - block;
			
			if (taken > block) {
				output.append("You block 10 damage\n");
				output.append("But the enemy deals " + diff + " damage\n");
				playerHealth -= diff;
			}
			
			else {
				output.append("You block " + taken + " damage\n");
			}
			
			taken = 0;
			
			playerHealth -= taken;
			
			damage = 50;
			enemyDamage = 20;
			
			player = new Player(playerHealth, damage, playerWeapon, playerClass);
			enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
			playerInfo.setText("");
			enemyInfo.setText("");
			playerInfo.append(player.toString());
			enemyInfo.append(enemy.toString());
			
			if (playerHealth <= 0) {
				playerHealth = 0;
				player = new Player(playerHealth, damage, playerWeapon, playerClass);
				output.append("You are dead! Game over!");
				playerInfo.setText("");
				playerInfo.append(player.toString());
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
			
			else if (enemyHealth <= 0) {
				enemyHealth = 0;
				enemy = new Enemy(enemyHealth, enemyWeapon, enemyDamage, enemyClass);
				output.append("You have defeated the enemy!\n");
				enemyInfo.setText("");
				enemyInfo.append(enemy.toString());
				newPanel.setVisible(false);
				exitPanel.setVisible(true);
			}
		}
		
		else if (callingBtn.equals("Return")) {
			exitPanel.setVisible(false);
			textPanel.setVisible(false);
			menuPanel.setVisible(true);
			label1.setVisible(true);
			player = new Player();
			playerInfo.setText("");
			playerInfo.append(player.toString());
			enemy = new Enemy();
			enemyInfo.setText("");
			enemyInfo.append(enemy.toString());
			damage = 0;
			taken = 0;
			block = 0;
			playerHealth = player.health;
			enemyHealth = enemy.health;
			playerDamage = player.attackdmg;
			enemyDamage = enemy.damage;
			playerWeapon = player.weapon;
			playerClass = player.playerclass;
			enemyWeapon = enemy.weapon;
			enemyClass = enemy.enemyclass;
		}
	}
}
