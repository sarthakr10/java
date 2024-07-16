import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class BinaryTree {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    
    public TreeNode createBinaryTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode currentNode = queue.poll();
            if (arr[i] != null) {
                currentNode.left = new TreeNode(arr[i]);
                queue.add(currentNode.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                currentNode.right = new TreeNode(arr[i]);
                queue.add(currentNode.right);
            }
            i++;
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the level-order traversal of the binary tree (use 'null' for missing nodes):");
        String input = scanner.nextLine();
        scanner.close();

        String[] inputArray = input.split(" ");
        Integer[] levelOrder = new Integer[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals("null")) {
                levelOrder[i] = null;
            } else {
                levelOrder[i] = Integer.parseInt(inputArray[i]);
            }
        }

        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.createBinaryTree(levelOrder);

        System.out.println("The maximum depth of the binary tree is: " + tree.maxDepth(root));
    }
}
