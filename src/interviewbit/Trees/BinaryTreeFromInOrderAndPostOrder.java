package interviewbit.Trees;

import java.util.ArrayList;

public class BinaryTreeFromInOrderAndPostOrder {
    public TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder) {
        return generate(inOrder, 0, inOrder.size(), postOrder, 0, postOrder.size());
    }

    private TreeNode generate(ArrayList<Integer> inOrder, int iStart, int iEnd,
                              ArrayList<Integer> postOrder, int pStart, int pEnd) {
        if (iStart >= iEnd) return null;
        int index = -1;
        for (int i = iStart; i < iEnd; i++) {
            if (inOrder.get(i).equals(postOrder.get(pEnd - 1))) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(postOrder.get(pEnd - 1));
        node.left = generate(inOrder, iStart, index, postOrder, pStart, pStart + (index - iStart));
        node.right = generate(inOrder, index + 1, iEnd, postOrder, pStart + (index - iStart ), pEnd - 1);
        return node;
    }
}
