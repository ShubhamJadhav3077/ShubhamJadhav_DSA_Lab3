package problem2.binaryTreeSum;

import java.util.ArrayList;
import java.util.Scanner;

public class HardCodedBinarySearchTree {
	static ArrayList<Integer> nodeList = new ArrayList<>();

	public static void main(String[] args) {
		Node root = null;
		Node temporaryNode;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes: ");
		int size = sc.nextInt();
		for (int i = 1; i <= size; i++) {
			System.out.println("Enter data for Node" + i + ":");
			int data = sc.nextInt();
			nodeList.add(data);
			temporaryNode = new Node(data);
			if (root == null) {
				root = temporaryNode;
			} else {
				insert(root, temporaryNode);
			}
		}

		System.out.println("Select the order in which you want to view the data");
		System.out.println("1. Inorder");
		System.out.println("2. Preorder");
		System.out.println("3. Postorder");
		int order = sc.nextInt();
		TreeTraversal binaryTreeObject = new TreeTraversal();
		switch (order) {
		case 1:
			System.out.println("Data in Inorder format");
			binaryTreeObject.inOrder(root);
			break;
		case 2:
			System.out.println("Data in Preorder format");
			binaryTreeObject.preOrder(root);
			break;
		case 3:
			System.out.println("Data in Postorder format");
			binaryTreeObject.postOrder(root);
			break;
		}
		System.out.println("");
		System.out.println("ArrayListFormat" + nodeList);
		System.out.println("Enter the sum to find the pair");
		int sum = sc.nextInt();
		pairCheck(nodeList, nodeList.size(), sum);
		sc.close();
	}

	public static boolean pairCheck(ArrayList<Integer> nodeList, int size, int sum) {
		for (int i = 0; i < (size - 1); i++) {
			for (int j = i + 1; j < size; j++) {
				if (nodeList.get(i) + nodeList.get(j) == sum) {
					System.out.println("Pair Found:" + "(" + nodeList.get(i) + "," + nodeList.get(j) + ")");
					return true;
				}
			}
		}
		System.out.println("Pair NOT FOUND");
		return false;

	}

	private static void insert(Node root, Node temporaryNode) {
		if (temporaryNode.data > root.data) {
			if (root.right == null) {
				root.right = temporaryNode;
			} else {
				insert(root.right, temporaryNode);
			}
		} else {
			if (root.left == null) {
				root.left = temporaryNode;
			} else {
				insert(root.left, temporaryNode);
			}
		}

	}

}
