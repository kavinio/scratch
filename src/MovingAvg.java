import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kavin on 3/6/17.
 */
public class MovingAvg {


	public static void main(String[] args) {
		Integer[] data = {2,4,56,7,1,7};
		int k =3;
		int sum =0;
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<k; i++){
			q.add(data[i]);
			sum+=data[i];
		}
		System.out.println(sum/k);
		for(int i=k; i<data.length; i++) {
			sum = sum - q.poll() + data[i];
			q.add(data[i]);
			System.out.println(sum/k);
		}
	}
}
