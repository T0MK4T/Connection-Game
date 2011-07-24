package com.test.thisisa;

import android.graphics.Bitmap;

public class GraphicObject {
	
	protected Bitmap bitmap;
	protected Coordinates coordinates;
	protected boolean selected = false;
	
	public GraphicObject(Bitmap bitmap) {
		this.bitmap = bitmap;
		this.coordinates = new Coordinates();
	}

	public Bitmap getGraphic() {
		return bitmap;
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public void setCoordinates(int x, int y) {
		coordinates.setCoordiantes(x - bitmap.getWidth() / 2, y - bitmap.getHeight() / 2);
	}
	
	public boolean containsPoint(int x, int y) {
		if(x <= coordinates.getX() + bitmap.getWidth() && x >= coordinates.getX()
				&& y <= coordinates.getY() + bitmap.getHeight() && y >= coordinates.getY()) {
			return true;
		}
		return false;
	}
	
	public class Coordinates {
		private int x, y = 100;
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public void setY(int value) {
			y = value;
		}
		
		public void setX(int value) {
			x = value;
		}
		
		public void setCoordiantes(int x, int y) {
			setX(x);
			setY(y);
		}
		
		public String toString() {
			return "Coordinates: (" + x + "/" + y + ")";
		}
	}
}
