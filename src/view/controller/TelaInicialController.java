package view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import view.TelaInicial;
import view.TelaProgresso;
import model.imagem.Cam;
import model.imagem.GeraImagem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

	public void initialize(URL location, ResourceBundle resources) {
		
		buttonCarregarImagens.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				new Cam().tiraFoto();
				new GeraImagem().gerar("tratamentoDeImagens/foto1.jpg", "tratamentoDeImagens/foto2.jpg");
				
				Image imagem1 = new Image("/view/controller/fotos/foto1.jpg");
				Image imagem2 = new Image("/view/controller/fotos/foto2.jpg");
				Image imagemResultante = new Image("/view/controller/fotos/fotoResultante.jpg");
				
				ImageView im1 = new ImageView();
				ImageView im2 = new ImageView();
				ImageView imResultante = new ImageView();
				
				im1.setImage(imagem1);
				im2.setImage(imagem2);
				imResultante.setImage(imagemResultante);
				
				im1.setFitHeight(200);
				im1.setFitWidth(260);
				
				im2.setFitHeight(200);
				im2.setFitWidth(260);
				
				imResultante.setFitHeight(200);
				imResultante.setFitWidth(260);
				
				paneFoto1.getChildren().add(im1);
				paneFoto2.getChildren().add(im2);
				paneFotoResultante.getChildren().add(imResultante);
				
			}
		});
		
		buttonCarregarGraficos.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				new TelaProgresso().start(new Stage());
					
				if(TelaInicial.getStage().isIconified() == true) {
					Image grafico1 = new Image("/view/controller/graficos/com1Pixel/graficoRGB1Pixel.jpg");
					Image grafico2 = new Image("/view/controller/graficos/com4Pixel/graficoRGB4Pixels.jpg");
					
					ImageView gra1 = new ImageView();
					ImageView gra2 = new ImageView();
					
					gra1.setImage(grafico1);
					gra2.setImage(grafico2);
					
					gra1.setRotate(-90);
					gra2.setRotate(-90);
					
					gra1.setTranslateX(105);
					gra1.setTranslateY(-80);
					
					gra2.setTranslateX(105);
					gra2.setTranslateY(-80);
					
					gra1.setFitHeight(380);
					gra1.setFitWidth(190);
					
					gra2.setFitHeight(380);
					gra2.setFitWidth(190);
					
					paneGraficoCom1Pixel.getChildren().add(gra1);
					paneGraficoCom4Pixel.getChildren().add(gra2);
										
				}
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