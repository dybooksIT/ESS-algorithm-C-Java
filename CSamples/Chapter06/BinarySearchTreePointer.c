#include <stdio.h>
#include <stdlib.h>
 
typedef struct BST {
    int data;
    struct BST *left, *right;
} BST;

BST *addNode(int item) {
  BST *temp = (BST *)malloc(sizeof(BST));
  temp->data = item;
  temp->left = temp->right = NULL;
  return temp;
}

BST *addBST(BST *node, int data) {
  if (node == NULL)
    return addNode(data);

  if (data < node->data) {
    node->left = addBST(node->left, data);
  }
  else if (data > node->data) {
    node->right = addBST(node->right, data);
  }

  return node;
}

void printPhysicalBST(BST *root) {
  int left, right;
  if (root != NULL) {
    if(root->left == NULL) {
        left = 0;
    } else {
        left = (root->left)->data;
    }
    
    if(root->right == NULL) {
        right = 0;
    } else {
        right = (root->right)->data;
    }
    printf("data: %d, left: %d, right: %d\n", root->data, left, right);
    printPhysicalBST(root->right);
    printPhysicalBST(root->left);
  }
}

void printLogicalBST(BST *root) {
  int left, right;
  if (root != NULL) {
    if(root->left == NULL) {
        left = 0;
    } else {
        left = (root->left)->data;
    }
    
    if(root->right == NULL) {
        right = 0;
    } else {
        right = (root->right)->data;
    }
    printf("data: %d, left: %d, right: %d\n", root->data, left, right);
    printLogicalBST(root->left);
    printLogicalBST(root->right);
  }
}

int main() {
  BST *root = NULL;
  root = addBST(root, 4);
  addBST(root, 6);
  addBST(root, 5);
  addBST(root, 2);
  addBST(root, 3);
  addBST(root, 7);
  addBST(root, 1);

  printPhysicalBST(root);
  printf("--------------------------\n");
  printLogicalBST(root);
  printf("--------------------------\n");

  return 0;
}