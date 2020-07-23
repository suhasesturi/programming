package interviewbit.Trees;

import java.util.ArrayList;

public class InOrderTraversalOfCartesianTree {
    public TreeNode buildTree(ArrayList<Integer> A) {
        return generate(A, 0, A.size());
    }

    private TreeNode generate(ArrayList<Integer> nodes, int start, int end) {
        if (start == end) return null;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i < end; i++) {
            if (max < nodes.get(i)) {
                max = nodes.get(i);
                index = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = generate(nodes, start, index);
        node.right = generate(nodes, index + 1, end);
        return node;
    }
}
