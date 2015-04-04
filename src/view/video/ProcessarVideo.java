package view.video;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.video.Video;


public class ProcessarVideo {
	
	
	
	public ProcessarVideo(String caminhoVideo) throws Exception {
		
		System.loadLibrary("opencv_java2410");
		
		VideoCapture video = new VideoCapture(caminhoVideo);
		Mat quadro = new Mat();
		
		
		Highgui.imwrite("frame.jpg", quadro);
		int i = 0;
		while(i<60){
			
			if(video.read(quadro)){
			Highgui.imwrite("frames/foto"+i+".jpg", quadro);
			i++;
			}
			else{
				break;
			}
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		new ProcessarVideo("bird.avi");
		
	}
	
}
