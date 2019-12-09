package Gui;

import java.util.Random;
import Assets.Player;

public class Combat {
	
	private Player player = new Player(100, 50, "Long Sword", "Warrior");
	
	String[] enemies = { "Dark Knight, Blaze Imp, Black Phantom, Servants of the Lich King "};
	
	int enemyHealth = 200;
	int enemyAttackdmg = 50;
	
	
	@Override
	public String toString() {
		
	//	int damageDealt = Random.nextInt(player.getAttackdmg());
	//	int damageTaken = Random.nextInt(enemyAttackdmg);
		
		String mainAttack = " ";
	
		return mainAttack;
	}
	
	
	

}