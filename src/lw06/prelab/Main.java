import java.util.Scanner;

public class Main {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data, null, null);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        } else if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        
        int rootString = sc.nextInt();
        Node binaryTree = new Node(rootString, null, null);

        String firstLine = sc.nextLine();
        for(String data : firstLine.trim().split(" ")){
            binaryTree = insert(binaryTree, Integer.parseInt(data));
        }

        int target = sc.nextInt();
        sc.close();
        
        System.out.print("Preorder  : ");
        preorder(binaryTree);
        System.out.println();

        System.out.print("Inorder   : ");
        inorder(binaryTree);
        System.out.println();

        System.out.print("Postorder : ");
        postorder(binaryTree);
        System.out.println();
        
        System.out.print("Search " + target + " : " + search(binaryTree, target));
    }
}