package interviewbit.Trees;


import java.util.ArrayList;

public class LeastCommonAncestor {

    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        if (!findPath(A, B, path1) || !findPath(A, C, path2)) return -1;
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) break;
        }
        return path1.get(i - 1);
    }

    private boolean findPath(TreeNode root, int n, ArrayList<Integer> path) {
        if (root == null) return false;
        path.add(root.val);

        if (root.val == n) return true;
        if (findPath(root.left, n, path)) return true;
        if (findPath(root.right, n, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }
}
