package Assets;

public class Player {
	private int health;
	private int attackdmg;
	private String weapon;
	private String playerclass;
	
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
		
		String playerInfo = "\n[Player's Stats]"
						+ "\n------------------------------\n"
						+ "Health points: " + health
						+ "Weapon type: " + weapon
						+ "Attack power: " + attackdmg
						+ "Class: " + playerclass;
		
		return playerInfo;
	}

}



