package view.processamento_de_video;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

public class GerarNovosFrames {
	
	public GerarNovosFrames(int qtdFrames, String pastaComFrames) {
		
		System.loadLibrary("opencv_java2410");
		VideoCapture videoCapture = new VideoCapture();
		
		Mat frame1 = new Mat();//frame que será comparado com todos os demais frames
		Mat frameI = new Mat();//frame que estará sendo comparasocom o frame1 para gerar novo frame
		Mat frameNovo = new Mat();
		double[] rgb1 = new double[3]; //Conterá os valores RGB do pixel da imagem
		double[] rgbI = new double[3];
		double[] rgbNovo = new double[3];
		
		frame1 = Highgui.imread(pastaComFrames+"/foto" + 0 + ".jpg");
		frameNovo = Highgui.imread(pastaComFrames+"/foto" + 0 + ".jpg");
		
		int largura = (int) frame1.size().width;
		int altura = (int) frame1.size().height;
		
		for(int k = 1; k<qtdFrames; k++){
			frameI = Highgui.imread(pastaComFrames+"/foto" + k + ".jpg");
			System.out.println("Gerando frame "+k);
			for (int i = 0; i < altura; i++) {
				for (int j = 0; j < largura; j++) {

					rgb1 = frame1.get(i, j);
					rgbI = frameI.get(i, j);

					for (int l = 0; l < 3; l++) {
						rgbNovo[l] = Math.abs(rgb1[l] - rgbI[l]);
					}

					frameNovo.put(i, j, rgbNovo);
					// System.out.println(t3[0]+"    "+t3[1]+"   "+t3[2]);
				}
			}
			
			Highgui.imwrite("NovosFrames/foto"+k+".jpg", frameNovo);
		}
		
		
	}

}
