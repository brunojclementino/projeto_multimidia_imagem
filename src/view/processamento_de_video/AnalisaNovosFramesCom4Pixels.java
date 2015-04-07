package view.processamento_de_video;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class AnalisaNovosFramesCom4Pixels {

	public AnalisaNovosFramesCom4Pixels(int qtdImagens, String pastaImagens) {
		System.loadLibrary("opencv_java2410");

		Mat frame = new Mat();
		frame = Highgui.imread(pastaImagens+"/foto1.jpg");
		double[] rgb = new double[3];
		int [][]dadosImagens = new int[qtdImagens][3];//Armazenará a quantidade de pixels com rgb menor que 4 para cada imagem;
		
		int largura = (int) frame.size().width;
		int altura = (int) frame.size().height;
		int contR, contG, contB;
		for(int i=1;i<=qtdImagens;i++){
			frame = Highgui.imread(pastaImagens+"/foto"+i+".jpg");
			contR = 0;
			contG = 0;
			contB = 0;
			for(int k=0;k<altura-1;k++){
				for(int l=0;l<largura-1;l++){
					
					rgb = frame.get(k, l);
					rgb = somaVetor(rgb, frame.get(k, l+1));
					rgb = somaVetor(rgb, frame.get(k+1, l));
					rgb = somaVetor(rgb, frame.get(k+1, l+1));
					
					
					
					if(rgb[0]/4<10) contB++;
					if(rgb[1]/4<10) contG++;
					if(rgb[2]/4<10) contR++;
					
					
					
					
				}
			}
			dadosImagens[i-1][0] = contR;
			dadosImagens[i-1][1] = contG;
			dadosImagens[i-1][2] = contB;
			System.out.println("Processou imagem "+i+" de "+qtdImagens);
		}
		
		new GerarGrafico(dadosImagens, frame.size(), qtdImagens, "graficos4Pixels");
	}

	private double[] somaVetor(double[] rgb, double[] pixel) {
		
		double[] soma = new double[rgb.length];
		for(int i=0;i<rgb.length;i++){
			
			soma[i] = rgb[i]+pixel[i];
			
		}
		
		return soma;
	}
}
