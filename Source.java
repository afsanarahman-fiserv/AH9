class Node<T> {
    T val;
    Node<T> next;
    
    public Node(T val) {
      this.val = val;
      this.next = null;
    }
  }
  
  class Source {
    public static <T> Node<T> reverseList(Node<T> head) {
        // three ptrs :')
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = null;

        while(curr != null) {
            // save node after current (reference to rest of list)
            next = curr.next;
            // switch the current ptr so it points to node before
            curr.next = prev;
            // move each node over
            prev = curr;
            curr = next;
        }

        // curr is now at "end" of list (null), so prev is new head
        return prev;
    }

    public static <T> Node<T> reverseList2(Node<T> head) {
        // create a new list
        Node<T> reversedList = null;

        for(Node<T> ptr = head; ptr != null; ptr = ptr.next) {
            // create a duplicate node of ptr
            Node<T> node = new Node<>(ptr.val);
            // put that node at the beginning of the reversed list
            node.next = reversedList;
            // set the head of the reversed list equal to the new node
            reversedList = node;
        }

        return reversedList;
    }
    
    public static void main(String[] args) {
        Node<String> w = new Node<>("w");
        Node<String> x = new Node<>("x");
        Node<String> y = new Node<>("y");
        Node<String> z = new Node<>("z");
    
        w.next = x; // w -> x
        x.next = y; // w -> x -> y
        y.next = z; // w -> x -> y -> z

        // Printing solution
        Node<String> head = Source.reverseList(w);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;            
        }
    }
  }