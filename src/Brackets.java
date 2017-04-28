import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by kavin on 3/2/17.
 */
public class Brackets {

	public static void main(String[] args){
		System.out.println("####");

		// 8,10
		// 7,13
		//if(Math.max(8,10)<Math.min(10,14)) System.out.println("true");



		//String exp = "{{)(})])}[[]}}[)(]]](}})[){}[[(](){}{()[((({({{(][([}[][)()){[[){{]{}))][}()]{(({}](}](}{}}]}}{{])}((]{)(}}})[{]}({)}}{{[]{(){{{{(]}]({([]{][{{{}}])})([)[[{([{(){[})}}}}[}})}){]}([}[([){}}[)])}(]({{(]}(}{{[}[{))(}]{{[)](}[[{{]({[(])]{[)))(}{(}{])[][(}(}}]}{}{(][}}({}[{)]{)]]]{{))[{(}([({}{]()[()[{]])[[]]{[[)][]}][{{)]])(}){)}{}]]][][}]((]}))}(})]]([])](}]{})][(}))[](]]]{)]]((]}[)}[())])}[{[([))(][)[])({[{{[{[{{}{)[[{{[{](((}(}{)]}[(){(])]}})][][}){})][]()]}}])]}[))(}[{)[}[][}))}({[[}){})({}({([)))])}[][})[]}]]}[[((}([()(}]][(][][{)[{{{[)}(](){}{)][(({[})([}(}(){){[])([}}}{]}[}[(]{])]]{{)]){)[}]}([{)[[)})[]()({({]}}{(]([))[})}[])[()[()){{()]))}[[)[}](()}]){}[}(()(])}){((([))[(}}((}(][{}})][)[[)}}{][)))}]()))][{}))[{){][{)]{(}]{{[[][}(]]]]{]}[))}]}})(}[(}{]{)})})[}[}[]([{(})([]]{[}()]{()(()){([]])]()({}";
		try {
			List<String> lines= Files.readAllLines(Paths.get("/Users/kavin/Downloads/brackets.txt"), Charset.forName("UTF-8"));
			for(String line:lines){

				Stack<Character> stack = new Stack<Character>();
				char c;
				int asciiDiff = 0;
				boolean done = false;
				for(int i=0;i<line.length();i++){
					c = line.charAt(i);
					if(c=='{'||c=='['||c=='('){
						stack.push(c);
					} else {
						if(!stack.isEmpty() && ((int)c-(int)stack.peek() == 1 || (int)c-(int)stack.peek() == 2)){
							stack.pop();
						} else {
							stack.push(c);
							break;
						}
					}
				}
				System.out.println(stack.isEmpty() ? "YES" : "NO");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
}
