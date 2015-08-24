package com.ds.sll;

import com.ds.node.Node;

public class SingleLinkList {
	private Node head;
	private int size;
	
	public void add(int data){
		Node temp=new Node(data);
		if(head==null){
			head=temp;
			size++;
		}else{
			Node curr=head;
			while(curr.next!=null){
				curr=curr.next;
			}
			curr.next=temp;
			size++;
		}
	}

	public void show(){
		if(head==null){
			System.out.println(new RuntimeException("show: list is empty"));
			return;
		}else{
			Node temp=head;
			while(temp!=null){
				System.out.print(temp.data+"\t");
				temp=temp.next;
			}
		}
		System.out.println();
	}
	
	public int size(){
		return size;
	}
	
	public void add(int index,int data){
		Node newNode=new Node(data);
		if(index>size){
			System.out.println(new RuntimeException("add: index not exist"));
			return;
		}else{
			if(index==1){
				newNode.next=head;
				head=newNode;
				size++;
			}else{
				Node curr=head;
				Node prev=head;
				int i=1;
				while(i<index){
					prev=curr;
					curr=curr.next;
					i++;
				}
				prev.next=newNode;
				newNode.next=curr;
				size++;
			}
		}
	}
	
	public void remove(int data){
		if(head==null){
			System.out.println(new RuntimeException("remove: list is empty"));
			return;
		}else{
			Node curr=head;
			Node prev=head;
			int cntr=1;
			while(curr!=null){
				if(curr.data==data){
					break;
				}
				prev=curr;
				curr=curr.next;
				cntr++;
			}
			if(cntr==1){
				head=head.next;
				size--;
			}else{
				prev.next=curr.next;
				size--;
			}
		}
	}
	
	public void removeByIndex(int index){
		if(index>size){
			System.out.println(new RuntimeException("remove by index: out of index"));
			return;
		}else{
			if(index==1){
				head=head.next;
				size--;
			}else{
				int cntr=1;
				Node prev=head;
				Node curr=head;
				while(cntr<index){
					prev=curr;
					curr=curr.next;
					cntr++;
				}
				prev.next=curr.next;
				size--;
			}
		}
	}
	
	public void reverse(){
		Node temp=null;
		Node curr=null;
		
		while(head!=null){
			curr=head.next;
			head.next=temp;
			temp=head;
			head=curr;
		}
		head=temp;
	}
	
	public void merge(SingleLinkList sll){
		Node curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		curr.next=sll.head;
		size+=sll.size;
	}
	
	public void dispalyFromEnd(){
		if(head!=null){
			dispalyFromEnd(head);
		}
		System.out.println();
	}
	
	public void dispalyFromEnd(Node node){
		if(node!=null){
			dispalyFromEnd(node.next);
			System.out.print(node.data+"\t");
		}
	}
	
	public int getFromLast(int index){
		int newIndex=size-index;
		Node curr=head;
		while(newIndex>0){
			curr=curr.next;
			newIndex--;
		}
		return curr.data;
	}
	
	public int getMiddle(){
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	
	public boolean checkLoopExist(){
		
		Node slow=head;
		Node fast=head.next;
		while(true){
			if(fast==null || fast.next==null){
				return false;
			}else if(fast==slow || fast.next==slow){
				return true;
			}else{
				slow=slow.next;
				fast=fast.next.next;
			}
				
			
		}
	}
	
	public void createCircularLinkList(){
		Node curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		curr.next=head.next;
	}
	
	public int getLast3rdNode(){
		
		Node slow=head;
		Node fast=head.next.next;
		
		while(fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
		
		return slow.data;
	}
	public int getLast2ndNode(){
		
		Node slow=head;
		Node fast=head.next;
		
		while(fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
		
		return slow.data;
	}
	
	
}
