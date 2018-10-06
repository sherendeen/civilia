package tileWorld;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class World {

	private int width;
	private int height;
	private MapTile[][] map;
	private String mapFileName;
	private Player[] playerArray;
	private int numberOfPlayers;
	
	public World() {
		this.width = 10;
		this.height = 10;
		this.mapFileName = "map.map";
//		createWorld();
	}
	
	/**
	 * Instantiates the world class and generates a world
	 * @param width
	 * @param height
	 * @param mapFileName
	 */
	public World(int width, int height, String mapFileName) {
		this.width = width;
		this.height = height;
		this.mapFileName = mapFileName;

		createWorld();
	}
	
	public World(int width, int height, String mapFileName, Player[] playerArray) {
		this.width = width;
		this.height = height;
		this.mapFileName = mapFileName;
		this.playerArray = playerArray;
		this.numberOfPlayers = playerArray.length;

		createWorld();
	}
	
	public World(int width, int height, String mapFileName, int numberOfPlayers) {
		this.width = width;
		this.height = height;
		this.mapFileName = mapFileName;
		this.numberOfPlayers = numberOfPlayers;

		createWorld();
	}
	
	private void createPlayerArray() {
		this.playerArray = new Player[this.numberOfPlayers];
		for(int i = 0; i < playerArray.length; i++) {
			this.playerArray[i] = new Player("player_"+i, 10);
		}
		
	}
	
	private MapTile[][] createWorld(){
		map = new MapTile[width][height];
		createPlayerArray();
		//TODO: properly implement a starter unit limit
		byte starterLimit = 0;
		
		for(int row = 0;row<map[0].length;row++) {
			
			for(int col = 0;col<map[row].length;col++) {
				
				map[row][col] = chooseRandomMapTile();
				
				for(int i = 0;i<playerArray.length;i++) {
					
					if(starterLimit == 0 && (map[row][col].getTerrain() == "images/grassplain.png" ||
							map[row][col].getTerrain() == "images/desert.png"  )) {
						
						if((int)(Math.random() *2)+1==2) {
							starterLimit = 1;
							map[row][col].setUnit(getStarterUnit(playerArray[i], row, col));
						}
						
						
					}
				}
			}
			
		}
		
		return this.map;
	}
	
	/**
	 * Creates a settler unit
	 * @param playerNum the number representing the player
	 * @param x the x coordinate of where the starting unit is going
	 * @param y the y coordinate of where the starting unit is going
	 * @return a unit object
	 */
//	private Unit getStarterUnit(int playerNum, int x, int y) {
//		//Unit unit = new Unit(x, y, map[playerNum], "Settler", "images/settler.png");
//		Unit unit = new Unit(x, y, map[x][y].getUnit().getOwnerObject(), "Settler", "images/settler.png");
//		
//		return unit;
//	}
	
	/**
	 * Creates a settler unit
	 * @param player the number representing the player
	 * @param x the x coordinate of where the starting unit is going
	 * @param y the y coordinate of where the starting unit is going
	 * @return a unit object
	 */
	private Unit getStarterUnit(Player player, int x, int y) {
		Unit unit = new Unit(x, y, player, "Settler", "images/settler.png");
		return unit;
	}
	
	private MapTile chooseRandomMapTile() {
		MapTile mapTile = new MapTile();
		int chance = (int)(Math.random()*3)+1;
		switch(chance) {
		case 1:
			mapTile.setTerrain("images/grassplain.png");
			int featureChance = (int)(Math.random()*3)+1;
			if(featureChance==2) {
				
				mapTile.setFeature(new TerrainFeature(2,1,25,25,0,false,
				"images/trees.png","Forest"));
			
			} else if (featureChance==3) {
				
				mapTile.setFeature(new TerrainFeature(25,5,0,0,0,false,
						"images/wheat.png","Wheat field"));
				
			}
			
			break;
		case 2:
			mapTile.setTerrain("images/water.png");
			break;
		case 3:
			mapTile.setTerrain("images/desert.png");
			break;
		}
		
		return mapTile;
	}
	
	public int getWidth() {
		return this.width;
	}
	/**
	 * Gets the MapTile object from the specific coordinate that you specify
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the object
	 */
	public MapTile getTileFromCoordinate(int x, int y) {
		return this.map[x][y];
	}
	
	public Unit getUnitFromLocation(int x, int y) {
		return getTileFromCoordinate(x,y).getUnit();
	}
	
	public Unit getUnitFromLocation(double x, double y) {
		return getTileFromCoordinate((int)x, (int)y).getUnit();
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public MapTile[][] getMap(){
		return map;
	}
	
	public String getMapFileName() {
		return mapFileName;
	}
	
	public void setMapFileName(String mapFileName) {
		this.mapFileName = mapFileName;
	}
	
	public void setMap(MapTile[][] map) {
		this.map = map;
	}
	
//	public void setPlayerArray(Player[] playerArray) {
//		this.playerArray = playerArray;
//	}

	/**
	 * Might not be used after all
	 * @return an hbox representing the game world
	 */
	public HBox drawWorld() {
		HBox hbox = new HBox();
		//ImageView[][] imageArray = new ImageView[this.map[0].length][this.map]
		ArrayList<ImageView> imageList = new ArrayList<ImageView>();
//		ImageView imgView = new ImageView();
		
		
		for(int x = 0;x<this.map[0].length;x++) {
			for(int y = 0;y<this.map[x].length;y++) {
				Image img = new Image(map[x][y].getTerrain());
				imageList.add(new ImageView(img));
			}
			
			
		}
		
		
		return hbox;
	}
	
	/**
	 * Converts the entire world into a big string variable so that it can be saved as a text file
	 */
	public String toString() {
		String result = "";
		if(map != null && playerArray != null) {
			result += this.width+"\n";
			result += this.height+"\n";
			result += this.numberOfPlayers+"\n";
			for(int i = 0;i<map[0].length;i++) {
				for(int j = 0;j<map[i].length;j++) {
					result += map[i][j].toString();
				}
				
				
			}
			
			
		}
		
		return result;
	}
}
