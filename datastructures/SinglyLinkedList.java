public class SinglyLinkedList {
  Node head;
  public static class Node {
    int data;
    Node next;
    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void enlist(Node x) {
    Node newNode = new Node(x.data);
    if (head == null) {
        head = newNode;
        return;
    }
    Node pass = head;
    while (pass.next != null) {
      pass = pass.next;
    }
    pass.next = newNode;
  }

  public void remove(Node x) {
    if (head.data == x.data) {
      head = head.next;
      return;
    }
    Node prev = head;
    Node pass = head.next;
    while (pass != null && pass.data != x.data) {
      prev = pass;
      pass = pass.next;
    }
    if (pass != null) {
      prev.next = pass.next;
      pass = null;
    }
  }

  public void removeAll(Node x) {
    while (head != null && head.data == x.data) {
      head = head.next;
    }
    if (head == null) {
      return;
    }
    Node prev = head;
    Node pass = head.next;
    while (pass != null) {
      if (pass.data == x.data) {
        prev.next = pass.next;
        pass = pass.next;
      } else {
        prev = pass;
        pass = pass.next;
      }
    }
  }

  public void print() {
    if (head == null) {
      System.out.print("EMPTY");
      return;
    }
    Node pass = head;
    while (pass != null) {
      System.out.print(pass.data + " ");
      pass = pass.next;
    }
  }

  public void reverse() {
    Node prev = null;
    Node ahead = null;
    while (head != null) {
      ahead = head.next;
      head.next = prev;
      prev = head;
      head = ahead;
    }
    head = prev;
  }

  public void reverseByRec(Node pass) {
    if (pass == null) {
      return;
    }
    reverseByRec(pass.next);
    if (pass.next != null) {
      pass.next.next = pass;
      pass.next = null;
    } else {
      head = pass;
    }
  }

  public int length() {
    int length = 0;
    Node pass = head;
    while (pass != null) {
      pass = pass.next;
      length++;
    }
    return length;
  }

  public int lengthByRec(Node head) {
    if (head == null) {
      return 0;
    }
    int count = lengthByRec(head.next);
    return ++count;
  }

  public void swap(Node x, Node y) {
    Node pass1 = head;
    Node pass2 = head;
    Node prev1 = null;
    Node prev2 = null;
    while (pass1 != null && pass1.data != x.data) {
      prev1 = pass1;
      pass1 = pass1.next;
    }
    while (pass2 != null && pass2.data != y.data) {
      prev2 = pass2;
      pass2 = pass2.next;
    }
    if (pass1 == null || pass2 == null) {
      System.out.println("Node(s) not found!");
    }
    if (prev1 != null) {
      prev1.next = pass2;
      head = pass2;
    } else {
    }
    if (prev2 != null) {
      prev2.next = pass1;
    } else {
      head = pass1;
    }
    Node temp = pass1.next;
    pass1.next = pass2.next;
    pass2.next = temp;
    temp = null;
  }

  public Node merge(Node node1, Node node2) {
    Node node = null;
    if (node1 == null) {
      return node2;
    }
    if (node2 == null) {
      return node1;
    }
    if (node1.data > node2.data) {
      node = merge(node1, node2.next);
      node2.next = node;
      head = node2;
      return node2;
    }
    node = merge(node1.next, node2);
    node1.next = node;
    head = node1;
    return node1;
  }
}
