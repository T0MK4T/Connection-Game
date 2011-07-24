package com.test.thisisa;

import android.app.Activity;
import android.os.Bundle;

public class AndroidTutorial extends Activity {

	GameSurface surface;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GameSurface surface = new GameSurface(this);
		
		setContentView(surface);
	}
}
