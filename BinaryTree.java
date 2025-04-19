public class BinaryTree<K, V> {

    // method called add that takes a K key and an V value as input and inserts the <key,
    //value> pair into the next available position in your tree. In order to find the next available
    //position: find a node whose left or right child is empty. If we find a node whose left child is
    //empty, we make a new key as the left child of the node. Else if we find a node whose right
    //child is empty, we make the new key as the right child. If both children are empty, insert on
    //the left. If no nodes have been inserted yet, the first node inserted is the root. Traverse the
    //tree (via in-order traversal) until we find a node whose either left or right child is empty.
    //If key already appears in the tree, this method should not perform an addition, i.e. no
    //repeated data items in the tree, and should return the value associated with the <key,
    //value> pair already existing in the tree. If key was not already in tree, this method should
    //return null

    public V add(K key, V value){




      //  return V;

    }
    //A method called remove that takes a K key as input and removes the associated <key,
    //value> pair from the tree. The method should return the value if it successfully removed
    //key from the tree, and it should return null if it did not remove key from the tree (i.e., if
    //key was not in the tree).

    public V remove(K key){


      //  return V;
    }
    // A method called lookup that takes a K key as input and determines whether key appears
    //in the tree. The method should return the associated value if the tree contains key and
    //null otherwise

    public V lookup(K key){

    //    return V;
    }

    //A method called inOrderTraverse that, when called on the root, prints all <key,
    //value> pairs in the tree via in-order traversal, with each pair appearing on a new line
    //in the format (key, value). This method should have no input parameters and should
    //not return anything.

    public void inOrderTraverse(){
        
    }
}
