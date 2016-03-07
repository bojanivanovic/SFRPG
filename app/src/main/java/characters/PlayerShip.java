package characters;

public class PlayerShip implements Characters{
	
	private String playerName = "";
	private String playerClass = "";
	private int playerHP = 0;
	private int playerDPS = 0;
	
	public PlayerShip(){
		this.setPlayerName("Jean Luc Picard");
		this.setPlayerClass("Tactics");
		this.setPlayerHP((int)(Math.random()*100 + 51));
		this.setPlayerDPS((int)(Math.random()*50 + 51));
	}
	
	public PlayerShip(String name, String pClass){
		this.setPlayerName(name);
		this.setPlayerClass(pClass);
//		TODO: call class class to assign hp/dps values
		this.setPlayerHP(150);
		this.setPlayerDPS(50);
	}
	
	public PlayerShip(String name, String pClass, int hp, int dps){
		this.setPlayerName(name);
		this.setPlayerClass(pClass);
		this.setPlayerHP(hp);
		this.setPlayerDPS(dps);
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}
	
	public void setPlayerClass(int playerClass){
		switch(playerClass){
		case 1:
			this.setPlayerClass("Tactics");
			break;
		case 2:
			this.setPlayerClass("Engineering");
			break;
		case 3:
			this.setPlayerClass("Science");
			break;
		default:
			this.playerClass = "Tactics";
		}
	}

	public int getPlayerHP() {
		return playerHP;
	}

	public void setPlayerHP(int playerHP) {
		this.playerHP = playerHP;
	}

	public int getPlayerDPS() {
		return playerDPS;
	}

	public void setPlayerDPS(int playerDPS) {
		this.playerDPS = playerDPS;
	}
	
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
