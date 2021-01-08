/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Veronica
 */
public class App extends Application {
    @Override
	public void start(Stage stage) {
		PaneOrganizer organizer = new PaneOrganizer();			/*write our PaneOrganizer class later, 		      where we will instantiate the root Pane */

		Scene scene = new Scene(organizer.getRoot(),200,200);
		stage.setScene(scene);
		stage.setTitle("Color Changer!");
		stage.show();

	}
        public static void main(String[] args) {
                launch(args);
            }
}
