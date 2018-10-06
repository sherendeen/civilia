package tileWorld;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * 
 * @author Seth G. R. Herendeen
 * 
 */
public class MainClass extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}

	private Stage stage;
	
	@Override
	public void start(Stage stage) throws Exception {
		SceneManagement sMgmt = new SceneManagement();
		
		// Create a scene and place it in the stage
		stage.setTitle("Civilia"); // Set the stage title
		stage.setScene(sMgmt.createScene()); // Place the scene in the stage
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		/** Reference for automatic resolution scaling:
		* <a href="http://www.java2s.com/Code/Java/JavaFX/GetScreensize.htm">reference</a>
		*/
		//set Stage boundaries to visible bounds of the main screen
		stage.setX(primaryScreenBounds.getMinX());
		stage.setY(primaryScreenBounds.getMinY());
		//stage.isMaximized();
		stage.setMaximized(true);
		
		//stage.setFullScreen(true);
		stage.setWidth(primaryScreenBounds.getWidth());
		stage.setHeight(primaryScreenBounds.getHeight());
        
		//
		stage.show(); // Display the stage
	}
	
	public static void closeGame() {
		Platform.exit();
	}
	
}
