package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaProgresso extends Application {

	private static Stage myStage;

	@Override
	public void start(Stage primaryStage) {

		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource(
					"TelaProgresso.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		primaryStage.setTitle("Tela de Carregamento");
		primaryStage.show();

		TelaProgresso.myStage = primaryStage;

	}

	public static Stage getStage() {
		return myStage;
	}
}