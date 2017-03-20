/**
 * Created by kavin on 3/17/17.
 */
public class QuickSort {


	public static void main(String[] args) {
		//int[] in = new int[]{5,2,9,3,1,7,2};
		int[] in = new int[]{5,7,1,2};
		for (int i=0;i<in.length;i++){
			System.out.print(in[i]+" ");
		}
		System.out.println();
		quickSort(in, 0, in.length-1);
		System.out.println();
		for (int i=0;i<in.length;i++){
			System.out.print(in[i]+" ");
		}


	}

	private static void quickSort(int[] in, int start, int end) {
		if(start>=end) return;
		System.out.println("##"+start+"##"+end+"##");
		int pIndex = partition(in, start, end);//2i 1i
		for (int i=0;i<in.length;i++){
			System.out.print(in[i]+" ");
		}
		quickSort(in, start, pIndex-1);//0,1
		quickSort(in, pIndex+1, end);//3,6
	}

	private static int partition(int[] in, int start, int end) {
		int pivot = in[end];//2 1   9
		int i = start;//0
		for(int j=start;j<end-1;j++){//j=1
			if(in[j]<=pivot){
				int temp = in[j];
				in[j]=in[i];//5
				in[i]=temp;//2
				i++;
			}//2193572  129..
		}
		if(in[i]>pivot) {
			in[end] = in[i];//9
			in[i] = pivot;//2
		}
		return i;
	}


}
