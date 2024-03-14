// Given a Binary Tree of size n, find all the nodes that don't have any siblings. You need to return a list of integers containing all the nodes that don't have a sibling in sorted order.

// Two nodes are said to be siblings if they are present at the same level, and their parents are the same.

// Note: The root node can not have a sibling so it cannot be included in our answer.

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        if(node==null) return list;
        
        helperSib(node,list);
        
        if(list.isEmpty()) list.add(-1);
        Collections.sort(list);
        return list;
        
    }
    void helperSib(Node node,ArrayList<Integer> list){
        if(node==null) return;
        
        if(node.left!=null && node.right==null) list.add(node.left.data);
        else if(node.right!=null && node.left==null) list.add(node.right.data);
        
        helperSib(node.left,list);
        helperSib(node.right,list);
    }
}