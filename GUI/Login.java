
package GUI;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;


public class Login {
	
	public static void display(String title) {

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		/*grid.setVgap(8);
		grid.setHgap(10);*/


		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0);

		TextField nameInput = new TextField("Bucky");
		grid.setConstraints(nameInput, 1, 0);

		Label passLabel = new Label("Password: ");
		grid.setConstraints(passLabel, 0, 1);

		TextField passInput = new TextField();
		passInput.setPromptText("password");
		grid.setConstraints(passInput, 1, 1);

		Button loginButton = new Button("Login");
		grid.setConstraints(loginButton, 1, 2);

		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

		Scene scene = new Scene(grid, 300, 200);

		window.setScene(scene);
		window.show();
	}
}