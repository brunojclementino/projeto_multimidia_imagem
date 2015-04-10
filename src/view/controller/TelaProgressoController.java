package view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import view.TelaInicial;
import view.TelaProgresso;
import model.processamento_de_video.AnalisaNovosFrames;
import model.processamento_de_video.AnalisaNovosFramesCom4Pixels;
import model.processamento_de_video.GerarNovosFrames;
import model.video.ProcessarVideo;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaProgressoController implements Initializable {

	@FXML
	private ImageView imageViewFigura;
	@FXML
	private ImageView imageViewLetra;
	
	@FXML
	private ProgressBar progressBar;

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		TelaInicial.getStage().setIconified(true);

		imageViewFigura.setImage(new Image(getClass().getResourceAsStream(
				"/icones/iconDoSistema.png")));
		imageViewLetra.setImage(new Image(getClass().getResourceAsStream(
				"/icones/multimidia_logo.png")));
		
		doInBackground();

	}

	private void doInBackground() {

		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				
				new ProcessarVideo("SAMPLE.AVI");
				new GerarNovosFrames(42, "frames");
				new AnalisaNovosFrames(41, "NovosFrames");
				new AnalisaNovosFramesCom4Pixels(41, "NovosFrames");
				
				return null;

			}

			@Override
			protected void done() {

				super.done();

				Platform.runLater(new Runnable() {
					public void run() {
						TelaProgresso.getStage().close();
						//new TelaLogin().start(new Stage());
						TelaInicial.getStage().setIconified(false);
					}
				});

			}
		};
		progressBar.progressProperty().bind(task.progressProperty());
		new Thread(task).start();

	}
}