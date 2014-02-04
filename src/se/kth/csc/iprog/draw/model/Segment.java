package se.kth.csc.iprog.draw.model;

public class Segment extends Shape {

    @Override
    public double getSurface() {
        return 0;
    }

    // allow width and height to be negative as they have a different semantic
    @Override
    void setW(double w) {
        this.w = w;
    }

    @Override
    void setH(double h) {
        this.h = h;
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Segment";
	}

}
