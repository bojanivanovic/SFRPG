package characters;

public class NPC implements Characters{
	private String npcName = "";
	private int npcHP = 0;
	private int npcDPS = 0;
	
	public NPC(){
		this.setNpcName("Federation vessel");
		this.setNpcHP(150);
		this.setNpcDPS(50);
	}
	
	public NPC(String name, int hp, int dps){
		this.setNpcName(name);
		this.setNpcHP(hp);
		this.setNpcDPS(dps);
	}
	
	public String getNpcName() {
		return npcName;
	}
	public void setNpcName(String npcName) {
		this.npcName = npcName;
	}
	public int getNpcHP() {
		return npcHP;
	}
	public void setNpcHP(int npcHP) {
		this.npcHP = npcHP;
	}
	public int getNpcDPS() {
		return npcDPS;
	}
	public void setNpcDPS(int npcDPS) {
		this.npcDPS = npcDPS;
	}
	
	public void talk(){}
	public void attack(){}
}
