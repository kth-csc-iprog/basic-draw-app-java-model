package se.kth.csc.iprog.draw.model;

public class Rectangle extends Shape {

	@Override
	public double getSurface() {
		return h*w;
	}
}
