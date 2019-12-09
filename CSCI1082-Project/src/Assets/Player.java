package Assets;

public class Player {
	public int health;
	public int attackdmg;
	public String weapon;
	public String playerclass;
	
	public Player() {
		health = 100;
		attackdmg = 50;
		weapon = "Long Sword";
		playerclass = "Warrior";
	}
	public Player (int health, int attackdmg, String weapon, String playerclass) {
		this.health = health;
		this.attackdmg = attackdmg;
		this.weapon = weapon;
		this.playerclass = playerclass;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getAttackdmg() {
		return attackdmg;
	}
	
	public void setAttackdmg(int attackdmg) {
		this.attackdmg = attackdmg;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public String getPlayerclass() {
		return playerclass;
	}
	
	public void setPlayerclass(String playerclass) {
		this.playerclass = playerclass;
	}
	
	@Override
	public String toString() {
		
		String playerInfo = "[Player's Stats]"
						+ "\n------------------------------\n"
						+ "\nHealth points: " + this.health
						+ "\nWeapon type: " + this.weapon
						+ "\nAttack power: " + this.attackdmg
						+ "\nClass: " + this.playerclass;
		
		return playerInfo;
	}

}



