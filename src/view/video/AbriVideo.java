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
		// Define que será usado a webcam ZERO
		VideoCapture videoCap = new VideoCapture(1);

		// Verifica se a webcam está conectada ...
		if (!videoCap.isOpened()) {
			JOptionPane.showMessageDialog(null, "Não conectou sua câmera");
		} else {

			Mat frame;
			frame = new Mat();
			//Essa sequência de retrieve serve apenas para forçar a primeira imagem da câmera a ser captura com um brilho relativamente melhor
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
			// Com um laço de 30, será criada 30 quadros.
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
		
		System.out.println("Aguarde: Iniciando geração das 59 imagens!");
		Thread.sleep(500);
		System.out.println("Gerando novas imagens em /NovosFrames");
		Thread.sleep(1000);
		new GerarNovosFrames(60, "frames");
		
		System.out.println("Aguarde: Iniciando processamento das novas imagens para geração dos dados estatísticos");
		Thread.sleep(1000);
		new AnalisaNovosFrames(59, "NovosFrames");
		
		Thread.sleep(1000);
		
		System.out.println("Geração de gráfico ainda não implementado. Finalizando execução.");
		Thread.sleep(1000);
		System.out.println("Execução finalizada");
		System.exit(0);
	}
}
