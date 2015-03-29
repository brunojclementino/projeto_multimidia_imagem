package view.video;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

public class AbriVideo {

	public AbriVideo() {
		// Define a biblioteca
		System.loadLibrary("opencv_java2410");
		// Define que será usado a webcam ZERO
		VideoCapture videoCap = new VideoCapture(0);

		// Verifica se a webcam está conectada ...
		if (!videoCap.isOpened()) {
			JOptionPane.showMessageDialog(null, "Não conectou sua câmera");
		} else {

			Mat frame;
			// Com um laço de 30, será criada 30 quadros.
			for (int i = 0; i < 10; i++) {
				try {
					frame = new Mat();
					videoCap.retrieve(frame);
					// Nomeia os 30 quadros de fotoX.jpg
					Highgui.imwrite("video/" + "foto" + i + ".jpg", frame);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ok");
			}
		}
		
		concatenar();
	}
	
	

	public void concatenar() {
		Mat frame = new Mat();
		VideoCapture videoCap = new VideoCapture();
		
		videoCap.open("video/foto0.jpg,video/foto1.jpg,video/foto2.jpg,video/foto3.jpg,video/foto4.jpg,video/foto5.jpg");
		System.out.println(videoCap.set(5, 32));
	}

	public static void main(String[] args) {
		new AbriVideo();
	}
}
