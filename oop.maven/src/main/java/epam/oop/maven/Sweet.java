package epam.oop.maven;
import java.util.*;
class sortByCost implements Comparator<Sweet>{
	public int compare(Sweet sw1,Sweet sw2) {
		return sw1.cost-sw2.cost;
	}
}

class sortByWeight implements Comparator<Sweet>{
	public int compare(Sweet sw1,Sweet sw2) {
		return Float.compare(sw1.weight,sw2.weight);
	}
}

class sortBySweetness implements Comparator<Sweet>{
	public int compare(Sweet sw1,Sweet sw2) {
		return sw1.sweetness-sw2.sweetness;
	}
}

public  class Sweet {
	
	String name;
	int cost;
	float weight;
	int sweetness;
	
	public Sweet(String name,int cost,float weight,int sweetness) {
		this.name=name;
		this.cost=cost;
		this.weight=weight;
		this.sweetness=sweetness;
	}
	
}