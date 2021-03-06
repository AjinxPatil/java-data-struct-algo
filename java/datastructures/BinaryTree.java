package datastructures;

/**
 * <code>BinaryTree</code> is a tree data structure in which each
 * <code>Node</code> element has two child nodes as left and right children.
 *
 * @author Ajinkya Patil
 */
public class BinaryTree {
  public static class Node {
    public int data;
    public Node left;
    public Node right;

    private Node() {
    }

    public Node(int value) {
      this.data = value;
    }
  }

  public Node root;

  private static boolean levelSearch(Node root, int data, int level) {
    if (root == null) {
      return false;
    }
    boolean result = false;
    if (level == 1) {
      if (root.data == data) {
        return true;
      }
    } else if (level > 1) {
      result = levelSearch(root.left, data, level - 1);
      if (result) {
        return true;
      }
      result = levelSearch(root.right, data, level - 1);
    }
    return result;
  }

  public boolean breadthFirstSearch(int data, int uptoLevel) {
    for (int i = 1; i <= uptoLevel; i++) {
      boolean result = levelSearch(root, data, i);
      if (result) {
        return true;
      }
    }
    return false;
  }

  public int height() {
    return height(root);
  }

  private static int height(Node root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    if (left < right) {
      return right + 1;
    }
    return left + 1;
  }
}
