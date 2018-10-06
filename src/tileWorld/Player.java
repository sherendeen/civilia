package tileWorld;

import java.util.ArrayList;

public class Player {

	private String name;
	private float cash;
	
	public Player() {
		
	}
	
	/**
	 * Instantiates the Player class
	 * @param name the player name
	 * @param cash the amount of cash the player has
	 */
	public Player(String name, float cash) {
		this.name = name;
		this.cash = cash;
	}
	
	/**
	 * Instantiates the Player class
	 * @param name the player name
	 * @param cash the amount of cash the player has
	 * @param unitList the list of units that the player owns
	 */
//	public Player(String name, float cash, ArrayList<Unit> unitList) {
//		
//	}
//	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCash(float cash) {
		this.cash = cash;
	}
	
}
