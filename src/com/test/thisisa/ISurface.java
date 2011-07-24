package com.test.thisisa;

import android.graphics.Canvas;

public interface ISurface {
	void onInitialize();
	void onDraw(Canvas canvas);
	void onUpdate(long gameTime);
	
	void touchCoordinates(float x, float y);
}
