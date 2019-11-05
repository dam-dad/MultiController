package dad.javafx.multicontroller;

import dad.javafx.multicontroller.root.RootController;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MultiApp extends Application {
	
	private StringProperty text = new SimpleStringProperty();

	private RootController root;
	
	@Override
	public void init() throws Exception {
		text.set("Aquí le damos valor al texto, y tiene que salir en el label del subcontrolador");
		super.init();
	}
	
	@Override
	public void stop() throws Exception {
		// TODO coger datos de root y guardar en fichero
		super.stop();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		root = new RootController();
		root.textProperty().bind(text);
		
		primaryStage.setTitle("MultiController en JavaFX");
		primaryStage.setScene(new Scene(root.getView(), 640, 480));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
