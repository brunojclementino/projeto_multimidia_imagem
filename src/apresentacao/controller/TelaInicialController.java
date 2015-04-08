package apresentacao.controller;

import java.net.URL;
import java.util.ResourceBundle;

import view.imagem.Cam;
import view.imagem.GeraImagem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TelaInicialController implements Initializable {
	
	@FXML
	private Button buttonCarregarImagens;
	@FXML
	private Button buttonCarregarGraficos;
	
	@FXML
	private Pane paneFoto1;
	@FXML
	private Pane paneFoto2;
	@FXML
	private Pane paneFotoResultante;
	
	@FXML
	private Pane paneGraficoCom1Pixel;
	@FXML
	private Pane paneGraficoCom4Pixel;
	
	@FXML
	private ImageView imageViewCarregarImagens;
	@FXML
	private ImageView imageViewCarregarGraficos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		buttonCarregarImagens.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/*new Cam().tiraFoto();
				new GeraImagem().gerar("tratamentoDeImagens/foto1.jpg", "tratamentoDeImagens/foto2.jpg");*/
				
				Image imagem = new Image("/apresentacao/controller/graficoRGB.jpg");
				ImageView im = new ImageView();
				im.setImage(imagem);
				im.setRotate(-90);
				
				im.setFitHeight(200);
				im.setFitWidth(260);
				paneFoto1.getChildren().add(im);
				
				
			}
		});
		
		Image imagemCarregarImagens = new Image("/icones/loading.png");
		imageViewCarregarImagens.setImage(imagemCarregarImagens);
		
		Image imagemCarregarGraficos = new Image("/icones/grafic.png");
		imageViewCarregarGraficos.setImage(imagemCarregarGraficos);
		
		buttonCarregarImagens.setGraphic(imageViewCarregarImagens);
		buttonCarregarGraficos.setGraphic(imageViewCarregarGraficos);
	}
	
	

}
