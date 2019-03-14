import java.util.Random;
import java.util.Arrays;
public class Quick{

	public static void quicksort(int[] data){
		quicksortHelper(data, 0 , data.length - 1);
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
	 int newPivotIndex = 0;
	 //end++;
   Random rand = new Random();
   int median = (end-start)/2;//rand.nextInt(end - start)+start;
	 int pivotIndex = median + start;
   int pivot = data[pivotIndex];
	// System.out.println(pivot + "pivot");
   if (start == end){
     return data[start];
   }
   int temp = pivot;
   data[median + start] = data[start];
   data[start] = temp;
	 pivotIndex = start;
	 start++;
//debug(data);
while (start != end){
//	System.out.println("start: " + start + " end: " + end);
	int currentIndex = start;
	int currentValue = data[currentIndex];
	if (currentValue < pivot){
		start++;
	}
	else{
		if (currentValue == pivot){
			rand = new Random();
		  int randInt = rand.nextInt(2);
			if (randInt == 0){
				temp = data[currentIndex];
				data[currentIndex] = data[end];
				data[end] = temp;
				end--;
			}
		}
			else{
				temp = data[currentIndex];
				data[currentIndex] = data[end];
				data[end] = temp;
				end--;
			}
	}
	//debug(data);
	//System.out.println("start: " + start + " end: " + end);
}

   int pIndex = pivotIndex;
   boolean found = false;
	 for (int i = pivotIndex+1; i < end + 1 && !(found);i++){
		 if (data[i] < data[pivotIndex]){
			 pIndex += 1;
		 }
		 if (data[i] > data[pivotIndex]){
			 found = true;
		 }
	 }
temp = data[pivotIndex];
data[pivotIndex] = data[pIndex];

data[pIndex] = temp;
//debug(data);
  return pIndex;
 }

  public static void main(String args[]){

/**
    int[] data6 = {1,100,200,700,100,600,500,300};
    System.out.println(partition(data6,0,7) + "ANS");
		System.out.println("");
    for (int i = 0; i < data6.length;i++){
      System.out.print(data6[i] + ", ");
    }
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
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
					debug(data2);
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
