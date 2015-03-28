package view;

import javax.swing.JOptionPane;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class GeraImagem {
	
	public GeraImagem(String caminhoImg1, String caminhoImg2) {

		System.loadLibrary("opencv_java2410");

		Mat frame1 = new Mat();
		frame1 = Highgui.imread(caminhoImg1);

		Mat frame2 = new Mat();
		frame2 = Highgui.imread(caminhoImg2);
		
		double[] t1 = new double[3];
		double[] t2 = new double[3];
		double[] t3 = new double[3];
		System.out.println(t1[0] + "    " + t1[1] + "   " + t1[2]);

		int largura = (int) frame1.size().width;
		int altura = (int) frame1.size().height;

		Mat frame3 = new Mat();
		frame3 = Highgui.imread(caminhoImg2);

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {

				t1 = frame1.get(i, j);
				t2 = frame2.get(i, j);

				for (int k = 0; k < 3; k++) {
					t3[k] = Math.abs(t1[k] - t2[k]);
				}

				frame3.put(i, j, t3);
				// System.out.println(t3[0]+"    "+t3[1]+"   "+t3[2]);
			}
		}

		Highgui.imwrite("foto3.jpg", frame3);
		JOptionPane.showMessageDialog(null, "Imagem gerada com sucesso!");
	}

//	public static void main(String[] args) {
//		new GeraImagem("fotos01\\foto1.jpg", "fotos02\\foto2.jpg");
//	}

}
