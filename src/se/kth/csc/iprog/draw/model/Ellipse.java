package se.kth.csc.iprog.draw.model;

public class Ellipse extends Shape {

	@Override
	public double getSurface() {
		return (h/2)*(w/2)*Math.PI;
	}

}
