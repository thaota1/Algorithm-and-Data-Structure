////////////////////////////////////////////////////////////////
class Link {
   public int iData;              // data item
   public double dData;           // data item
   public Link next;              // next link in list

   // Constructor
   public Link(int id, double dd) {
       iData = id;                 // initialize data
       dData = dd;                 // ('next' is automatically set to null)
   }

   // Display a single link
   public void displayLink() {
       System.out.print("{" + iData + ", " + dData + "} ");
   }

   // Convert link to string
   @Override
   public String toString() {
       return "{" + iData + ", " + dData + "}";
   }
}

////////////////////////////////////////////////////////////////
class LinkList {
   private Link first;            // ref to first link on list

   // Constructor
   public LinkList() {
       first = null;               // no links on list yet
   }

   // Check if list is empty
   public boolean isEmpty() {
       return (first == null);
   }

   // Insert at the start of list
   public void insertFirst(int id, double dd) {
       Link newLink = new Link(id, dd);  // make new link
       newLink.next = first;             // newLink --> old first
       first = newLink;                  // first --> newLink
   }

   // Delete first item
   public Link deleteFirst() {
       if (isEmpty()) return null;  // return null if list is empty
       Link temp = first;           // save reference to link
       first = first.next;          // delete it: first-->old next
       return temp;                 // return deleted link
   }

   // Access the first element
   public Link getFirst() {
       return first;
   }

   // Access the last element
   public Link getLast() {
       if (isEmpty()) return null;
       Link current = first;
       while (current.next != null) {  // Traverse to the end
           current = current.next;
       }
       return current;
   }

   // Display the entire list
   public void displayList() {
       System.out.print("List (first-->last): ");
       Link current = first;
       while (current != null) {
           current.displayLink();
           current = current.next;
       }
       System.out.println();
   }

   // Convert list to string
   @Override
   public String toString() {
       StringBuilder sb = new StringBuilder();
       Link current = first;
       while (current != null) {
           sb.append(current.toString()).append(" ");
           current = current.next;
       }
       return sb.toString().trim();
   }
}

////////////////////////////////////////////////////////////////
class LinkListApp {
   public static void main(String[] args) {
       LinkList theList = new LinkList();  // make new list

       theList.insertFirst(22, 2.99);      // insert four items
       theList.insertFirst(44, 4.99);
       theList.insertFirst(66, 6.99);
       theList.insertFirst(88, 8.99);

       // Display list using displayList
       theList.displayList();
       
       // Display list using toString()
       System.out.println("List: " + theList);

       // Access and display the first and last elements
       System.out.println("First element: " + theList.getFirst());
       System.out.println("Last element: " + theList.getLast());

       while (!theList.isEmpty()) {         // until it's empty,
           Link aLink = theList.deleteFirst();   // delete link
           System.out.print("Deleted ");
           aLink.displayLink();
           System.out.println();
       }

       // Display list after deletion
       theList.displayList();
   }
}
////////////////////////////////////////////////////////////////
