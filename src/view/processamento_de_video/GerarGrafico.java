package view.processamento_de_video;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

public class GerarGrafico {

	public GerarGrafico(int[][] dados) {
		
		System.loadLibrary("opencv_java2410");
		Mat graficoR = new Mat();
		
		graficoR=Highgui.imread("NovosFrames/foto1.jpg");
		int[]cor = new int[3];
		cor[0]=0;cor[1]=0;cor[2]=0;
		System.out.println(graficoR.size());
		graficoR.put(5,5, cor);
		
		for(int i=0;i<graficoR.size().height;i++){
			for(int j=0;j<graficoR.size().width;j++){
				System.out.println("ok");
				graficoR.put(i, j, cor);
			}
		}
		
		Highgui.imwrite("graficos/graficoR.jpg", graficoR);
		
		for(int i=0; i<dados[0].length;i++){
			
			
		}
	}
}
