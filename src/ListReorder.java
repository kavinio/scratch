import java.util.ArrayList;
import java.util.List;

public class ListReorder {


    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("b1 zebra alps mount");
        input.add("w3 95 34 22");
        input.add("v2 alps car bat");

        System.out.println(input);

        for(int i=0;i<input.size()-1;i++){

            for(int j=i+1;j<input.size();j++){
                String x[] = input.get(i).split(" ");
                String y[] = input.get(j).split(" ");
                //System.out.println(x[1]+ " " +y[1]);
                if(x[1].compareTo(y[1])>0
                    ||(x[1].matches("\\d+") && !y[1].matches("\\d+"))
                    ){
                    String temp = input.get(i);
                    input.set(i, input.get(j));
                    input.set(j, temp);
                }
            }
        }

        System.out.println(input);





    }
}
