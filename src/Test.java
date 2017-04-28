import java.util.HashSet;
import java.util.Set;

/**
 * Created by kavin on 3/28/17.
 */
public class Test {


	public static void main(String[] args) {
		System.out.println(ExpenseType.FUTURE_LOST_INCOME);
		String expenseName = "FUTURE_LOST_INCOME";
		System.out.println(expenseName.equals(ExpenseType.FUTURE_LOST_INCOME.toString()));
	}
}
