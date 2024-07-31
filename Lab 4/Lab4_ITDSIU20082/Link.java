// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////

class Link {
    public int iData; // data item
    public double dData; // data item
    public Link next; // next link in list
    // -------------------------------------------------------------
 
    public Link(int id, double dd) // constructor
    {
       iData = id; // initialize data
       dData = dd; // ('next' is automatically
    } // set to null)
    // -------------------------------------------------------------
 
    public void displayLink() // display ourself
    {
       System.out.print("{" + iData + ", " + dData + "} ");
    }
 
 } // end class Link
 ////////////////////////////////////////////////////////////////
 
 class LinkList {
    private Link first; // ref to first link on list
 
    // -------------------------------------------------------------
 
    public Link getfist() {
       return first;
    }
 
    public LinkList() // constructor
    {
       first = null; // no links on list yet
    }
 
    // -------------------------------------------------------------
    public boolean isEmpty() // true if list is empty
    {
       return (first == null);
    }
 
    // -------------------------------------------------------------
    // insert at start of list
    public void insertFirst(int id, double dd) { // make new link
       Link newLink = new Link(id, dd);
       newLink.next = first; // newLink --> old first
       first = newLink; // first --> newLink
    }
 
    // -------------------------------------------------------------
    public Link deleteFirst() // delete first item
    { // (assumes list not empty)
       if (isEmpty()) {
          System.out.println("The list is empty");
          return null;
       }
 
       Link temp = first; // save reference to link
       first = first.next; // delete it: first-->old next
       return temp; // return deleted link
    }
 
    // -------------------------------------------------------------
    public void displayList() {
       System.out.print("List (first-->last): ");
       Link current = first; // start at beginning of list
       while (current != null) // until end of list,
       {
          current.displayLink(); // print data
          current = current.next; // move to next link
       }
       System.out.println("");
    }
 
    public Link getFirstElement() { // access the first and the last element in the list
       if (!isEmpty()) {
          return first; // return the first element
       } else {
          return null; // return the last element
       }
    }
 
    public Link getLastElement() {
       if (isEmpty()) {
          return null; // return the last element
       }
 
       Link current = first; // start at beginning of list
       while (current != null) {
          current = current.next; // move to next link
 
       }
       return current; // until end of null element
    } //
 
    
   public String toString() {
      Link firstElement = getFirstElement();
      Link lastElement = getLastElement();

      if (firstElement == null && lastElement == null) {
        return "The list is empty";
      } 
      else {
        StringBuilder result = new StringBuilder("the first element: ");
        if (firstElement != null) {
            result.append(firstElement.iData).append(", ").append(firstElement.dData);
        } 
        else {
            result.append("null");
        }
        
        result.append(", the last element: ");
        if (lastElement != null) {
            result.append(lastElement.iData).append(", ").append(lastElement.dData);
        } else {
            result.append("null");
        }
        
        return result.toString();
    }
}

 }
 
 // -------------------------------------------------------------
 // end class LinkList
 ////////////////////////////////////////////////////////////////
 class LinkListApp {
 
    public static void main(String[] args) {
       LinkList theList = new LinkList(); // make new list
 
       theList.insertFirst(22, 2.99); // insert four items
       theList.insertFirst(44, 4.99);
       theList.insertFirst(66, 6.99);
       theList.insertFirst(88, 8.99);
 
       theList.displayList();
       System.out.println(theList.toString()); // display list
 
       while (!theList.isEmpty()) // until it's empty,
       {
          Link aLink = theList.deleteFirst(); // delete link
          System.out.print("Deleted "); // display it
          aLink.displayLink();
          System.out.println("");
       }
       theList.displayList();
      //  theList.toString(); // display list
    } // end main()
 } // end class LinkListApp
 ////////////////////////////////////////////////////////////////
 