package com.ds.tree;

import com.ds.node.TreeNode;

public class Tree {
	private TreeNode root;
	
	public void put(int data){
		root=put(root,data);
	}
	public TreeNode put(TreeNode currentRoot,int data){
		if(currentRoot ==null){
			TreeNode tNode=new TreeNode(data);
			return tNode;
		}
		
		if(data<currentRoot.data){
			currentRoot.left=put(currentRoot.left,data);
		}else if(data>currentRoot.data){
			currentRoot.right=put(currentRoot.right,data);
		}else if(data==currentRoot.data){
			currentRoot.data=data;
		}
		return currentRoot;
	}
	
	public void preorder(){
		preorder(root);
		System.out.println();
	}
	public void preorder(TreeNode currentRoot){
		if(currentRoot!=null){
			System.out.print(currentRoot.data+"\t");
			preorder(currentRoot.left);
			preorder(currentRoot.right);
		}
	}
	
	public void inorder(){
		inorder(root);
		System.out.println();
	}
	
	public void inorder(TreeNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data+"\t");
			inorder(root.right);
		}
	}
	
	public void postorder(){
		postorder(root);
		System.out.println();
	}
	
	public void postorder(TreeNode root){
		if(root!=null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	public int max(){
		TreeNode curr=root;
		while(true){
			curr=curr.right;
			if(curr.right==null){
				break;
			}
		}
		return curr.data;
	}
	
	public int min(){
		TreeNode curr=root;
		while(true){
			curr=curr.left;
			if(curr.left==null){
				break;
			}
		}
		return curr.data;
	}
	
	public int size(){
		return size(root);
	}
	
	public int size(TreeNode currNode){
		if(currNode==null){
			return 0;
		}
		return (size(currNode.left)+1+size(currNode.right));
	}
}
