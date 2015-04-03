package view.imagem;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

public class Cam {
	
	public void tiraFoto() {
		System.out.println("Olá, OpenCV");
		
		System.loadLibrary("opencv_java2410");
		
		VideoCapture videoCapture = new VideoCapture(1);
		
		if(!videoCapture.isOpened()){
			System.out.println("Não conectou sua câmera");
		}
		else{
			System.out.println("WebCam funciona "+ videoCapture.toString());
			
		}
		Mat frame = new Mat();
		int cont=0;
		while(true){
			if(cont>20)
				break;
			videoCapture.retrieve(frame);
			cont++;
		}
		
		Highgui.imwrite("tratamentoDeImagens/"+"foto1.jpg", frame);
		
		Mat frameBlur = new Mat();
		
		videoCapture.retrieve(frameBlur);
		Highgui.imwrite("tratamentoDeImagens/"+"foto2.jpg", frameBlur);
		
		videoCapture.release();
	}
	
	public static void main(String[] args) {
		new Cam().tiraFoto();
		new GeraImagem().gerar("tratamentoDeImagens/foto1.jpg", "tratamentoDeImagens/foto2.jpg");
	}

}
