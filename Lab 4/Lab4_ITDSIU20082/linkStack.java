// linkStack.java
// demonstrates a stack implemented as a list
// to run this program: C>java LinkStackApp
////////////////////////////////////////////////////////////////
import java.util.Stack;
class Link
   {
   public long dData;             // data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(long dd)           // constructor
      { dData = dd; }
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      { System.out.print(dData + " "); }
   }  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
   {
   private Link first;            // ref to first item on list
// -------------------------------------------------------------
   public Link getFirst(){
      return first;
   }
   public LinkList()              // constructor
      { first = null; }           // no items on list yet
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      { return (first==null); }
// -------------------------------------------------------------
   public void insertFirst(int dd) // insert at start of list
      {                           // make new link
      Link newLink = new Link(dd);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink
      }
// -------------------------------------------------------------
   public long deleteFirst()      // delete first item
      {                           // (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp.dData;          // return deleted link
      }
// -------------------------------------------------------------
   public void displayList()
      {
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class LinkList
////////////////////////////////////////////////////////////////
class LinkStack
   {
   private LinkList theList;
//--------------------------------------------------------------
   public LinkStack()             // constructor
      {
      theList = new LinkList();
      }
//--------------------------------------------------------------
   public void push(int j)     // put item on top of stack
      {
      theList.insertFirst(j);
      }
//--------------------------------------------------------------
   public double pop()            // take item from top of stack
      {
      return theList.deleteFirst();
      }
//--------------------------------------------------------------
   public boolean isEmpty()       // true if stack is empty
      {
      return ( theList.isEmpty() );
      }
//--------------------------------------------------------------
   public void displayStack()
      {
      System.out.print("Stack (top-->bottom): ");
      theList.displayList();
      }
//--------------------------------------------------------------
   public Link getFirst() {
      return theList.getFirst();
   }
   
   }  // end class LinkStack
////////////////////////////////////////////////////////////////
class reverseLinkStack{
   public static Link reverseLinkStack(Link first){
      Stack <Link> stack = new Stack<Link>();
      Link current = first;

      //push element onto stack
      while (current != null){
         stack.push(current);
         current = current.next;
      }

      // pop element from the stack and move it into the reversed list
      Link newfirst = stack.pop();
      current = newfirst;

      while (!stack.isEmpty()){
         current.next = stack.pop();
         current = current.next;
      }

      current.next = null; 
      return newfirst;

   }
}
////////////////////////////////
class LinkStackApp
   {
   public static void main(String[] args)
      {
      LinkStack theStack = new LinkStack(); // make stack

      theStack.push(20);                    // push items
      theStack.push(40);

      theStack.displayStack();              // display stack

      theStack.push(60);                    // push items
      theStack.push(80);

      theStack.displayStack();              // display stack

      theStack.pop();                       // pop items
      theStack.pop();

      theStack.displayStack();              // display stack
      
      Link reversed = reverseLinkStack.reverseLinkStack(theStack.getFirst()); // reverse
      System.out.println("Reversed List:");
        while (reversed != null) {
            System.out.print(reversed.dData + " ");
            reversed = reversed.next;
      }  // end main()
   }
  }  // end class LinkStackApp
////////////////////////////////////////////////////////////////
