
 
package view.imagem;

import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JOptionPane;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
/**
 * Essa classe faz a subtração dos valores do RGB das imagens e cria outra imagem com o valor da subrtração dos mesmos.
 * 
 * @see TelaInicial
 * @see ImagemTela
 * 
 * @author Bruno Clementino, Fábio Dias e Lucas Miranda
 *
 */
public class GeraImagem {

	public void gerar(String caminhoImg1, String caminhoImg2) throws HeadlessException {
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
		
		Highgui.imwrite("tratamentoDeImagens/foto3.jpg", frame3);
		
		/*File file = new File("foto3.jpg");
		if (file.length() != 0) {
			JOptionPane.showMessageDialog(null, "Imagem gerada com sucesso!");	
		} else {
			System.out.println(frame1.size());
			JOptionPane.showMessageDialog(null, "Houve algum erro, tente mais tarde.");
		}*/
	}
}
