package view.video;

import java.io.File;

import javax.swing.JOptionPane;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import view.processamento_de_video.AnalisaNovosFrames;
import view.processamento_de_video.GerarNovosFrames;

public class AbriVideo {

	public AbriVideo() {
		// Define a biblioteca
		System.loadLibrary("opencv_java2410");
		// Define que ser� usado a webcam ZERO
		VideoCapture videoCap = new VideoCapture(1);

		// Verifica se a webcam est� conectada ...
		if (!videoCap.isOpened()) {
			JOptionPane.showMessageDialog(null, "N�o conectou sua c�mera");
		} else {

			Mat frame;
			frame = new Mat();
			//Essa sequ�ncia de retrieve serve apenas para for�ar a primeira imagem da c�mera a ser captura com um brilho relativamente melhor
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			videoCap.retrieve(frame);
			// Com um la�o de 30, ser� criada 30 quadros.
			for (int i = 0; i < 60; i++) {
				//try {
					frame = new Mat();
					videoCap.retrieve(frame);
					// Nomeia os 30 quadros de fotoX.jpg
					Highgui.imwrite("frames/" + "foto" + i + ".jpg", frame);
					//Thread.sleep(100);
				/*} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				System.out.println("Gerou imagem "+(i+1)+"/60");
			}
			
			
		}
	}

	public void concatenar() {
		Mat frame = new Mat();
		VideoCapture videoCap = new VideoCapture("video/");
		videoCap.retrieve(frame);
		Highgui.imwrite("video/", frame);
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Capturando imagens!");
		Thread.sleep(1000);
		new AbriVideo();
		
		System.out.println("Aguarde: Iniciando gera��o das 59 imagens!");
		Thread.sleep(500);
		System.out.println("Gerando novas imagens em /NovosFrames");
		Thread.sleep(1000);
		new GerarNovosFrames(60, "frames");
		
		System.out.println("Aguarde: Iniciando processamento das novas imagens para gera��o dos dados estat�sticos");
		Thread.sleep(1000);
		new AnalisaNovosFrames(59, "NovosFrames");
		
		Thread.sleep(1000);
		
		System.out.println("Gera��o de gr�fico ainda n�o implementado. Finalizando execu��o.");
		Thread.sleep(1000);
		System.out.println("Execu��o finalizada");
		System.exit(0);
	}
}
