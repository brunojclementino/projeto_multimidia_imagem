package view.video;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

public class AbriVideo {

	public AbriVideo() {
		System.loadLibrary("opencv_java2410");
		VideoCapture videoCap = new VideoCapture(0);
		if (!videoCap.isOpened()) {
			System.out.println("Não conectou sua câmera");
		} else {
			System.out.println("WebCam funciona " + videoCap.toString());

		}
		Mat frame;
		
		for (int i = 0; i < 30; i++) {			
			try {
				frame = new Mat();
				videoCap.retrieve(frame);
				Highgui.imwrite("video/" + "foto" + i + ".jpg", frame);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ok");
			
		}
		
	}

	public static void main(String[] args) {
		new AbriVideo();
	}

}
