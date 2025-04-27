# Binary Trees

This is a study on the implementation of Binary Trees on Java.
On this project I am using a Node class, which stores a <K> key and a <V> value as data,
as well as a left and a right pointer, that points to the node's children
(By definition Binary Trees have at most 2 children.) The tree follows
the In-order Traversal Pattern.

There are 4 main methods:

add: Adds a node to next empty space (In order traversal, so the order is left-root-right)

remove: remove  value of the node associated the key passed as argument for the method.

lookup: returns the value associated with the node that has the key 
passed as parameter.

inOrderTraverse: prints every <key, value> pair on the list,
following the inOrder traversal rules.