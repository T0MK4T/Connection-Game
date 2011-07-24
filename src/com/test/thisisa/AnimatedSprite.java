package com.test.thisisa;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class AnimatedSprite extends GraphicObject {
	
	private Rect sRectangle;
	private int fps;
	private int numFrames;
	private int currentFrame;
	private long frameTimer;
	private int spriteHeight;
	private int spriteWidth;
	
	public AnimatedSprite(Bitmap bitmap, int height, int width, int fps, int frameCount) {
		super(bitmap);
		sRectangle = new Rect(0, 0, 0, 0);
		this.spriteHeight = height;
		this.spriteWidth = width;
		this.sRectangle.top = 0;
		this.sRectangle.bottom = spriteHeight;
		this.sRectangle.left = 0;
		this.sRectangle.right = spriteWidth;
		this.fps = 1000 / fps;
		this.numFrames = frameCount;
	}
	
	@Override
	public void setCoordinates(int x, int y) {
		coordinates.setCoordiantes(x - sRectangle.width() / 2, y - sRectangle.height() / 2);
	}
	
	public Rect getDrawCoordinates() {
		return new Rect(coordinates.getX(), coordinates.getY(), coordinates.getX() + spriteWidth, coordinates.getY() + spriteHeight);
	}
	
	public Rect getDrawableRect() {
		return sRectangle;
	}
	
	public void Update(long gameTime) {
		if(gameTime > frameTimer + fps) {
			frameTimer = gameTime;
			currentFrame += 1;
			
			if(currentFrame >= numFrames) {
				currentFrame = 0;
			}
			
			sRectangle.left = currentFrame * spriteWidth;
			sRectangle.right = sRectangle.left + spriteWidth;
		}
	}
}
