
package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class MainWindow extends Application {

	Stage window;

	// public static void main(String[] args) {
	// 	Application.launch(args);
	// }

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("Compiler");

		BorderPane borderLayout = new BorderPane();

		TextArea codeField = new TextArea();
		borderLayout.setCenter(codeField);

		TreeView displayTree = new TreeView();
		borderLayout.setRight(displayTree);

		TextArea errorField = new TextArea();
		borderLayout.setBottom(errorField);

		Scene scene = new Scene(borderLayout, 500, 500);
		window.setScene(scene);
		window.show();
	}
	

}