/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        
        if(!(root.left == null && root.right == null)) ans.add(root.data);
        
        Node curr = root.left;
        
        while(curr != null){
            
            if(!(curr.left == null && curr.right == null)) {
                ans.add(curr.data);
            }
            
            if(curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        
        leaf(root, ans);
        
        if(root.right != null) rightNodes(root.right, ans);
        
        return ans;
    }
    
    public void leaf(Node root, ArrayList<Integer> ans){
        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }
        
        if(root.left != null) leaf(root.left, ans);
        if(root.right != null) leaf(root.right, ans);
    }
    
    public void rightNodes(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        
        if(root.right == null && root.left == null) return;
        
        if(root.right != null) rightNodes(root.right, ans);
        else rightNodes(root.left, ans);
        
        ans.add(root.data);
    }
}