package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaInicial extends Application {
	
	private static Stage myStage;
	
	@Override
	public void start(Stage primaryStage) {

		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource(
					"TelaInicial.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multimídia");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icones/iconDoSistema.png")));
		primaryStage.setResizable(false);
		primaryStage.show();

		TelaInicial.myStage = primaryStage;

	}
	
	public static Stage getStage() {
		return myStage;
	}

}
