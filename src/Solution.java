import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Comparator<Pizza> comparator = new PizzaComparator();
		PriorityQueue<Pizza> queue = new PriorityQueue<Pizza>(N, comparator);
		while(N-->0){
			Integer start = in.nextInt();
			Integer cookTime = in.nextInt();
			Pizza pizza = new Pizza(start, cookTime);
			queue.add(pizza);
		}
		Integer timeElapsed = 0;
		Integer ict = queue.peek().cookTime;
		while(queue.size() != 0){
			Pizza pizza = queue.remove();
			timeElapsed = timeElapsed + pizza.cookTime - pizza.start;
			System.out.println(pizza.start);
			System.out.println(pizza.cookTime);
			System.out.println(timeElapsed);

		}
	}
}

class Pizza{
	Integer start;
	Integer cookTime;

	public Pizza(Integer start, Integer cookTime){
		this.start = start;
		this.cookTime = cookTime;
	}
}

class PizzaComparator implements Comparator<Pizza>{
	@Override
	public int compare(Pizza x, Pizza y){
		if(x.cookTime<y.cookTime){
			return -1;
		}else if(x.cookTime>y.cookTime){
			return 1;
		}
		return 0;
	}
}
