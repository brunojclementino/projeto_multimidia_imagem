package view.video;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import view.processamento_de_video.AnalisaNovosFrames;
import view.processamento_de_video.GerarNovosFrames;

public class ProcessarVideo {

	public ProcessarVideo(String caminhoVideo) throws Exception {

		System.loadLibrary("opencv_java2410");

		VideoCapture video = new VideoCapture(caminhoVideo);
		Mat quadro = new Mat();

		//Highgui.imwrite("frame.jpg", quadro);
		video.read(quadro);
		int i = 0;
		while (i < 42) {

			if (video.read(quadro)) {
				Highgui.imwrite("frames/foto" + i + ".jpg", quadro);
				i++;
			} else {
				break;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		/*new ProcessarVideo("SAMPLE.AVI");
		new GerarNovosFrames(42, "frames");*/
		new AnalisaNovosFrames(41, "NovosFrames");
	}
}
