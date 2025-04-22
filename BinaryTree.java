public class BinaryTree<K, V> {
        private Node<K, V> root;

    BinaryTree(){
    }
    Node<K, V> getRoot(){
        return root;
    }

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


         public V add (K key, V value){
            if (lookup(key) != null) return lookup(key);

            else if (root == null) {
                root = new Node<>(key, value);
                return null;
            } else {
                getFreeNode(root, key, value);

                return null;
                //  return V;

            }
        }


        public void  getFreeNode(Node<K, V> node, K key, V value){
            Node<K,V> newnode = new Node<>(key, value);
            lookup(key);
            if(node == null ){
                return;
            }
            else if(node.left== null) {
                node.left= newnode;
                return;
            }
            else if(node.right==null) {
                node.right = newnode;
                return;
            }
            else {
                if(node.left.left== null || node.left.right == null) {
                    getFreeNode(node.left, key, value);
                }
                else if(node.right.left ==null || node.right.right==null){
                    getFreeNode(node.right, key, value);
                }
                else{


                }

            }



        }
//HOW SHOULD THE ORDER GO. AND HOW TO DO IT.








    //A method called remove that takes a K key as input and removes the associated <key,
    //value> pair from the tree. The method should return the value if it successfully removed
    //key from the tree, and it should return null if it did not remove key from the tree (i.e., if
    //key was not in the tree).

    public V remove(K key){
        Node<K, V> removenode = removeHelper(root, key);
        V value;
        if(removenode.left.key.equals(key)){
            value = removenode.left.value;
            removenode.left =null; //what happens to the children of the removed node.
            return value;
        }
        else if(removenode.right.key.equals(key)){
            value = removenode.right.value;
            removenode.right=null;
            return value;
        }
      return null;
    }
    public Node<K, V> removeHelper(Node<K,V> node, K key){
        if (node == null) return null;
        else if(node.left.key.equals(key) || node.right.key.equals(key)){
            return node;
        }

        else {
            Node<K, V> leftlookup =lookupHelper(node.left, key);
            if(leftlookup!=null) return leftlookup; //if it isn't null, then it means that they found the node with the same key.
            else{
                return lookupHelper(node.right, key); //if it wasn't on the left, then it must be on the right, or there isn't a node
                //with the same key.
            }


        }
    }



    // A method called lookup that takes a K key as input and determines whether key appears
    //in the tree. The method should return the associated value if the tree contains key and
    //null otherwise

    public V lookup(K key){
        Node<K, V> node = lookupHelper(root, key);
        if(node==null) return null;
        else return node.value;


    }




    public Node<K, V> lookupHelper(Node<K,V> node,K key) {
        if (node == null) return null;
        else if(node.key.equals(key)){
            return node;
        }

        else {
            Node<K, V> leftlookup =lookupHelper(node.left, key);
                if(leftlookup!=null) return leftlookup; //if it isn't null, then it means that they found the node with the same key.
                else{
                    return lookupHelper(node.right, key); //if it wasn't on the left, then it must be on the right, or there isn't a node
                    //with the same key.
                }


        }
    }
    //A method called inOrderTraverse that, when called on the root, prints all <key,
    //value> pairs in the tree via in-order traversal, with each pair appearing on a new line
    //in the format (key, value). This method should have no input parameters and should
    //not return anything.

    public void inOrderTraverse(Node<K, V> node){
        if(node == null) return;

        else if(node.left==null && node.right == null){
            System.out.println(node.key + " " + node.value + " FINAL");
            return;
        }
        else{
            inOrderTraverse(node.left);
            System.out.println(node.key + " " + node.value);
            inOrderTraverse(node.right);
        }
    }
}
