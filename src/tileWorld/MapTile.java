package tileWorld;

//TODO: implement unit class
/**
 * 
 * @author Seth G. R. Herendeen
 *
 */
public class MapTile {
	private String terrain;//base terrain imagefile
	private Unit unit;
	private TerrainFeature feature;
	
	
//	public static final byte NO_UNIT = 0;
	
	
	/**
	 * 
	 */
	public MapTile() {}
	
	/**
	 * @param terrain the image file for said terrain
	 * @param unit the byte value representing the unit; 0 represents no city.
	 * @param feature E.G: forest, city; feature represents the image
	 */
	public MapTile(String terrain, Unit unit, TerrainFeature feature) {
		this.terrain = terrain;
		this.unit = unit;
		this.feature = feature;
	}
	
	public String getTerrain() {
		return this.terrain;
	}
	
	public Unit getUnit() {
		return this.unit;
	}
	
	public TerrainFeature getTerrainFeature() {
		return this.feature;
	}
	/**
	 * Returns false if there is no unit, otherwise returns true
	 * @return
	 */
	public boolean hasUnit() {
		
		if(this.unit != null) {
			return true;
			
		}
		
		return false;
	}
	
	/**
	 * Returns whether or not the tile has a terrain feature by checking the filename for said terrain
	 * @return true if the imageFile name is greater than 1 in length
	 * 
	 * I know this looks sloppy
	 */
	public boolean doesTileHaveTerrainFeature() {
		if(this.feature == null || getTerrainFeature().getImageFile().length() < 1){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param terrain the image file for said terrain
	 */
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	/**
	 * Setter for Unit object for this tile of the map
	 * @param unit
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
	public void setFeature(TerrainFeature feature) {
		this.feature = feature;
	}
	/**
	 * Converts the individual tile to a string
	 */
	public String toString() {
		return this.terrain + " "+this.feature.toString()+this.unit.toString();				
				
	}
}
