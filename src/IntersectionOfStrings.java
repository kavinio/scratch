import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by kavin on 3/30/17.
 */
public class IntersectionOfStrings {


	public static void main(String[] args) {
		String str1 = "{\"data\":\"helloworld\",\"key\":\"value\"}";
		String str2 = "{\"data\":\"helorld\",\"key\":\"value\"}";

		Set<String> result = new HashSet<>(Arrays.asList(str1.split(",")));
		Set<String> needle = new HashSet<>(Arrays.asList(str2.split(",")));
		result.retainAll(needle);
		Iterator it = result.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
