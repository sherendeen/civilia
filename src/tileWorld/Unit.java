package tileWorld;

import javafx.scene.image.Image;

/**
 * 
 * @author Seth G. R. Herendeen
 *	Similar to the units in the Civilization games.
 */
public class Unit {

	private Player owner;
	private String name;
	private String fileName;
	private int x;
	private int y;
	private byte maxmimumMovesPerTurn;
	private byte maximumHealth;
	private byte damage;
	private boolean isSelected;
	private byte movesMadeSoFar;
	
	/**
	 * Instantiates unit class. 
	 */
	public Unit() {
		
	}
	
	/**
	 * Instantiates unit class. 
	 * @param x x coordinate of the unit
	 * @param y y coordinate of the unit
	 * @param owner the player object who owns the unit
	 * @param name the name of the unit
	 * @param fileName the file path to the image represented as a String
	 */
	public Unit(int x, int y, Player owner, String name, String fileName) {
		this.x = x;
		this.y = y;
		this.owner = owner;
		this.name = name;
		this.fileName = fileName;
		this.maxmimumMovesPerTurn = 2;
		this.maximumHealth = 1;
		this.damage = 0;
		
	}
	/**
	 * Instantiates unit class. 
	 * @param x x coordinate of the unit
	 * @param y y coordinate of the unit
	 * @param owner the player object who owns the unit
	 * @param name the name of the unit
	 * @param fileName the file path to the image represented as a String
	 * @param maximumMovesPerTurn the maximum number of moves that the unit that do in a given turn
	 * @param maximumHealth the maximum amount of health that the unit can have
	 * @param minimum amount of damage this unit can inflict on enemies
	 */
	public Unit(int x, int y, Player owner, String name, String fileName, byte maximumMovesPerTurn, byte maximumHealth, byte damage) {
		this.x = x;
		this.y = y;
		this.owner = owner;
		this.name = name;
		this.fileName = fileName;
		this.maxmimumMovesPerTurn = maximumMovesPerTurn;
		this.maximumHealth = maximumHealth;
		this.damage = damage;
	}
	
	public int getUnitX() {
		return this.x;
	}
	
	public int getUnitY() {
		return this.y;
	}
	
	public Player getOwnerObject() {
		return this.owner;
	}
	
	public String getUnitName() {
		return this.name;
	}
	
	public String getUnitFileName() {
		return this.fileName;
	}
	
	public byte getMaximumMovesPerTurn() {
		return this.maxmimumMovesPerTurn;
	}
	
	public byte getMaximumHealth() {
		return this.maximumHealth;
	}
	
	public byte getDamage() {
		return this.damage;
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public byte getMovesMadeSoFar() {
		return this.movesMadeSoFar;
	}
	
	public void setUnitX(int x) {
		this.x = x;
	}
	
	public void setUnitY(int y) {
		this.y = y;
	}
	
	public void setOwnerObject(Player owner) {
		this.owner = owner;
	}
	
	public void setUnitName(String name) {
		this.name = name;
	}
	
	public void setUnitFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setMaximumMovesPerTurn(byte maxmimumMovesPerTurn) {
		this.maxmimumMovesPerTurn = maxmimumMovesPerTurn;
	}
	
	public void setMaximumHealth(byte maximumHealth) {
		this.maximumHealth = maximumHealth;
	}
	
	public void setDamage(byte damage) {
		this.damage = damage;
	}
	
	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public void setMovesMadeSoFar(byte movesMadeSoFar) {
		this.movesMadeSoFar = movesMadeSoFar;
	}
	
	public Image getImage() {
		return new Image(fileName);
	}
	
	public String toString() {
		return ""+getDamage() + " "+getMaximumHealth()+" "
	+getMaximumMovesPerTurn()+ " "+getMovesMadeSoFar() + " "
				+getUnitFileName()+" "+getUnitName()+" "+getUnitX() + " "+getUnitY()+" "+getIsSelected();
	}
}
