// Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

// serialize() : stores the tree into an array a and returns the array.
// deSerialize() : deserializes the array to the tree and returns the root of the tree.
// Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    ArrayList<Integer> A = new ArrayList<>();

    public ArrayList<Integer> serialize(Node root) {
        // Clear the list before serializing
        A.clear();
        serializeHelper(root);
        return A;
    }

    private void serializeHelper(Node root) {
        if (root == null) {
            A.add(-1);
            return;
        }
        A.add(root.data);
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        if (A.size() == 0)
            return null;
        int a = A.remove(0);
        if (a == -1)
            return null;
        Node root = new Node(a);
        root.left = deSerialize(A);
        root.right = deSerialize(A);
        return root;
    }
};
