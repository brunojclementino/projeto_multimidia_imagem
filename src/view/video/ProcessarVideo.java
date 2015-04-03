package view.video;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.video.Video;

public class ProcessarVideo {
	
	
	
	public ProcessarVideo(String caminhoVideo) {
		
		System.loadLibrary("opencv_java2410");
		
		VideoCapture video = new VideoCapture();
		Mat quadro = new Mat(360,640, CvType.CV_8UC1);
		Mat frame = new Mat();
		
		video.open(caminhoVideo);
		System.out.println(video.isOpened());
	
		video.read(quadro);
		
		
		
		
		//Highgui.imwrite("frame.jpg", frame);
		
		/*while(true){
			
			if(video.read(quadro)){
			System.out.println(quadro.size());
			//Highgui.imwrite("frames/"+"foto1.jpg", quadro);
			}
			else{
				break;
			}
		}*/
		
		
	}
	
	
	public static void main(String[] args) {
		new ProcessarVideo("Video.avi");
		
	}
	
}
