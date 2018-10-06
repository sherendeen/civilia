package tileWorld;

public class TerrainFeature {

	private int yieldFood;
	private int yieldCash;
	private int yieldDefense;
	private int yieldWood;
	private int yieldOre;
	private boolean isCity;
	private String desc = "unknown";
	private String imageFile = "images/unknown.png";
	
	
	public TerrainFeature() {
		
	}
	
	/**
	 * Instantiates a Terrain Feature
	 * @param yieldFood the amount of food the terrain feature yields per turn
	 * @param yieldCash the amount of cash the terrain feature yields per turn
	 * @param yieldDefense defensive bonus during a given turn
	 * @param yieldWood the amount of wood yielded per turn
	 * @param yieldOre the amount of ore yielded per turn
	 * @param isCity whether or not the terrain feature is a city
	 */
	public TerrainFeature(int yieldFood, int yieldCash, int yieldDefense, int yieldWood, int yieldOre, boolean isCity) {
		
		this.yieldFood = yieldFood;
		this.yieldCash = yieldCash;
		this.yieldDefense = yieldDefense;
		this.yieldWood = yieldWood;
		this.yieldOre = yieldOre;
		this.isCity = isCity;
		
	}
	
	/**
	 * 
	 * Instantiates a Terrain Feature
	 * @param yieldFood the amount of food the terrain feature yields per turn
	 * @param yieldCash the amount of cash the terrain feature yields per turn
	 * @param yieldDefense defensive bonus during a given turn
	 * @param yieldWood the amount of wood yielded per turn
	 * @param yieldOre the amount of ore yielded per turn
	 * @param isCity whether or not the terrain feature is a city
	 * @param imageFile the actual file/path of the image
	 */
	public TerrainFeature(int yieldFood, int yieldCash, int yieldDefense, int yieldWood, int yieldOre, boolean isCity, String imageFile) {
		this.yieldFood = yieldFood;
		this.yieldCash = yieldCash;
		this.yieldDefense = yieldDefense;
		this.yieldWood = yieldWood;
		this.yieldOre = yieldOre;
		this.isCity = isCity;
		this.imageFile = imageFile;
	}
	
	/**
	 * Instantiates a Terrain Feature
	 * @param yieldFood the amount of food the terrain feature yields per turn
	 * @param yieldCash the amount of cash the terrain feature yields per turn
	 * @param yieldDefense defensive bonus during a given turn
	 * @param yieldWood the amount of wood yielded per turn
	 * @param yieldOre the amount of ore yielded per turn
	 * @param isCity whether or not the terrain feature is a city
	 * @param imageFile the file/path of the image
	 * @param desc the name of the image that can appear in-game (e.g: plains)
	 */
	public TerrainFeature(int yieldFood, int yieldCash, int yieldDefense, int yieldWood, int yieldOre, boolean isCity, String imageFile, String desc) {
		this.yieldFood = yieldFood;
		this.yieldCash = yieldCash;
		this.yieldDefense = yieldDefense;
		this.yieldWood = yieldWood;
		this.yieldOre = yieldOre;
		this.isCity = isCity;
		this.imageFile = imageFile;
		this.desc = desc;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getImageFile() {
		return this.imageFile;
	}
	
	public boolean isCity() {
		return this.isCity;
	}
	
	public int getYieldFood() {
		return this.yieldFood;
	}
	
	public int getYieldCash() {
		return this.yieldCash;
	}
	
	public int getYieldWood() {
		return this.yieldWood;
	}
	
	public int getYieldDefense() {
		return this.yieldDefense;
	}
	
	public int getYieldOre() {
		return this.yieldOre;
	}
	
	public String toString() {
		return ""+getYieldFood()+" "+getYieldCash()+" "+getYieldDefense()+ " "+getYieldOre()+" "+getYieldWood()+""
				+getDesc()+" "+getImageFile() + " "+isCity()+" ";
	}
	
}
