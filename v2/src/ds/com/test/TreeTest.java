package com.ds.test;

import com.ds.tree.Tree;

public class TreeTest {
	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.put(100);
		tree.put(150);
		tree.put(50);
		tree.put(25);
		tree.put(75);
		tree.put(200);
		tree.put(125);
		tree.preorder();
		tree.inorder();
		tree.postorder();
		System.out.println(tree.max());
		System.out.println(tree.min());
		System.out.println(tree.size());
	}
}
