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
		for (int r = 0; r < data.length; r++){
			for (int c = 0; c < data[r].length;
 public static int partition (int[] data, int start, int end){
   Random rand = new Random();
   int randIndex = rand.nextInt(end - start);
   int pivot = data[randIndex];
   System.out.println(pivot + "");
   if (start == end){ //base case
     return data[start];
   }
   int temp = data[randIndex];
   data[randIndex] = data[0];
   data[0] = temp;
   start++;
   for (int i = start; start < end;start++){
     if (data[i] > data[0]){
       temp = data[i];
       data[i] = data[end];
       data[end] = temp;
       end--;
       start--;
     }
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
    System.out.println(partition(data1,1,6) + "");
    for (int i = 0; i < data1.length;i++){
      System.out.print(data1[i] + ", ");
    }
  }


}
