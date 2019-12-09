package Assets;

public class Enemy {
	
	public int health;
	public String weapon;
	public int damage;
	public String enemyclass;
	
	public Enemy() {
		health = 200;
		weapon = "Club";
		damage = 10;
		enemyclass = "Ogre";
	}
	
	public Enemy (int health, String weapon, int damage, String playerclass) {
		this.health = health;
		this.weapon = weapon;
		this.damage = damage;
		this.enemyclass = playerclass;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public String getPlayerclass() {
		return enemyclass;
	}
	
	public void setPlayerclass(String playerclass) {
		this.enemyclass = playerclass;
	}
	
	@Override
	public String toString() {
		
		String playerInfo = "[Enemy's Stats]"
						+ "\n------------------------------\n"
						+ "\nHealth points: " + this.health
						+ "\nWeapon type: " + this.weapon
						+ "\nDamage: " + this.damage
						+ "\nClass: " + this.enemyclass;
		
		return playerInfo;
	}

}

