public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        System.out.println(binaryTree.add(1, "1"));
        binaryTree.add(2,"2");
        binaryTree.add(3, "3");
        binaryTree.add( 4,  "4");
        binaryTree.add(5,"5");
        binaryTree.add(6, "6");
        binaryTree.add(7, "7");
        binaryTree.add(8, "8");
        binaryTree.add(9, "9");
        binaryTree.add(10, "10");
        binaryTree.add(11, "11");
        binaryTree.add(12, "12");
        binaryTree.add(13, "13");
        binaryTree.remove(1);
        binaryTree.add(1, "1");
        binaryTree.remove(2);
        binaryTree.add(2, "2");
        binaryTree.remove(6);
        binaryTree.remove(10);
        binaryTree.remove(9);

        System.out.println(binaryTree.remove(1));
        binaryTree.add(1, "1");
        binaryTree.add(14, "14");
        binaryTree.add(15,"15");
        binaryTree.remove(1);
        binaryTree.remove(3);
        System.out.println(binaryTree.lookup(8));
        binaryTree.inOrderTraverse(binaryTree.getRoot());


    }
}