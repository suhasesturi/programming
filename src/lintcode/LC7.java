package lintcode;

import java.util.Arrays;
import java.util.LinkedList;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class LC7 {
    public String serialize(TreeNode root) {
        StringBuffer stringBuffer = serializeHelper(root, new StringBuffer());
        return stringBuffer.toString();
    }

    private StringBuffer serializeHelper(TreeNode root, StringBuffer stringBuffer) {
        if (root == null) return stringBuffer;
        stringBuffer.append(root.val).append(" ");
        stringBuffer.append(root.left == null ? "-1 " : serializeHelper(root.left, new StringBuffer()));
        stringBuffer.append(root.right == null ? "-1 " : serializeHelper(root.right, new StringBuffer()));
        return stringBuffer;
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> arr =  new LinkedList<>(Arrays.asList(data.split(" ")));
        return deserializeHelper(arr);
    }

    private TreeNode deserializeHelper(LinkedList<String> arr) {
        if (arr.isEmpty() || arr.peek().isEmpty()) return null;
        int value = Integer.parseInt(arr.pollFirst());
        if (value == -1) return null;
        TreeNode root = new TreeNode(value);
        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);
        return root;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(20);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(10);
        TreeNode t6 = new TreeNode(14);

        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t4.left = t5;
        t4.right = t6;

        LC7 obj = new LC7();
        String result = obj.serialize(null);
        System.out.println(result);
        TreeNode a = obj.deserialize(result);
        System.out.println(obj.serialize(a));
    }
}