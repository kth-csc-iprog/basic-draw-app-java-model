package se.kth.csc.iprog.draw.model;

public class Rectangle extends Shape {

	@Override
	public double getSurface() {
		return h*w;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}

}
