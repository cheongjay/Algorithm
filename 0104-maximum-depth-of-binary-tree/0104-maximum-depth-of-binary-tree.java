class Solution {
    int h = 0;
    public int maxDepth(TreeNode root) {

        int answer = -1;

        DFS(1, root);
        return h;
    }

    public void DFS(int height, TreeNode p){
        if(p == null){
            return;
        }

        if(h < height){
            h = height;
        }
        if(p.left != null){
            DFS(height + 1, p.left);
        }
        if(p.right != null){
            DFS(height + 1, p.right);
        }
    }

}