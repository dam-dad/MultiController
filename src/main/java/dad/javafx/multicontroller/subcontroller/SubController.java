package dad.javafx.multicontroller.subcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class SubController implements Initializable {

	// modelo

	private StringProperty text = new SimpleStringProperty();

	// vista

	@FXML
	private BorderPane view;

	@FXML
	private Label label;

	public SubController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SubView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		label.textProperty().bind(text);
		
	}

	public BorderPane getView() {
		return view;
	}

	public final StringProperty textProperty() {
		return this.text;
	}

	public final String getText() {
		return this.textProperty().get();
	}

	public final void setText(final String text) {
		this.textProperty().set(text);
	}

}
