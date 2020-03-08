package epam.oop.maven;

public class Candy extends Sweet{
	
	String name;
	int cost;
	float weight;
	int sweetness;
	
	public Candy(String name,int cost,float weight,int sweetness) {
		super(name,cost,weight,sweetness);
	}
	
}