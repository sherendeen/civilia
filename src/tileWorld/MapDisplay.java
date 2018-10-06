package tileWorld;

import com.sun.istack.internal.NotNull;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * 
 * @author Seth G. R. Herendeen
 *
 */
public class MapDisplay {

	private int width;
	private int height;
//	private ImageView[][] imgView;
//	private HBox view = new HBox();
	private World map;
//	private GridPane gridPane = new GridPane();
	
//	private ImageView[][] terrain;
//	private ImageView[][] feature;
//	private ImageView[][] unitView;
	
	//For use in keeping track of where the fucking units are located
	private Unit[][] unitList;
	
	
	public MapDisplay() {
		this.width = 10;
		this.height = 10;
		
	}
	
	public MapDisplay(World world) {
		this.map = world;
		this.width = world.getWidth();
		this.height = world.getHeight();
	//	imgView = new ImageView[width][height];
	//	fillHBox();
	}
	
	public GridPane showDefaultImage() {
		GridPane gridPane = new GridPane();
		ImageView imgView = new ImageView();
		imgView.setImage(new Image("images/water.png"));
		Label label = new Label();
		label.setText("No world loaded");
		gridPane.getChildren().addAll(imgView,label);
		return gridPane;
	}
	
	
	
	/**
	 * This needs only to be done if you are 
	 * using the default constructor and not
	 *  creating everything immediately
	 */
//	public void instantiateImgView() {
//		imgView = new ImageView[map.getWidth()][map.getHeight()];
//	}
//	
	/**
	 * REFILLS the HBOX; essentially an update method
	 */
//	public void refillHbox() {
//		fillHBox();
//	}
//	
	/**
	 * Fills the HBox component with ImageViews representing the map
	 */
//	@NotNull
//	private void fillHBox()  {
//		//try {
//		for(int row = 0;row<imgView[0].length;row++) {
//			for(int col = 0;col<imgView[row].length;col++) {
//				//it looks long and painful and it is
//				Image img = new Image( map.getMap()[row][col].getTerrain() );
//				imgView[row][col].setImage(img);
//			}
//		}
//		
//		//} catch (Exception npe) {
			//npe.getStackTrace();
		//}
	//}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
//	public ImageView[][] getImgView(){
//		return this.imgView;
//	}
	
//	public HBox getView() {
//		return this.view;
//	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
//	public void setImageView(ImageView[][] imgView) {
//		this.imgView = imgView;
//	}
//	
//	public void setView(HBox view) {
//		this.view = view;
//	}
	
	public void setMap(World map) {
		this.map = map;
	}

	public Unit[][] getUnitList(){
		return unitList;
	}
	
	public void setUnitList(Unit[][] unitList) {
		this.unitList = unitList;
	}
	
	/**
	 * Builds the map according to the class specifications
	 */
	public GridPane buildMapDisplay() {
		GridPane gridPane = new GridPane();
		
		
		for( int i = 0;i<map.getWidth();i++) {
			
			for(int j = 0;j<map.getHeight();j++) {
				
				
				ImageView tmp = new ImageView(new Image(	map.getMap()[i][j].getTerrain()	) );
//				terrain[i][j] = new ImageView(new Image(	map.getMap()[i][j].getTerrain()	) );
				
				gridPane.add(tmp,i,j);
//				gridPane.add(terrain[i][j],i,j);
			}
			
		}
		for(int i = 0; i < map.getWidth(); i++) {
			for(int j = 0; j < map.getHeight(); j++) {
				if(map.getMap()[i][j].doesTileHaveTerrainFeature()) {
					ImageView tmp = new ImageView(new Image(map.getMap()[i][j].getTerrainFeature().getImageFile()	));
//					feature[i][j] = new ImageView(new Image(map.getMap()[i][j].getTerrainFeature().getImageFile()	));
					gridPane.add(tmp, i, j);
//					gridPane.add(feature[i][j], i, j);
				}
			}
		}
		
		unitList = new Unit[width][height];
		
		for(int i = 0; i < map.getWidth();i++) {
			for(int j = 0; j<map.getHeight();j++) {
				if(map.getMap()[i][j].hasUnit()) {
					ImageView tmp = new ImageView(new Image(map.getMap()[i][j].getUnit().getUnitFileName()	));
					
					
//					unitView[i][j] = new ImageView(new Image(map.getMap()[i][j].getUnit().getUnitFileName()	));
//					UnitView tmp = new UnitView(new Image(map.getMap()[i][j].getUnit().getUnitFileName()),unitList[i][j]	);
					
					unitList[i][j] = map.getMap()[i][j].getUnit();

					tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					
//					unitView[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							System.out.println(event.getX());
							System.out.println(event.getY());
							System.out.println("#######");
							displayUnitLocations();
							System.out.println("#######");
							System.out.println(map.getUnitFromLocation(event.getX(), event.getY()).getUnitName());
							
						}		
					});
					tmp.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
//					unitView[i][j].addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
						
						@Override
						public void handle(MouseEvent event) {
//							System.out.println(event.getX());
//							System.out.println(event.getY());
							
							//displayUnitLocations();
							
							
						//	System.out.println(  map.getUnitFromLocation((int)event.getSceneX(), (int)event.getSceneY()).getUnitName()    );
							
							
						}
						
					});
					
					gridPane.add(tmp, i, j);
//					gridPane.add(unitView[i][j], i, j);
				}
			}
		}
		
		
		return gridPane;
	}
	
	public void displayUnitLocations() {
		for(int i = 0; i < unitList[0].length;i++) {
			for(int j = 0;j<unitList[i].length;j++) {
				System.out.print(unitList[i][j].getUnitName() + " : "
			+unitList[i][j].getUnitX()+","+unitList[i][j].getUnitY() );
			}
			System.out.println();
		}
	}
}
