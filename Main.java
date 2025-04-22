public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();

        binaryTree.add( 1,  "1");
        binaryTree.add(2,"2");
        binaryTree.add(3, "3");
        binaryTree.add(4, "4");
        binaryTree.add(5, "5");
        binaryTree.add(6, "6");
        binaryTree.inOrderTraverse(binaryTree.getRoot());

    }
}