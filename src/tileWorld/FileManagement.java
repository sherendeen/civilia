package tileWorld;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Seth G. R. Herendeen
 * This class facilitates the loading and saving of map files
 *
 */
public class FileManagement {

	private String errorStatus;
	
	public World loadFile(String fileLocation) {
		JButton openable = new JButton();
		JFileChooser fileChooser = new JFileChooser();
		String resultString = new String();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new java.io.File(fileLocation));
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if(fileChooser.showOpenDialog(openable) == JFileChooser.APPROVE_OPTION) {
			// call upon our friendly little method for the actual reading process
			try {
				resultString = getFileText(fileChooser.getSelectedFile().getAbsolutePath());
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			
		} else {
			this.errorStatus = "declineLoad";
		}
		
		
		return loadWorldFromText(resultString);
	}

	/**
	 * converts text result to an actual world file with units and tiles and whatnot
	 * @param data
	 * @return
	 */
	private World loadWorldFromText(String data) {
		World world = new World();
		
		
		return world;
	}

	/**
	 * Gets the actual text content of the file
	 * @param absolutePath the direct, absolute path to the file
	 * @return the file contents
	 * @throws FileNotFoundException
	 */
	private String getFileText(String absolutePath) throws FileNotFoundException {
		File file = new File(absolutePath);// ABSOLUTELY PATH
		String result = "";
		if(!file.exists()) {
			this.errorStatus = "FileNotFound";
			return "";
		} else {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				result += scanner.nextLine()+"\n";
			}
			scanner.close();
		}
		
		return result;
	}
	
	public static void saveMap(World world) {
		JFileChooser fileChooser = new JFileChooser();
		
		String data = world.toString();
		
		fileChooser.setDialogTitle("Save map");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new java.io.File(world.getMapFileName()));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showSaveDialog(null);
		
		File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
		
		
		
		if(result == JFileChooser.APPROVE_OPTION) {
			
			
			try {
				PrintWriter pw = new PrintWriter(file);
				pw.print(data);
				pw.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
