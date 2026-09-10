package binarytree;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryArray {
	//inorder root -> left -> right 
	public void inorder(int []arr,int p) {
		if(arr.length<=p) {
			return;
		}
		System.out.print(arr[p]+" ");
		inorder(arr,p*2+1);
		inorder(arr,p*2+2);
	}
	
	//preorder left -> root -> right
	public void preorder(int []arr,int p) {
		if(arr.length<=p) {
			return;
		}
		inorder(arr,p*2+1);
		System.out.print(arr[p]+" ");
		inorder(arr,p*2+2);
	}
	
	//postorder left -> right -> root
	public void postorder(int []arr,int p) {
		if(arr.length<=p) {
			return;
		}
		inorder(arr,p*2+1);
		inorder(arr,p*2+2);
		System.out.print(arr[p]+" ");
	}
	
	public void binaryTreeArray() {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("enter : ");
			arr[i]=in.nextInt();
		}
		//if we use sop(arr) then bu default java calls arr.toString() and default value for int arry is[I continued with identifier for array obj 
		System.out.println("Default :"+Arrays.toString(arr));
		System.out.println("Inorder traversal");
		inorder(arr,0);
		System.out.println("Preorder traversal");
		preorder(arr,0);
		System.out.println("Postorder traversal");
		postorder(arr,0);
	}
	
}
