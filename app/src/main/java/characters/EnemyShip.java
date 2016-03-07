package characters;

public class EnemyShip implements Characters{
	private String enemyType = "";
	private int enemyHP = 0;
	private int enemyDPS = 0;
	
	public EnemyShip(){
//		TODO: create a list of enemy types and a function to choose it
		this.setEnemyType("Bird of Prey");
		this.setEnemyHP(40);
		this.setEnemyDPS(15);
	}

	public EnemyShip(String type, int hp, int dps){
		this.setEnemyType(type);
		this.setEnemyHP(hp);
		this.setEnemyDPS(dps);
	}
	
	public String getEnemyType() {
		return enemyType;
	}
	public void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
	}
	public int getEnemyHP() {
		return enemyHP;
	}
	public void setEnemyHP(int enemyHP) {
		this.enemyHP = enemyHP;
	}
	public int getEnemyDPS() {
		return enemyDPS;
	}
	public void setEnemyDPS(int enemyDPS) {
		this.enemyDPS = enemyDPS;
	}
	
	public void talk(){}
	public void attack(){}
}
