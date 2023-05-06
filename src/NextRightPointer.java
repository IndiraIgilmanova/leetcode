

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};



class NextRightPointer {
    public Node connect(Node root) {
        //if(root!=null)
        //root.next = null;
        Node ans = root;


        if(root!=null){
            Node next = root.next;
            if(root.left!=null){
                if(root.right!=null)
                    root.left.next = root.right;
                else{
                    while(next!=null){
                        if(next.left!=null){
                            root.left.next = next.left;
                            break;
                        }
                        else if(next.right!=null){
                            root.left.next = next.right;
                            break;
                        }
                        next = next.next;

                    }
                }
            }
            if(root.right!=null){
                if(root.next == null)
                    root.right.next = null;
                else{
                    while(next!=null){
                        if(next.left!=null){
                            root.right.next = next.left;
                            break;
                        }
                        else if(next.right!=null){
                            root.right.next = next.right;
                            break;
                        }
                        next = next.next;
                    }
                }
            }

            connect(root.right);
            connect(root.left);
        }
        return ans;
    }
}