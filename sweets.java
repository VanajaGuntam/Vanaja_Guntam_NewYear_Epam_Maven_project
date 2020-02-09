package sweets;
import java.util.*;

public class Sweet_Anaklysis {
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
	static HashMap<String,Integer> nameToWeight=new HashMap<String,Integer>();
	static HashMap<String,Integer> nameToPrice=new HashMap<String,Integer>();
	static int sweetWeight,sweetPrice;
	public static void main(String[] args)
	{
		inputSweets();
		System.out.println("Total weight of the gift is:"+calcTotalWeight());
		System.out.println("Choose the way to sort(enter the number): 1. By Price 2. By Weight");
		int sortType=sc.nextInt();
		if(sortType==1)
		{
			Comparator<Sweet> compareByPrice=(Sweet c1,Sweet c2)->((Integer)c1.getPrice()).compareTo(c2.getPrice());
			Collections.sort(sweets,compareByPrice);
		}
		else
		{
			Comparator<Sweet> compareByWeight=(Sweet c1,CSweet c2)->((Integer)c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(sweets,compareByWeight);
		}
		
		calcRange(sortType);
	}
	
	public static void inputSweets()
	{
		
		System.out.println("Enter the number of sweets in Sweets:\n");
		int numberOfSweets=sc.nextInt();
		for(int sweetCount=1; sweetCount<=numberOfSweets;sweetCount++)
		{
			//System.out.println("Enter the sweet type(Enter the number): 1. Kaju Katli 2. Gulabjam");
			System.out.println("Enter the weight of the sweet");
			int sweetWeight=sc.nextInt();
			System.out.println("Enter the price of the sweet");
			int sweetPrice=sc.nextInt();
			Sweet sweet=new Sweet(sweetWeight,sweetPrice);
			sweets.add(sweets);
		}
	}
	public static int calcTotalWeight()
	{
		int totalWeight=0;
		for(Sweet sweet: sweets)
		{
			totalWeight+=sweet.getWeight();
		}
		for(Sweet sweet:sweets)
		{
			totalWeight+=sweet.getWeight();
		}
		return totalWeight;
	}
	public static void inputSweets()
	{
			int sweetType=sc.nextInt();
			System.out.println("Enter the weight of the sweet");
			int sweetWeight=sc.nextInt();
			System.out.println("Enter the price of the sweet");
			int sweetPrice=sc.nextInt();
			if(sweetType==1)
			{
				System.out.println("Enter the name of the sweet");
				String sweetName=sc.next();
				if(nameToWeight.containsKey(sweetName))
				{
					nameToWeight.put(sweetName,(int)nameToWeight.get(sweetName)+sweetWeight);
				}
				else 
					nameToWeight.put(sweetName,sweetWeight);
				if(nameToPrice.containsKey(sweetName))
				{
					nameToPrice.put(sweetName,(int)nameToPrice.get(sweetName)+sweetPrice);
				}
				else
					nameToPrice.put(sweetName,sweetPrice);
			}
			Sweet sweet =new Sweet(sweetWeight,sweetPrice);
			Sweet.add(sweet);
			if(SweetType==1)
			{
		     Sweet.add(sweet);
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
		   
		   Set<Map.Entry<String,Integer>> sweetSet=nameToPrice.entrySet();
		   Iterator<Map.Entry<String,Integer>> sweetIterator=sweetSet.iterator();
		   while(sweetIterator.hasNext())
		   {
			   Map.Entry sweetElement=(Map.Entry)sweetIterator.next();
			   int currentPrice=(int)sweetyElement.getValue();
			   if(currentPrice>= lowerLimit && currentPrice<=higherLimit)
				   System.out.println(sweetElement.getKey());
		   }
	   }
	   else
	   {
		   System.out.println("Enter the lowerlimit of the weight:");
		   lowerLimit=sc.nextInt();
		   System.out.println("Enter the higherlimit of the weight:");
		   higherLimit=sc.nextInt();
		   Set<Map.Entry<String,Integer>> sweetSet=nameToWeight.entrySet();
		   Iterator<Map.Entry<String,Integer>> sweetIterator=sweetSet.iterator();
		 
	   }
	}
}
