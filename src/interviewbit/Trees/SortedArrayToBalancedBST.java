package interviewbit.Trees;

import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBST {
    public static void main(String[] args) {
        TreeNode treeNode = new SortedArrayToBalancedBST().sortedArrayToBST(Arrays.asList(1, 2, 3));
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(final List<Integer> A) {
        return generate(A, 0, A.size());
    }

    private TreeNode generate(List<Integer> a, int start, int end) {
        if (start >= end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = generate(a, start, mid);
        node.right = generate(a, mid + 1, end);
        return node;
    }
}
