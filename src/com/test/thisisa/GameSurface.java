package com.test.thisisa;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;

class GameSurface extends DrawablePanel {
	
	private ArrayList<AnimatedSprite> sprites;
	private ArrayList<GraphicObject> graphics;
	
	public GameSurface(Context context) {
		super(context);
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);  // in case
		canvas.drawColor(Color.BLACK);
		Bitmap bitmap;
		GraphicObject.Coordinates coords;
		for(GraphicObject graphic : graphics) {
			bitmap = graphic.getGraphic();
			coords = graphic.getCoordinates();
			canvas.drawBitmap(bitmap, coords.getX(), coords.getY(), null);
		}
		Rect sRectangle, dest;
		for(AnimatedSprite sprite : sprites) {
			bitmap = sprite.getGraphic();
			dest = sprite.getDrawCoordinates();
			sRectangle = sprite.getDrawableRect();
			canvas.drawBitmap(bitmap, sRectangle, dest, null);
		}
	}
	
	@Override
	public void onInitialize() {
		sprites = new ArrayList<AnimatedSprite>();
		graphics = new ArrayList<GraphicObject>();
		
		/**
		 * Get them in the middle of the screen, a square based on the width of the screen.
		 */
		int rowCols = 7;
		int spacing = getWidth() / rowCols;
		int startingHeight = (getHeight() - getWidth()) / 2;
		int currentX = spacing / 2;
		int currentY;
		GraphicObject sprite;
		for(int i = 0; i < rowCols; i++) {
			currentY = startingHeight + (spacing / 2);
			for(int j = 0; j < rowCols; j++) {
				sprite = new GraphicObject(BitmapFactory.decodeResource(getResources(), R.drawable.whitedot));
				sprite.setCoordinates(currentX, currentY);
				graphics.add(sprite);
				currentY += spacing;
			}
			currentX += spacing;
		}
	}
	
	@Override
	public void onUpdate(long gameTime) {
		if(sprites != null) {
			for(AnimatedSprite sprite : sprites) {
				sprite.Update(gameTime);
			}
		}
	}
	
	@Override
	public void touchCoordinates(float x, float y) {
		for(GraphicObject object : graphics) {
			if(object.containsPoint((int)x, (int)y)) {
				System.out.println("WE HAVE CONTACT");
			}
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		touchCoordinates(event.getX(), event.getY());
		return false;
	}
}
