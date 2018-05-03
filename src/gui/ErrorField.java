

package gui;

import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 * ErrorField uses javafx TextArea as aparent and is used for a new output for System.out
 * This component is for showing the errors of the Compiler, catches the output stream of System.out
 * and show it to the user.
 *
 * @author DrCesar
 * @version 1.0.0
 * @since 2018-01-13
 */
public class ErrorField extends BorderPane {
	
	private TextArea field;

	public ErrorField() {

		super();
		
		field = new TextArea();
		//field.setDisable(true);
		setCenter(field);
	}	

	public void appendText(String text) {

		field.appendText(text);
	}

	public void clear() {
		
		this.field.clear();
	}

}	