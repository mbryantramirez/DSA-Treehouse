package challenges.java.minimalheighttree;


import challenges.java.TreeNode;

public class MinimalHeightTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        printTreeInOrder(minimalHeight(arr));
    }

    private static TreeNode minimalHeight(int[] arr) {
        return addToTree(arr, 0, arr.length - 1);
    }

    private static TreeNode addToTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = end - start / 2;
        TreeNode middle = new TreeNode(arr[mid]);
        middle.left = addToTree(arr, start, mid - 1);
        middle.right = addToTree(arr, mid + 1, end);
        return middle;
    }

    private static void printTreeInOrder(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                printTreeInOrder(root.left);
            }
            System.out.println(root.data);
            if (root.right != null) {
                printTreeInOrder(root.right);
            }
        }
    }
}
