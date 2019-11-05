package dad.javafx.multicontroller.root;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.multicontroller.subcontroller.SubController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController implements Initializable {

	// subcontroladores

	private SubController sub;

	// modelo

	private StringProperty text = new SimpleStringProperty();

	// vista

	@FXML
	private TabPane view;
	
	@FXML
	private Tab subTab;

	public RootController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			sub = new SubController();
			// TODO resto de controladores
		} catch (IOException e) {
			e.printStackTrace();
		}

		subTab.setContent(sub.getView());

		sub.textProperty().bind(text);
		
	}

	public TabPane getView() {
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
