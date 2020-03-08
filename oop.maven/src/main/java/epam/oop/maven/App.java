package epam.oop.maven;
import java.util.*;

public class App 
{
	public static void addItems(List<Sweet> sweet_list) {
		sweet_list.add(new Chocolate("DairyMilk",180,200.0f,62));
        sweet_list.add(new Chocolate("KitKat",20,50.5f,50));
        sweet_list.add(new Chocolate("MilkyBar",10,20.4f,40));
        sweet_list.add(new Chocolate("FerreroRocher",200,180.7f,75));
        sweet_list.add(new Jelly("JustJelly",30,20.6f,25));
        sweet_list.add(new Jelly("JollyRancher",20,15.6f,20));
        sweet_list.add(new Jelly("JellyBelly",50,20.6f,65));
        sweet_list.add(new Candy("Hershey's_Kisses",60,8.1f,90));
        sweet_list.add(new Candy("LaffyTaffy",90,30.1f,75));
        sweet_list.add(new Candy("Nerds",10,2.6f,10));
        sweet_list.add(new Candy("MilkyWay",30,15.6f,25));
        sweet_list.add(new Candy("DoubleBubbleGum",5,3.0f,15));
	}
	
	public static void display_SweetDetails(Sweet curr) {
		System.out.printf("%-15s %3d %8.4f %6d\n\n",curr.name,curr.cost,curr.weight,curr.sweetness);
	}
	
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
        List<Sweet> s_list=new ArrayList<Sweet>();
        addItems(s_list);
		List<Sweet> ch=new ArrayList<Sweet>();
		int n=s_list.size();
		float tot_weight=0.0f;
		for(int i=0;i<n;i++)
			tot_weight+=s_list.get(i).weight;
		System.out.println("Total Weight of Gift is : "+tot_weight);
		for(int i=0;i<n;i++) {
			if(s_list.get(i) instanceof Chocolate) ch.add(s_list.get(i));
		}
		System.out.print("Enter the Option :\n1.SortByCost\n2.SortByWeight\n3.SortBySweetness\n4.Don'tsort\n");
		int option=sc.nextInt();
		if(option==1) 
			Collections.sort(ch,new sortByCost());
		else if(option==2) 
			Collections.sort(ch,new sortByWeight());
		else if(option==3) 
			Collections.sort(ch,new sortBySweetness());
		//System.out.println("Chocolates Present in the Gift are:");
		System.out.printf("Chocolates Present in Gift are:\n\n%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
		for(int i=0;i<ch.size();i++){
			System.out.printf("%-15s %3d %8.4f %6d\n\n",ch.get(i).name,ch.get(i).cost,ch.get(i).weight,ch.get(i).sweetness);
		}
		System.out.println("Do you Want List of Candies(Yes/No)?");
		char c=sc.next().charAt(0);
		if(c=='y'||c=='Y'){
			System.out.print("Enter the Option :\n1.Cost\n2.Weight\n3.Sweetness\n");
			option=sc.nextInt();
			System.out.println("Enter the Range:");
			int min=sc.nextInt();
			int max=sc.nextInt();
			System.out.printf("%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
			Sweet curr;
			int f= 0;
			if(option==1) {
				for(int i=0;i<n;i++) {
					curr=s_list.get(i);
					if(curr instanceof Candy && curr.cost>=min && curr.cost<=max){
						f=1;
						display_SweetDetails(curr);
					}
				}
				if(f==0) 
					System.out.println("\nCandies with cost of given range is not available.");
			}
			else if(option==2) {
				for(int i=0;i<n;i++) {
					curr=s_list.get(i);
					if(curr instanceof Candy && curr.weight>=min && curr.weight<=max){
						f=1;
						display_SweetDetails(curr);
					}
				}
				if(f==0)
					System.out.println("\nCandies with weight of given range is not available.");
			}
			else {
				for(int i=0;i<n;i++) {
					curr=s_list.get(i);
					if(curr instanceof Candy && curr.sweetness>=min && curr.sweetness<=max){
						f=1;
						display_SweetDetails(curr);
					}
				}
				if(f==0) 
					System.out.println("\nCandies with sweetness of given range is not available.");
			}
		}
		sc.close();
    }
}