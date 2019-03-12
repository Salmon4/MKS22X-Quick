import java.util.Random;
public class Quick{










  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */

	public static void debug(int[] data){
		System.out.println(" ");
		for (int r = 0; r < data.length; r++){
			System.out.print(data[r]+", ");
		}
	}
 public static int partition (int[] data, int start, int end){
	 end++;
   Random rand = new Random();
   int randIndex = rand.nextInt(end - start)+start; //FIX THIS`````````````````````````````````````````
   int pivot = data[randIndex];
   System.out.println(pivot + "");
	// debug(data);
   if (start == end){ //base case
     return data[start];
   }
   int temp = data[randIndex];
   data[randIndex] = data[0];
	 //debug(data);
   data[0] = temp;
	 start++;
	 end--;
	 //debug(data);
   //start++;
	 //debug(data);
   for (int i = start; i != end;i++){
		// System.out.println(data[i]);
     if (data[i] > data[0]){
       temp = data[i];
			// debug(data);
       data[i] = data[end];
			// debug(data);
       data[end] = temp;
			 System.out.println(i + " " + end);
			debug(data);
       end--;
       i--;
     }
		 //if (data[i] < data[0]){

		 //}
   }
/**
   //putting pivot back
   int pIndex = 0;
   int next = pIndex+1;
   while (pIndex < data.length && next < data.length && data[pIndex] > data[next]){
    temp = data[pIndex];
    data[pIndex] = data[next];
    next = temp;
    if (pIndex == data.length - 1 || data[pIndex+1] < data[pIndex+1]){
      return next;
    }
    pIndex++;
    next++;
  }
**/
  return 0;//pIndex;
 }

  public static void main(String args[]){
    int[] data1 = {10, 80, 30, 90, 40, 50, 70};
    partition(data1,0,4);
		System.out.println("");
    for (int i = 0; i < data1.length;i++){
      System.out.print(data1[i] + ", ");
    }
  }


}
