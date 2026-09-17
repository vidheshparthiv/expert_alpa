package binarytree.btwithNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	public void binaryTree() {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		BinaryTreeNode root=null;
		for(int i=0;i<n;i++) {
			System.out.print("enter: ");
			int val=in.nextInt();
			root=BinaryTree.insert(root,val);
		}
		System.out.println("pre :");
		preOrder(root);
		System.out.println("\nin: ");
		postOrder(root);
		System.out.println("\npost: ");
		inOrder(root);
		
	}
	static BinaryTreeNode insert(BinaryTreeNode root,int val){
	    BinaryTreeNode newNode = new BinaryTreeNode(val);
	    if(root==null) {
	        return newNode;
	    }
	    Queue<BinaryTreeNode> queue=new LinkedList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        BinaryTreeNode current=queue.remove();
	        if (current.left==null) {
	            current.left = newNode;
	            return root;
	        } else {
	            queue.add(current.left);
	        }
	        if (current.right==null) {
	            current.right=newNode;
	            return root;
	        } else {
	            queue.add(current.right);
	        }
	    }

	    return root;
	}
	
	public void preOrder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);	
	}
	
	public void inOrder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);	
	}
	
	public void postOrder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);	
		System.out.print(root.val+" ");
	}
	public void levelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode>queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode cur=queue.remove();
			System.out.print(cur.val+" ");
			if(cur.left!=null){
				queue.add(cur.left);
			}
			if(cur.right!=null) {
				queue.add(cur.right);
			}
		}
	}
	
	public int countNoOfNodes(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		return 1+countNoOfNodes(root.left)+countNoOfNodes(root.right);
	}
}

