package se.kth.csc.iprog.draw.model;

public abstract class Shape {
	
	double x,y,w,h;
	
	public abstract double getSurface();

	public double getX() {
		return x;
	}

	void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	void setY(double y) {
		this.y = y;
	}

	public double getW() {
		return w;
	}

	void setW(double w) throws IllegalArgumentException {
		if(w<0)
			throw new IllegalArgumentException("Width must be positive");
		this.w = w;
	}

	public double getH() {
		return h;
	}

	void setH(double h) throws IllegalArgumentException {
		if(h<0)
			throw new IllegalArgumentException("Height must be postitive");
		this.h = h;
	}
	

}
