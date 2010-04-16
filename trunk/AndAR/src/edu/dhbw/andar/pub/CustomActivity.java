package edu.dhbw.andar.pub;

import android.os.Bundle;
import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.AndARActivity;
import edu.dhbw.andar.exceptions.AndARException;
import edu.dhbw.andar.interfaces.OpenGLRenderer;

/**
 * Example of an application that makes use of the AndAR toolkit.
 * @author Tobi
 *
 */
public class CustomActivity extends AndARActivity {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//CustomRenderer renderer = new CustomRenderer();//optional, may be set to null
		//super.setNonARRenderer(renderer);//or might be omited
		try {
			ARToolkit artoolkit = super.getArtoolkit();
			CustomObject someObject = new CustomObject
				("test", "patt.hiro", 80.0, new double[]{0,0});
			artoolkit.registerARObject(someObject);
			CustomObject someOtherObject = new CustomObject
			("test2", "android.patt", 80.0, new double[]{0,0}, new float[]{1.0f, 1.0f, 0f, 1.0f});
			artoolkit.registerARObject(someOtherObject);
			
		} catch (AndARException ex){
			//handle the exception, that means: show the user what happened
			System.out.println("");
		}		
	}

	/**
	 * Inform the user about exceptions that occurred in background threads.
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		System.out.println("");
	}
	
	
}
