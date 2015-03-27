package view;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

public class Cam {
	
	public static void main(String[] args) {
		System.out.println("Olá, OpenCV");
		
		System.loadLibrary("opencv_java2410");
		
		VideoCapture videoCapture = new VideoCapture(0);
		
		if(!videoCapture.isOpened()){
			System.out.println("Não conectou sua câmera");
		}
		else{
			System.out.println("WebCam funciona "+ videoCapture.toString());
			
		}
		Mat frame = new Mat();
		videoCapture.retrieve(frame);
		
		Highgui.imwrite("fotos01/foto1.jpg", frame);
		
		Mat frameBlur = new Mat();
		
		videoCapture.retrieve(frameBlur);
		Highgui.imwrite("fotos02/foto2.jpg", frameBlur);
		
		/*Imgproc.blur(frame, frameBlur, new Size(5,5));
		Highgui.imwrite("foto2.jpg", frameBlur);
		
		Imgproc.GaussianBlur(frame, frameBlur, new Size(25,25), 20);
		Highgui.imwrite("me3.jpg", frameBlur);*/
		videoCapture.release();
		
		
	}

}
