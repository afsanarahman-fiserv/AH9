class ECSource {
  public static <T> boolean isUnivalueList(Node<T> head) {
    T unival = head.val;
    while(head != null) {
        if(!head.val.equals(unival)) {
            return false;
        }
        // if conditional is false, list is still good
        head = head.next;
    }

    // looped through all nodes without returning false
    return true;
  }

  public static <T> boolean recursiveUnival(Node<T> head, T unival) {
      // reached end of list
      if(head == null) {
          return true;
      }

      // out of place value -- can return false for the whole list
      if(head.val != unival) {
          return false;
      }

      // check next node (i.e., rest of list)
      return recursiveUnival(head.next, unival);
  }

  public static void main(String[] args) {
      // TEST 1
      Node<Integer> u = new Node<>(2);
      Node<Integer> v = new Node<>(2);
      Node<Integer> w = new Node<>(2);
      Node<Integer> x = new Node<>(2);
      Node<Integer> y = new Node<>(2);
      u.next = v;
      v.next = w;
      w.next = x;
      x.next = y;
      System.out.println(ECSource.isUnivalueList(u)); // true
      System.out.println(ECSource.recursiveUnival(u, u.val)); // true

      // TEST 2
      Node<Integer> a = new Node<>(2);
      Node<Integer> b = new Node<>(2);
      Node<Integer> c = new Node<>(3);
      Node<Integer> d = new Node<>(3);
      Node<Integer> e = new Node<>(2);
      a.next = b;
      b.next = c;
      c.next = d;
      d.next = e;
      System.out.println(ECSource.isUnivalueList(a)); // false
      System.out.println(ECSource.recursiveUnival(a, a.val)); // false

      // TEST 3
      Node<String> z = new Node<>("z");
      System.out.println(ECSource.isUnivalueList(z)); // true
      System.out.println(ECSource.recursiveUnival(z, z.val)); // true
    }
}
