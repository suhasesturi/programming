package interviewbit.Trees;

import java.util.ArrayList;

public class ConstructBinaryTreeFromInOrderAndPreOrder {
    public TreeNode buildTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        return generate(preOrder, 0, preOrder.size(), inOrder, 0, inOrder.size());
    }

    private TreeNode generate(ArrayList<Integer> preOrder, int pStart, int pEnd,
                              ArrayList<Integer> inOrder, int iStart, int iEnd) {
        if (iStart >= iEnd) return null;
        int index = -1;
        for (int i = iStart; i < iEnd; i++) {
            if (inOrder.get(i).equals(preOrder.get(pStart))) {
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(preOrder.get(pStart));
        node.left = generate(preOrder, pStart + 1, pStart + 1 + index - iStart, inOrder, iStart, index);
        node.right = generate(preOrder, pStart + 1 + index - iStart, pEnd, inOrder, index + 1, iEnd);
        return node;
    }
}
