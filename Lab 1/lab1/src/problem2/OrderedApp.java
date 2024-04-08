// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray{
   
   private long[] a;
   private int nElements;

   public OrdArray(int max){
       a = new long[max];
       nElements = 0;
   }

   public int size(){
       return nElements;
   }

   public int find(long searchKey){
       int lowerBound = 0;
       int upperBound = nElements - 1;
       int curIn;
       
       while(true){
           curIn = (lowerBound + upperBound) / 2;
           if(a[curIn] == searchKey){
               return curIn;
           }
           else if(lowerBound > upperBound){
               return nElements;
           }
           else{
               if(a[curIn] < searchKey){
                   lowerBound = curIn + 1; //It's in upper half
               }
               else
                   upperBound = curIn - 1; //It's in lower half
           }//end else divide range
       }//end while
   }//end find()

   public void insert(long value){
       int j;
       for(j = 0; j < nElements; j++){
           if(a[j] > value)
               break;
       }
       for (int i = nElements; i > j; i--) {
           a[i] = a[i - 1];
       }
       a[j] = value;
       nElements++;
   }//end insert

   public boolean delete(long value){
       int j = find(value);
       if(j == nElements){
           return false;
       }
       else{
           for(int k = j; k < nElements; k++){
               a[k] = a[k + 1];
           }
           nElements--;
           return true;
       }
   }//end delete

   public long get(int index){
       return a[index];
   }
   public void add(long value){
       a[nElements++] = value;
   }
   public static void merge(OrdArray A1, OrdArray A2, OrdArray destination){
       int index1 = 0;
       int index2 = 0;
       while(index1 < A1.size() && index2 < A2.size()){
           if(A1.get(index1) <= A2.get(index2)){
               destination.add(A1.get(index1++));
           }
           else{
               destination.add(A2.get(index2++));
           }
       }
       while(index1 <A1.size()){
           destination.add(A1.get(index1++));
       }
       while(index2 < A2.size()){
           destination.add(A2.get(index2++));
       }
   }
   public void noDups() {
       long[] result = new long[a.length];
       int x = 0;
       for (int i = 0; i < nElements; i++) {
           boolean dup = false;
           for (int j = 0; j < x; j++) {
               if (a[i] == result[j]) {
                   dup = true;
                   break;
               }
           }
               if(!dup){
                   result[x++] = a[i];
               }
       }
       for (int i = 0; i < x; i++) {
           a[i] = result[i];
       }
       nElements = x;
   }
   public void show(){
       for(int i = 0; i < nElements; i++){
           System.out.print(a[i] + " ");
       }
   }//end show    
}//end class orderArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
      arr.show();
      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.show();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);
      System.out.println("\nAfter deletion");
      arr.show();                 // display items again
      System.out.println("The second array");
      OrdArray arr2;
      arr2 = new OrdArray(maxSize);
      arr2.insert(66);
      arr2.insert(55);
      arr2.insert(11);
      arr2.insert(22);
      arr2.insert(33);
      arr2.insert(44);
      arr2.insert(88);
      arr2.insert(00);
      arr2.insert(12);
      arr2.insert(33);

      OrdArray mergeA = new OrdArray(maxSize);
      OrdArray.merge(arr, arr2,mergeA);
      System.out.println("Two merge array");
      mergeA.show();
      System.out.println();
      System.out.println("Remove Dup");
      mergeA.noDups();
      mergeA.show(); 
  }
} // end main() // end class OrderedApp
