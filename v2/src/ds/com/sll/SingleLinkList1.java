package com.ds.sll;

import com.ds.node.Node;

public class SingleLinkList1 {
	private Node head;
	private int size;
	
	
	public void add(int data){
		Node newNode=new Node(data);
		
		if(head==null){
			head=newNode;
			size++;
		}else{
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=newNode;
			size++;
		}
	}
	
	public void show(){
		
	}
}
