// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
import java.util.*;
class HighArray{
      public static final int length = 0;
      private long[] a; // ref to array a
      private int nElements; // number of dât items
  
      public HighArray(int max) {
          a = new long[max]; // create the array
          nElements = 0; // no items yet
      }
  
      public boolean find(long searchKey) {
          int j;
          for (j = 0; j < nElements; j++) {
              if (a[j] == searchKey) {
                  break; // exit loop before end
              }
          }
          if (j == nElements) {
              return false; // yes,can't find it
          } else
              return true; // no,found it
      }// end find
  
      public void insert(long value) /* put element into array */ {
          a[nElements] = value; // insert it
          nElements++; // increment size
      }
  
      public boolean delete(long value) {
          int j;
          for (j = 0; j < nElements; j++) {
              if (value == a[j]) {
                  break; // can't find it
              }
          }
          if (j == nElements) {
              return false;
          } else {
              for (int i = j; i < nElements; i++)
                  a[i] = a[i + 1];
              nElements--;
              return true;
          }
      }
      public long getMax() {
         if (nElements == 0) {
             return -1;
         } else {
             long max = a[0];
             for (long key : a)
                 if (key > max)
                     max = key;
             return max;
         }
 
     }
 
     public long removeMax() {
         if (nElements == 0) {
             return -1;
         } else {
             int temp = 0;
             long max = a[0];
             for (int i = 0; i < nElements; i++) {
                 if (a[i] > max) {
                     max = a[i];
                     temp = i;
                 }
             }
             for (int j = temp; j < nElements; j++) {
                 a[j] = a[j + 1];
             }
             nElements--;
             return max;
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
 
     public void show() {
         for (int i = 0; i < nElements; i++) {
             System.out.print(a[i] + " ");
         }
     }
 }
   //-----------------------------------------------------------
 // end class HighArray
////////////////////////////////////////////////////////////////
public class HighArrayApp {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = 100;
       HighArray A;
       A = new HighArray(n);
       A.insert(50);
       A.insert(90);
       A.insert(77);
       A.insert(44);
       A.insert(58);
       A.insert(15);
       A.insert(11);
       A.insert(77);
       A.insert(77);
       A.insert(19);

       A.show();
       System.out.println();
       int searchKey = sc.nextInt(); 
       if(A.find(searchKey)){
           System.out.println("Found " + searchKey);
       }
       else{
           System.out.println("Can't found " + searchKey);
       }
       A.delete(50);

       System.out.println("After deletion");
       A.show();

       System.out.println();
       System.out.println("Max " + A.getMax());
       System.out.println("Remove Max " + A.removeMax());
       A.show();
       System.out.println();

       System.out.println("Remove dup elements ");
       A.noDups();
       A.show();
       }

   
}
