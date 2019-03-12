import java.util.Random;
public class Quick{

	/*return the value that is the kth smallest value of the array.
 */
 	public static int quickselect(int []data, int k){ 
		int first = partition(data,0,data.length - 1);
		while (k != first){
			if (k < first){
				first = partition(data,0,first);
			}
			if (k > first){
				first = partition(data,first,data.length);
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
	 end++;
   Random rand = new Random();
   int randIndex = rand.nextInt(end - start)+start; //FIX THIS`````````````````````````````````````````
   int pivot = data[randIndex];
   System.out.println("pivot: " + pivot + "");
	// debug(data);
   if (start == end){ 
     return data[start];
   }
   int temp = data[randIndex];
   data[randIndex] = data[start];
	 //debug(data);
   data[start] = temp;
System.out.println("start: " + start);
	 start++;
System.out.println("start: " + start);
	 end--;
	 //debug(data);
   //start++;
	 //debug(data);
   for (int i = start; i != end;i++){
		// System.out.println(data[i]);
     if (data[i] > data[start--]){//<---------------------------------------------------------
       temp = data[i];
			// debug(data);
       data[i] = data[end];
			// debug(data);
       data[end] = temp;
			// System.out.println(i + " " + end);
			// System.out.println(i + "!!!!");
			//debug(data);
       end--;
       i--;
     }
		 // PUT PIVOT BACK IN PLACE HERE MAYBE WITH AN INDEX INCREASING VARIABLE
		 /**
		 if (data[i] < data[0]){
			 System.out.println(i + "!!!!");
			 System.out.println(newPivotIndex + "this one");
			 newPivotIndex++;
		 }
		 **/
		 //if (data[i] < data[0]){

		 //}
   }

   //putting pivot back
   int pIndex = 0;
   boolean found = false;
	 //System.out.println(data.length+"size");
	 for (int i = start; i < data.length && !(found);i++){
		 if (data[i] < data[0]){
			 pIndex += 1;
		 }
		 if (data[i] > data[0]){
			 found = true;
		 }
	 }
	 /**
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

//System.out.println("INDEX: " + newPivotIndex + "");
temp = data[start];
data[start] = data[pIndex];

data[pIndex] = temp;
  return 0;//pIndex;
 }

  public static void main(String args[]){
    int[] data1 = {90,60,50,40,30,70,20};
    System.out.println(partition(data1,1,6));
		//System.out.println("");
    for (int i = 0; i < data1.length;i++){
      System.out.print(data1[i] + ", ");
    }
  }


}
