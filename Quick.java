import java.util.Random;
public class Quick{

	public static void quicksort(int[] data){
		quicksortHelper(data, 0 , data.length - 1);
	}

	private static void quicksortHelper(int[] data, int lo, int hi){
		if (lo >= hi){
			return;
		}
		int pivot = partition(data,lo,hi);
		quicksortHelper(data,lo,pivot);
		quicksortHelper(data,pivot,hi);
	}

	/*return the value that is the kth smallest value of the array.
 */
 	public static int quickselect(int []data, int k){
    //k--;
		int first = partition(data,0,data.length - 1);
		while (k != first){
			if (k < first){
				first = partition(data,0,first);
			}
			if (k > first){
				first = partition(data,first,data.length-1);
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
    int origEnd = end;
	 int newPivotIndex = 0;
	 end++;
   Random rand = new Random();
   int randIndex = rand.nextInt(end - start)+start; //FIX THIS`````````````````````````````````````````
   int pivot = data[randIndex];
   //System.out.println("pivot: " + pivot + "");
	// debug(data);
   if (start == end){
     return data[start];
   }
   int temp = data[randIndex];
   data[randIndex] = data[start];
	 //debug(data);
   data[start] = temp;
	 start++;
	 end--;
	 //debug(data);
   //start++;
	 //debug(data);
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
		// System.out.println(data[i]);
     if (!(moved) && data[i] > data[start - 1]){//<---------------------------------------------------------
       //System.out.println("i: " + i + " end: " + end);
       temp = data[i];
			 //debug(data);
       data[i] = data[end];
			 //debug(data);
       data[end] = temp;
			// System.out.println(i + " " + end);
			// System.out.println(i + "!!!!");
			//debug(data);
       end--;
       i--;
     }
   }

   //putting pivot back
   int pIndex = start-1;
   boolean found = false;
	 //System.out.println(data.length+"size");
   //System.out.println(start-1 + " this");
	 for (int i = start; i < end + 1 && !(found);i++){
		 if (data[i] < data[start-1]){
      //System.out.println(data[i] + " & " + data[start-1]);
			 pIndex += 1;
		 }
		 if (data[i] > data[start-1]){
       //System.out.println(data[i] + " & " + data[start-1]);
			 found = true;
		 }
	 }

//System.out.println("INDEX: " + newPivotIndex + "");
temp = data[start-1];
data[start-1] = data[pIndex];

data[pIndex] = temp;
  return pIndex;//pIndex;
 }

  public static void main(String args[]){
    int[] data1 = {90,60,50,40,30,70,20};
    System.out.println(partition(data1,1,5) + "ANS");
		//System.out.println("");
    for (int i = 0; i < data1.length;i++){
      System.out.print(data1[i] + ", ");
    }

    int[] data2 = {90,60,50,40,30,70,20};
    System.out.println("ans = " + quickselect(data2,4));
	
	 int[] data3 = {90,60,50,40,30,70,20};
	quicksort(data3);
	  for (int i = 0; i < data3.length;i++){
      System.out.print(data1[i] + ", ");
    }
	}


}
