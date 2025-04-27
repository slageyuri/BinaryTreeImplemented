public class BinaryTree<K, V> {
        private Node<K, V> root;

    BinaryTree(){
    }
    public Node<K, V> getRoot(){
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
                Node<K, V> parent = getFreeNode(root);
                if(parent==null) return null;
                Node<K, V> newnode = new Node<>(key, value);
                if(parent.left==null){
                    parent.left = newnode;
                }
                else if(parent.right==null){
                    parent.right=newnode;
                }
                return null;


            }
        }


        private Node<K, V> getFreeNode(Node<K, V> node){


            if(node == null ){
                return null;
            }
            else if(node.left== null || node.right==null) {
                return node; //Returns the parentnode that has a free space
            }

            else {
               return getFreeNode(node.left); // INORDER: LEFT - ROOT - RIGHT
                //Recursive method that repeats the same algorithm on the left node, since we are in in-order traversal,  the trees must grow to the left first.

                }

            }














    //A method called remove that takes a K key as input and removes the associated <key,
    //value> pair from the tree. The method should return the value if it successfully removed
    //key from the tree, and it should return null if it did not remove key from the tree (i.e., if
    //key was not in the tree).

    //REMOVE NODE AND RECONNECT CHILDREN TO THE TREE
    public V remove(K key){
        Node<K, V> parentnode = removeHelper(root, key);//PARENT NODE
        V value;
        if(parentnode==null){
            return null;
        }
        else if(parentnode.key.equals(key)){
            value =parentnode.value;
            //case you want to remove the root: IF there's a right child and IF there isn't
            if(parentnode.right!=null) { //IF THERE'S A RIGHT CHILD
                Node<K, V> newroot = parentnode.right; //right child will take the place of the root.
                newroot.left = parentnode.left; //THE RIGHT CHILD WILL BECOME THE ROOT AND POINT TO ITS LEFT BROTHER (now child)
                root = newroot;
                root.right = null;

                return value;
            }
            else{//Only left child / No child if root is the only node. (root.left== null -> root=null);
                root= root.left;

            }

            return value;
        }

        if(parentnode.left.key.equals(key)){
            Node<K,V> removenode = parentnode.left;
            value = removenode.value;
            //THREE CASES:
            //FIRST: THE NODE HAS NO CHILDREN
            if(removenode.left ==null && removenode.right==null) {
                parentnode.left = null;
            }
            //SECOND: THE NODE HAS ONE CHILDREN (ON THE LEFT) - SO THE CHILD NODE JUST TAKES REMOVENODE'S PLACE
            else if( removenode.left!=null && removenode.right==null){
                parentnode.left= removenode.left;
            }
            //THIRD: THE NODE HAS TWO CHILDREN (LEFT AND RIGHT)  SO THE RIGHT CHILDREN TAKES REMOVENODE'S PLACE AND STARTS TO POINT TO THE
            // LEFT CHILDREN OF REMOVENODE
            else{
                 parentnode.left= removenode.right; //PARENTNODE POINTS TO THE RIGHT CHILD OF REMOVENODE
                 removenode.right.left= removenode.left; //RIGHT CHILD OF REMOVENODE POINTS TO THE LEFT CHILD (SUBTREE) OF REMOVENODE
            }

            return value;
        }
        else if(parentnode.right.key.equals(key)){
            Node<K,V> removenode = parentnode.right;
            value = removenode.value;

            //ONLY ONE CASE: THE RIGHT CHILD (TO BE REMOVED) HAS NO CHILDREN - SINCE INORDER TRAVERSAL, TREE WILL GROW ALWAYS TO THE LEFT
            parentnode.right= null;
            return value;
        }
      return null;
    }


    private Node<K, V> removeHelper(Node<K,V> node, K key) {
        if (node == null) return null;
        else if(node.key.equals(key)) return node; //case for root
        else if(node.left==null && node.right==null) {
            return null;
        }
        else if((node.left!=null && node.left.key.equals(key) || node.right!=null && node.right.key.equals(key))){
            return node;
        }

        else {
            Node<K, V> leftremove =removeHelper(node.left, key);
            if(leftremove!=null) return leftremove; //if it isn't null, then it means that they found the node with the same key.
            else{
                return removeHelper(node.right, key); //if it wasn't on the left, then it must be on the right, or there isn't a node
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




    private Node<K, V> lookupHelper(Node<K,V> node,K key) {
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
            System.out.println("(" + node.key + ", " + node.value + ")");
        }
        else{
            inOrderTraverse(node.left);
            System.out.println("(" + node.key + ", " + node.value + ")");
            inOrderTraverse(node.right);
        }
    }

}
