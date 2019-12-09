package Game;

public class Items {
	
	private String Weapon;
	private String waterBottle;
	
	public Items(String Weapon, String waterBottle) {
		this.setWeapon(Weapon);
		this.setWaterBottle(waterBottle);
	}

	public String getWeapon() {
		return Weapon;
	}

	public void setWeapon(String weapon) {
		Weapon = weapon;
	}

	public String getWaterBottle() {
		return waterBottle;
	}

	public void setWaterBottle(String waterBottle) {
		this.waterBottle = waterBottle;
	}
	
	public String toString() {
		String info = "The items we have are: \n" + Weapon + "\n" + waterBottle;
		return info;
	}
	
}
