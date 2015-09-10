package cis232.lab;

public class Student {
	String name;
	double points;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public Student(String name, String points){
		this.name = name;
		this.points = Double.parseDouble(points);
	}
	
	public void addPoint(){
		points++;
	}
}
