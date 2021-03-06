import java.util.*;
import java.util.Arrays;
public class Quick{

	public static void quicksort(int[] data){
		//quicksortHelper(data, 0 , data.length - 1);
		quicksortDutchHelper(data,0,data.length-1);
	}

	private static void quicksortDutchHelper(int[] data, int start, int end){
		if (start >= end){
			return;
		}
		//else{
		//	System.out.println("1: " + data.length);
			int[] data2 = partitionDutch(data,start,end);
			//System.out.println("1: " + data2.length);
			if (data2[0] - start <= 50){
				insertionsort(data,start,data2[0]);
			}
			else{
			quicksortDutchHelper(data,start,data2[0]);
		}
			if (end - data2[1] <= 50){
				insertionsort(data,data2[1],end);
			}
			else{
			quicksortDutchHelper(data,data2[1],end);
		}
	//	}
	}

	public static void insertionsort(int[] data, int lo, int hi){
		for (int i = lo; i <= hi;i++){
			int orig = data[i];
			int c = i;
			while (c > lo && data[c-1] > orig){//left number is bigger
				data[c] = data[c-1];
				//data[c] = orig;
				c--;
			}
			data[c] = orig;
		}
	}
	private static void quicksortHelper(int[] data, int lo, int hi){
		if (lo >= hi){
			return;
		}
		//debug(data);
		int pivot = partition(data,lo,hi);
		//debug(data);

		quicksortHelper(data,lo,pivot-1);
		//debug(data);
		quicksortHelper(data,pivot+1,hi);
		//debug(data);
	}

	private static int[] partitionDutch(int[] data,int start, int end){
			if (end == start){
				int[] thing = new int[2];
				thing[0] = start;
				thing[1] = end;
				return thing;
			}
			//finding the median
			int median;// = (end+start)/2;//rand.nextInt(end - start)+start;
			//System.out.println((end+start)/2);
			//System.out.println("" + end + " " + start + " ");
			int middle = data[(end+start)/2];
			//System.out.println("" + middle);
			int first = data[start];
			int last = data[end];
			if ((first < middle && first > last) || (first > middle && first < last)){
	 		 median = start;
	 	 	}
	 	 	else{
	 				if ((last < middle && last > first) || (last > middle && last < first)){
	 					median = end;
	 				}
	 				else{
	 					median = (end+start)/2;
	 				}
	 		}
			//swapping median and start
			int pivotIndex = median;
			int temp = data[pivotIndex];
			data[pivotIndex] = data[start];
			data[start] = temp;
			pivotIndex = start;
			int pivot = data[pivotIndex];


			int currentIndex = start;
			while (currentIndex <= end){
				if (data[currentIndex] > pivot){
					temp = data[currentIndex];
					data[currentIndex] = data[end];
					data[end] = temp;
					end -= 1;
				}
				else{
					if (data[currentIndex] < pivot){
						temp = data[currentIndex];
						data[currentIndex] = data[start];
						data[start] = temp;
						start++;
						currentIndex++;
					}
					else{
						currentIndex++;
					}
				}
			}

			//int length = (end + 1) - (start - 1);
			int[] ans = new int[2];
			ans[0] = start-1;
			ans[1] = end+1;
			//System.out.println(ans[1]);
			//for (int i = 0; i < length; i++){
			//	ans[i] = data[start - 1];
			//	start++;
			//}
			return ans;
    }
	/*return the value that is the kth smallest value of the array.
 */
 	public static int quickselect(int []data, int k){
    //k--;
		int first = partition(data,0,data.length - 1);
		while (k != first){
			boolean go = true;
			if (k < first){
			 go = false;
				first = partition(data,0,first-1);
			}
			if (go && k > first){
				first = partition(data,first+1,data.length-1);
			}
		}
		return data[first];
	}








  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */

	private static void debug(int[] data){
		System.out.println(" ");
		for (int r = 0; r < data.length; r++){
			System.out.print(data[r]+", ");
		}
	}
 public static int partition (int[] data, int start, int end){
	 //int newPivotIndex = 0;
	 //end++;
   //Random rand;// = new Random();
   int median;// = (end+start)/2;//rand.nextInt(end - start)+start;
	 int middle = data[(end+start)/2];
	 int first = data[start];
	 int last = data[end];
//	 System.out.println(first + " " + middle + " " + last);

	 if ((first < middle && first > last) || (first > middle && first < last)){
		 median = start;
	//	 System.out.println("works");
	 }
	 	else{
				if ((last < middle && last > first) || (last > middle && last < first)){
					median = end;
				}
				else{
					median = (end+start)/2;
				}
		}

	 int pivotIndex = median;
   int pivot = data[median];
	// System.out.println(pivot + "pivot");
   if (start == end){
     return data[start];
   }
	// debug(data);
	// System.out.println("start: " + pivot);
   int temp = pivot;
   data[median] = data[start];
   data[start] = temp;
	 pivotIndex = start;
	 start++;
Random a = new Random();
while (start < end){
	if (data[start] < pivot){
		start += 1;
	}
	else{

		if (data[start] == pivot){
			if (a.nextInt(2) == 1){
				temp = data[start];
				data[start] = data[end];
				data[end] = temp;
				end -= 1;
			}
			else{
				start += 1;
			}
		}
			else{
				temp = data[start];
				data[start] = data[end];
				data[end] = temp;
				end -= 1;
			}
	}
}
if (pivot > data[start]){
	temp = pivot;
	data[pivotIndex] = data[start];
	data[start] = temp;
	return start;
}else{
	temp = pivot;
	data[pivotIndex] = data[start-1];
	data[start-1] = temp;
	return start - 1;
}
 }

  public static void main(String args[]){


  //  int[] data6 = {0,1,2,3,50,60,50,50,40,20,30,11,12,13};
  //  System.out.println(partition(data6,4,10) + "ANS");
		//quicksort(data6);
	//	System.out.println("");
  //  for (int i = 0; i < data6.length;i++){
  //    System.out.print(data6[i] + ", ");
//    }
/**
    int[] data7 = {100,300,6,300,100,200,0};
  System.out.println("ans = " + quickselect(data7,5));

	 int[] data3 = new int[20];
	 int[] data4 = new int[20];
	 for (int i = 0; i < data3.length; i++){
	 data3[i] = (int)(Math.random()*1000000000);
	 data4[i] = data3[i];
 }
	quicksort(data3);
	System.out.println("ans: ");
	  for (int i = 0; i < data3.length;i++){
      System.out.print(data3[i] + ", ");
    }
		System.out.println("");
		Arrays.sort(data4);
		for (int i = 0; i < data4.length;i++){
      System.out.print(data4[i] + ", ");
    }

/**
start++;
end--;
for (int i = start; i != end;i++){
boolean moved = false;
if (data[i] == data[start - 1]){
 rand = new Random();
 int randInt = rand.nextInt(2);
 if (randInt == 0){
	 temp = data[i];
	 data[i] = data[end];
	 data[end] = temp;
	 end--;
	 i--;
	 moved = true;
 }
}
	if (!(moved) && data[i] > data[start - 1]){
		temp = data[i];
		data[i] = data[end];
		data[end] = temp;
		end--;
		i--;
	}
}*/

		System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
				//System.out.println("works");
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
					//debug(data2);
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }

/**
System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
int[]MAX_LIST = {1000000000};//,500,10};
for(int MAX : MAX_LIST){
for(int size = 100000; size == 100000; size*=2){
	long qtime=0;
	long btime=0;
	//average of 5 sorts.
	for(int trial = 0 ; trial <=5; trial++){
		int []data1 = new int[size];
		int []data2 = new int[size];
		for(int i = 0; i < data1.length; i++){
			data1[i] = (int)(Math.random()*MAX);
			data2[i] = data1[i];
		}
		long t1,t2;
		t1 = System.currentTimeMillis();
		Quick.quicksort(data2);
		t2 = System.currentTimeMillis();
		qtime += t2 - t1;
		t1 = System.currentTimeMillis();
		Arrays.sort(data1);
		t2 = System.currentTimeMillis();
		btime+= t2 - t1;
		//debug(data1);
		//debug(data2);
		if(!Arrays.equals(data1,data2)){
			System.out.println("FAIL TO SORT!");
		//	debug(data2);
			System.out.println("failed");
			System.exit(0);
		}
	}
//	System.out.println("here");
	System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
}
//System.out.println();

}
**/

	}


}
