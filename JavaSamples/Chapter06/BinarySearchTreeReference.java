public class BinarySearchTreeReference {
  class BST {
    int data;
    BST left, right;

    public BST(int item) {
      data = item;
      left = right = null;
    }
  }

  BST root;

  BinarySearchTreeReference() {
    root = null;
  }
 
  BST addBSTRec(BST root, int data) {
    if (root == null) {
      root = new BST(data);
      return root;
    }

    if (data < root.data) {
      root.left = addBSTRec(root.left, data);
    } else if (data > root.data) {
      root.right = addBSTRec(root.right, data);
    }
    return root;
  }

  void printPhysicalBSTRec(BST root) {
    int left, right;
    if (root != null) {
      if(root.left == null) {
        left = 0;
      } else {
        left = (root.left).data;
      }

      if(root.right == null) {
        right = 0;
      } else {
        right = (root.right).data;
      }
      System.out.printf("data: %d, left: %d, right: %d\n", root.data, left, right);
      printPhysicalBSTRec(root.right);
      printPhysicalBSTRec(root.left);
    }
  }

  void printLogicalBSTRec(BST root) {
    int left, right;
    if (root != null) {
      if(root.left == null) {
        left = 0;
      } else {
        left = root.left.data;
      }

      if(root.right == null) {
        right = 0;
      } else {
        right = root.right.data;
      }
      System.out.printf("data: %d, left: %d, right: %d\n", root.data, left, right);
      printLogicalBSTRec(root.left);
      printLogicalBSTRec(root.right);
    }
  }

  void addBST(int data) {
    root = addBSTRec(root, data);
  }

  void printPhysicalBST() {
    printPhysicalBSTRec(root);
  }
 
  void printLogicalBST() {
    printLogicalBSTRec(root);
  }

  public static void main(String[] args) {
    BinarySearchTreeReference tree = new BinarySearchTreeReference();
 
    tree.addBST(4);
    tree.addBST(6);
    tree.addBST(5);
    tree.addBST(2);
    tree.addBST(3);
    tree.addBST(7);
    tree.addBST(1);
 
    tree.printPhysicalBST();
    System.out.println("--------------------------");
    tree.printLogicalBST();
  }
}
