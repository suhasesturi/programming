package interviewbit.Trees;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generate(A, B, result, new ArrayList<>());
        return result;
    }

    private void generate(TreeNode node, int b, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (node == null) return;
        path.add(node.val);

        if (node.left == null && node.right == null && node.val == b) {
            result.add(new ArrayList<>(path));
        }
        generate(node.left, b - node.val, result, path);
        generate(node.right, b - node.val, result, path);
        path.remove(path.size() - 1);
    }
}
