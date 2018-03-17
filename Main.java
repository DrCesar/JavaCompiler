//package Compiler;

import Grammar.*;
import GUI.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.*;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.embed.swing.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.*;

public class Main extends Application {
	
	Scene scene1;
	TreeView<String> treeObject;
	Stage window;
	BorderPane borderLayout;
	HBox buttonLayout;
	TextArea codeField;
	TreeGenerator genTree;
	SwingNode embededTree;
	CustomVisitor semanticCheck = new CustomVisitor();

	public static void main (String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		DecafLexer nigga;
		
		window = primaryStage;
		window.setTitle("Compiler");

		borderLayout = new BorderPane();
		buttonLayout = new HBox();
		buttonLayout.setPadding(new Insets(10, 10, 10, 10));

		Button saveFileButton = new Button("Save");
		saveFileButton.setPrefSize(100, 20);
		Button compileButton = new Button("Compile");
		compileButton.setOnAction(e -> CompileCode());
		compileButton.setPrefSize(100, 20);

		buttonLayout.getChildren().addAll(saveFileButton, compileButton);
		borderLayout.setTop(buttonLayout);

		codeField = new TextArea();
		codeField.setPrefSize(300, 300);
		GetFileText("code.txt");
		borderLayout.setCenter(codeField);

		embededTree = new SwingNode();
		borderLayout.setRight(embededTree);

		TextArea errorField = new TextArea();
		borderLayout.setBottom(errorField);

		Scene scene = new Scene(borderLayout, 500, 500);
		window.setScene(scene);
		window.show();
	}

	public void CompileCode() {

		String code = this.codeField.getText();

		genTree = new TreeGenerator(code);

		embededTree.setContent(genTree.getDisplayTree());
		semanticCheck.visit(genTree.getTree());
	}



	public void GetFileText(String fileName) {

		try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {

			this.codeField.clear();
	        String line;
	        while ((line = reader.readLine()) != null)
	            this.codeField.appendText(line + "\n");

	    } catch (IOException e) {
	        e.printStackTrace();
	    }	
	}
}