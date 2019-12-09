package Assets;

public class Enemy {
	
	private int health;
	private String weapon;
	private String enemyclass;
	
	public Enemy (int health, String weapon, String playerclass) {
		this.health = health;
		this.weapon = weapon;
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
						+ "Health points: " + health
						+ "Weapon type: " + weapon
						+ "Class: " + enemyclass;
		
		return playerInfo;
	}

}

