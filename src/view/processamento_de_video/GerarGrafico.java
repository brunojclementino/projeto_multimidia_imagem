package view.processamento_de_video;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;

public class GerarGrafico {

	Size resolucao;
	public GerarGrafico(int[][] dados, Size resolucao, int qtdImagens) {
		this.resolucao = resolucao;
		System.loadLibrary("opencv_java2410");
		int aux = qtdImagens*15;
		Mat graficoR = new Mat(aux, aux, CvType.CV_8UC3);
		Mat graficoG = new Mat(aux, aux, CvType.CV_8UC3);
		Mat graficoB = new Mat(aux, aux, CvType.CV_8UC3);
		Mat graficoRGB = new Mat(aux, aux, CvType.CV_8UC3);
		
		double[]cor = new double[3];
		cor[0]=255;cor[1]=255;cor[2]=255;
		
		//A imagem ficará totalmente branca
		for(int i=0;i<graficoR.size().height;i++){
			for(int j=0;j<graficoR.size().width;j++){
				graficoR.put(i, j, cor);
				graficoG.put(i, j, cor);
				graficoB.put(i, j, cor);
				graficoRGB.put(i, j, cor);
			}
		}
		
		//Gera a imagem dos gráficos
		int distColum = 15;//Distancia entre as colunas do grafico
		double[]corR = {0, 0, 255};
		double[]corG = {0, 255, 0};
		double[]corB = {255, 0, 0};
		for(int i=0; i<dados.length;i++){
			
			for(int j=0;j<4;j++){//Para que as colunas dos gráficos tenham 7 pixels de largura
				
				for(int k=0; k<probabilidade(dados[i][0])*10;k++){
					graficoRGB.put(i*distColum+j, k, corR);
					graficoR.put(i*distColum+j, k, corR);
				}
				
				for(int k=0; k<probabilidade(dados[i][1])*10;k++){
					graficoRGB.put(i*distColum+4+j, k, corG);
					graficoG.put(i*distColum+4+j, k, corG);
				}
				
				for(int k=0; k<probabilidade(dados[i][2])*10;k++){
					graficoRGB.put(i*distColum+8+j, k, corB);
					graficoB.put(i*distColum+8+j, k, corB);
				}
			}
			
			
			
		}
		
		Highgui.imwrite("graficos/graficoR.jpg", graficoR);
		Highgui.imwrite("graficos/graficoG.jpg", graficoG);
		Highgui.imwrite("graficos/graficoB.jpg", graficoB);
		Highgui.imwrite("graficos/graficoRGB.jpg", graficoRGB);
		
		
	}

	private int probabilidade(int i) {
		int altura = (int) resolucao.height;
		int largura = (int) resolucao.width;
		
		int qtdPixel = altura*largura;
		
		
		
		return (i*100)/qtdPixel;
	}
}
