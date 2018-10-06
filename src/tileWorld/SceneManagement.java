package tileWorld;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SceneManagement {

	public MapDisplay mapDisplay = new MapDisplay();
	public boolean isGameActive = false;//indicates whether the game is in fact active
	public GridPane gridPane = new GridPane();
	public VBox group = new VBox();
	public Label numberOfUnitMovesLabel = new Label("Moves: ");
	public Button endTurnButton = new Button();
	public Unit selectedUnit;
	public World map;
	
	
	//public ImageView[][] imgView;
	/**
	 * Basic initial test scene. There is nothing on it
	 * @return A scene object
	 */
	public Scene createScene() {
//		VBox group = new VBox();//
		
		
//		hbox = mapDisplay.showDefaultImage();
		gridPane = mapDisplay.showDefaultImage();
		
		//implement controls
		VBox controls = new VBox();
		
		//implement group stuff
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");
		Menu menuAbout = new Menu("About");
		ArrayList<MenuItem> list = createMenuItems();
		
		
		
		menuFile.getItems().addAll(list.get(1),list.get(2),list.get(3),list.get(4));
		menuAbout.getItems().addAll(list.get(0));
		menuBar.getMenus().addAll(menuFile, menuAbout);
		
		group.getChildren().add(menuBar);
		group.getChildren().add(gridPane);
		
		
		Scene scene = new Scene(group);
		
		
		
		return scene;
	}
	
	private VBox createControlBox() {
		VBox controls = new VBox();
		createEndTurnButton();
		controls.getChildren().add(endTurnButton);
		
		return controls;
	}
	
	
	
	private void createEndTurnButton() {
		
		endTurnButton.setText("End Turn");
		endTurnButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Turn ended");
				
			}
		
		});
		

	}
	
	/**
	 * Creates a new game and configures the map
	 */
	private void createNewGame() {
		Player playerOne = new Player();
		
		playerOne.setName("Seth");
		playerOne.setCash(10.0f);
		
		Player[] playerArray = {
				playerOne
		};
		map = new World(32, 32, "NewWorld.map", playerArray);

		mapDisplay.setMap(map);
		gridPane.getChildren().add(  mapDisplay.buildMapDisplay() );
		setGroupEventHandlerForUnit();
		group.getChildren().add(createControlBox());
		
		
	}
	
	/**
	 * Creates and configures
	 * the unit event handler 
	 */
	public void setGroupEventHandlerForUnit() {
		group.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				Unit unit = mapDisplay.getUnitList()[0][0];
				String characterCode = event.getCode().getName();
				System.out.println("key pressed: "+characterCode);
				
				switch(characterCode) {
				case "Up":
					map.getUnitFromLocation(unit.getUnitX(), unit.getUnitY()).setUnitY(unit.getUnitY()+1);
					
					break;
				case "Down":
					map.getUnitFromLocation(unit.getUnitX(), unit.getUnitY()).setUnitY(unit.getUnitY()-1);
					break;
				case "Right":
					map.getUnitFromLocation(unit.getUnitX(), unit.getUnitY()).setUnitX(unit.getUnitX()+1);
					break;
				case "Left":
					map.getUnitFromLocation(unit.getUnitX(), unit.getUnitY()).setUnitX(unit.getUnitX()-1);
					break;
				}
				
				
			}
		
		});
	}
	
	/**
	 * Creates and configures
	 * menuItemSave
	 * @return
	 */
	public MenuItem createMenuItemSave() {
		MenuItem menuItemSave = new MenuItem("Save game");
		menuItemSave.setOnAction(
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						//do something
						System.out.println("Save item clicked");
						FileManagement.saveMap(map);
						
					}
		});
		return menuItemSave;
	}
	
	/**
	 * Creates and configures
	 * menuItemLoad
	 * @return
	 */
	public MenuItem createMenuItemLoad() {
		MenuItem menuItemLoad = new MenuItem("Load game");
		menuItemLoad.setOnAction(
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						//do something
						System.out.println("Load item clicked");
					}
		});
		return menuItemLoad;
	}
	
	/**
	 * Creates and configures
	 * menuItemNew
	 * @return
	 */
	public MenuItem createMenuItemNew() {
		MenuItem menuItemNew = new MenuItem("New game");
		menuItemNew.setOnAction(
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						
						createNewGame();
						menuItemNew.setDisable(true);
					}
		});
		return menuItemNew;
	}
	
	/**
	 * Creates and configures
	 * menuItemExit
	 * @return
	 */
	public MenuItem createMenuItemExit() {
		MenuItem menuItemExit = new MenuItem("Exit game");
		menuItemExit.setOnAction(
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						MainClass.closeGame();
					}
		});
		return menuItemExit;
	}
	
	/**
	 * Creates and configures
	 * menuItemCredits
	 * @return returns the configured menuItemCredits
	 */
	public MenuItem createMenuItemCredits() {
		MenuItem menuItemCredits = new MenuItem("Credits");
		menuItemCredits.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Credits");
				alert.setHeaderText("Civilia - Version 1.0");
				alert.setContentText("Written by Seth G. R. Herendeen");
				alert.show();
			}
		});
		return menuItemCredits;
	}
	
	/**
	 * Creates the menu items for the menu bar
	 * @return returns an array list of menu items
	 */
	public ArrayList<MenuItem> createMenuItems(){
		ArrayList<MenuItem> list =new ArrayList<MenuItem>();
		MenuItem menuItemSave = createMenuItemSave();
		MenuItem menuItemLoad = createMenuItemLoad();
		MenuItem menuItemNew = createMenuItemNew();
		MenuItem menuItemExit = createMenuItemExit();
		MenuItem menuItemCredits = createMenuItemCredits();
		
		list.add(menuItemCredits);
		list.add(menuItemExit);
		list.add(menuItemNew);
		list.add(menuItemLoad);
		list.add(menuItemSave);
		return list;
	}
	
	
	
	
	
}
