package chocolate;//Java Encapsulation property
import java.util.*;
interface candies //Interface property
/*Abstraction Java Property*/
{
   int inputcandies()
    {
        System.out.println("Candies Belongs to chocolate family");
    }
}
class Chocolate implements candies 
{
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Chocolate> chocolates=new ArrayList<Chocolate>();
	static ArrayList<Chocolate> candies=new ArrayList<Chocolate>();
	static HashMap<String,Integer> nameToWeight=new HashMap<String,Integer>();
	static HashMap<String,Integer> nameToPrice=new HashMap<String,Integer>();
}
public class Chocolates extends Chocolate
{
	public static void main(String[] args)
	{
		inputChocolates();
		System.out.println("The  weight of the gift is:"+calcTotalWeight());
		System.out.println("Sort the Chocolates base on this factors(enter the number): 1. By Price 2. By Weight");
		int sortType=sc.nextInt();
		if(sortType==1)
		{
			Comparator<Chocolate> compareByPrice=(Chocolate c1,Chocolate c2)->((Integer)c1.getPrice()).compareTo(c2.getPrice());
			Collections.sort(chocolates,compareByPrice);
		}
		else
		{
			Comparator<Chocolate> compareByWeight=(Chocolate c1,Chocolate c2)->((Integer)c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(chocolates,compareByWeight);
		}
		System.out.println("The sort result:");
		for(Chocolate chocolate: chocolates)
		{
			System.out.println(chocolate.getPrice());
		}
		calcRange(sortType);
	}
	
	public static int calcTotalWeight()
	{
		int totalWeight=0;
		for(Chocolate choco: chocolates)
		{
			totalWeight+=choco.getWeight();
		}
		return totalWeight;
	}
	public static void inputChocolates()
	{
		System.out.println("Enter the nummber of chocolates in gifts:\n");
		int numberOfChocolates=sc.nextInt();
		for(int chocoCount=1; chocoCount<=numberOfChocolates;chocoCount++)
		{
			System.out.println("Enter the chocolate type(Enter the number): 1. Candy 2.Wafer");
			int chocolateType=sc.nextInt();
			System.out.println("Enter the weight of the choclate");
			int chocoWeight=sc.nextInt();
			System.out.println("Enter the price of the chocolate");
			int chocoPrice=sc.nextInt();
			if(chocolateType==1)
			{
				System.out.println("Enter the name of the candy");
				String candyName=sc.next();
				if(nameToWeight.containsKey(candyName))
				{
					nameToWeight.put(candyName,(int)nameToWeight.get(candyName)+chocoWeight);
				}
				else 
					nameToWeight.put(candyName,chocoWeight);
				if(nameToPrice.containsKey(candyName))
				{
					nameToPrice.put(candyName,(int)nameToPrice.get(candyName)+chocoPrice);
				}
				else
					nameToPrice.put(candyName,chocoPrice);
			}
			Chocolate choco =new Chocolate(chocoWeight,chocoPrice);
			chocolates.add(choco);
			if(chocolateType==1)
			{
				candies.add(choco);
			}
		}
	}
	public static void calcRange(int sortType)
	{
		Scanner sc=new Scanner(System.in);
	   System.out.println("Let's find the range:");
	   int lowerLimit,higherLimit;
	   if(sortType==1)
	   {
		   System.out.println("Enter the lowerlimit of the price:");
		   lowerLimit=sc.nextInt();
		   
		   System.out.println("Enter the higherlimit of the price");
		   higherLimit=sc.nextInt();
		   
		   Set<Map.Entry<String,Integer>> candySet=nameToPrice.entrySet();
		   Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
		   while(candyIterator.hasNext())
		   {
			   Map.Entry candyElement=(Map.Entry)candyIterator.next();
			   int currentPrice=(int)candyElement.getValue();
			   if(currentPrice>= lowerLimit && currentPrice<=higherLimit)
				   System.out.println(candyElement.getKey());
		   }
	   }
	   else
	   {
		   System.out.println("Enter the lowerlimit of the weight:");
		   lowerLimit=sc.nextInt();
		   System.out.println("Enter the higherlimit of the weight:");
		   higherLimit=sc.nextInt();
		   Set<Map.Entry<String,Integer>> candySet=nameToWeight.entrySet();
		   Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
		   while(candyIterator.hasNext())
		   {
			   Map.Entry candyElement=(Map.Entry)candyIterator.next();
			   int currentWeight=(int)candyElement.getValue();
			   if(currentWeight>= lowerLimit && currentWeight<=higherLimit)
				   System.out.println(candyElement.getKey());
		   }
		   
	   }
	}
}