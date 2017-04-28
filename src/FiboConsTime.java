/**
 * Created by kavin on 3/21/17.
 */
public class FiboConsTime {

	public static void main(String[] args) {
		System.out.println(fibo(12));
	}

	private static double fibo(int n) {
		double inverseSqrt5 = 1 / Math.sqrt(5);
		double phi = (1 + Math.sqrt(5)) / 2;
		return (int)Math.floor(Math.pow(phi, n) * inverseSqrt5 + 0.5);

	}
}
