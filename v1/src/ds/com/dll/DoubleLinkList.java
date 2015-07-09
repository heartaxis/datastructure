package ds.com.dll;

import ds.com.sll.SllNode;

public class DoubleLinkList2 {
	public static  DLLNode currentNode;

	public static int size(DLLNode head){
		int cntr=0;
		if(head==null)
			return 0;
		else{
			while(head!=null){
				cntr++;
				head=head.getNext();
			}
		}
		return cntr;
	}
	
	public static DLLNode add(DLLNode head,int data,int pos){
		DLLNode newNode=new DLLNode(data);
		if(head==null){
			return head;
		}else{
			int size=size(head);
			if(pos==1){
				newNode.setPrev(null);
				newNode.setNext(head);
				head.setPrev(newNode);
				return newNode;
			}else if(pos>1 && pos<=size){
				int cntr=1;
				DLLNode prev=head;
				DLLNode curr=head;
				while(cntr<pos){
					prev=curr;
					curr=curr.getNext();
					cntr++;
				}
				prev.setNext(newNode);
				newNode.setPrev(prev);
				newNode.setNext(curr);
				curr.setPrev(newNode);
			}else{
				System.out.println("invalid pos");
			}
		}
		return head;
	}
	public static void display(DLLNode head){
		if(head==null){
			System.out.println("list is empty");
		}else{
			while(head!=null){
				System.out.print(head.getData()+"\t");
				head=head.getNext();
			}
		}
		System.out.println();
	}
	
	public static DLLNode addByData(DLLNode head,int data){
		DLLNode newNode=new DLLNode(data);
		if(head==null)
			return head;
		else{
			DLLNode curr=head;
			while(curr.getNext()!=null){
				curr=curr.getNext();
			}
			curr.setNext(newNode);
			newNode.setPrev(curr);
			newNode.setNext(null);
		}
		return head;
	}
	
	public static DLLNode delete(DLLNode head,int pos){
		if(head==null)
			return head;
		else{
			int size=size(head);
			if(pos==1){
				head=head.getNext();
				head.setPrev(null);
				return head;
			}else if(pos>1 && pos<=size){
				int cntr=1;
				DLLNode prev=head;
				DLLNode curr=head;
				while(cntr<pos){
					prev=curr;
					curr=curr.getNext();
					cntr++;
				}
				prev.setNext(curr.getNext());
				if(curr.getNext()!=null)
					curr.getNext().setPrev(prev);
			}
		}
		return head;
	}
	
	
	public static DLLNode deleteByData(DLLNode head,int data){
		if(head==null)
			return head;
		else{
			int cntr=1;
			DLLNode curr=head;
			DLLNode prev=head;
			boolean flag=false;
			while(curr!=null){
				if(curr.getData()==data){
					flag=true;
					break;
				}
				prev=curr;
				curr=curr.getNext();
				cntr++;
			}
			if(flag){
				if(cntr==1){
					head=head.getNext();
					head.setPrev(null);
					return head;
				}else{
					prev.setNext(curr.getNext());
					if(curr.getNext()!=null)
						curr.getNext().setPrev(prev);
				}
			}else{
				System.out.println("invalid data");
			}
		}
		return head;
	}
	
	public static DLLNode reverse(DLLNode head){
		DLLNode temp=null;
		DLLNode curr=null;
		if(head==null)
			return head;
		else{

			while(head!=null){
				curr=head.getNext();
				head.setNext(temp);
				head.setPrev(null);
				temp=head;
				head=curr;
			}
		}
		return temp;		
	}
	
	public static DLLNode merge(DLLNode dll1,DLLNode dll2){
		if(dll1==null)
			return dll2;
		if(dll2==null)
			return dll1;
		DLLNode curr=dll1;
		while(curr.getNext()!=null)
			curr=curr.getNext();
		curr.setNext(dll2);
		dll2.setPrev(curr);
		return dll1;
	}
	
	public static void displayFrmLast(DLLNode head){
		if(head!=null){
			displayFrmLast(head.getNext());
			System.out.print(head.getData()+"\t");
		}
	}
	
	public static DLLNode findNthNodeFromLast(DLLNode head,int pos){
		int size=size(head);
		int newpos=size-pos;
		int cnt=0;
		while(cnt<newpos){
			head=head.getNext();
			cnt++;
		}
		return head;
	}
	
	public static DLLNode findNthNodeFromLastOneItr(DLLNode head,int pos){
		DLLNode arr[]=new DLLNode[100];
		int cntr=0;
		while(head!=null){
			arr[cntr++]=head;
			head=head.getNext();
		}
		int newpos=cntr-pos;
		return arr[newpos];
	}
	
	public static DLLNode findMiddle(DLLNode head){
		int size=size(head);
		int newsize=size/2+1;
		int cntr=1;
		while(cntr<newsize){
			head=head.getNext();
			cntr++;
		}
		return head;
	}
	
	public static DLLNode findmiddleOneItr(DLLNode head){
		DLLNode slow=head;
		DLLNode fast=head;
		while(fast.getNext()!=null){
			slow=slow.getNext();
			fast=fast.getNext();
			if(fast.getNext()!=null)
				fast=fast.getNext();
		}
		return slow;
	}
	
	public static DLLNode convertBST(DLLNode head){
		if(head==null)
			return head;
		int size=size(head);
		currentNode=head;
		return convertToBST(0,size-1);
	}
	public static DLLNode convertToBST(int start,int end){
		if(start>end)
			return null;
		int mid=(start+end)/2;
		DLLNode left=convertToBST(0, mid-1);
		currentNode.setPrev(left);
		DLLNode thisNode=currentNode;
		currentNode=currentNode.getNext();
		DLLNode right=convertToBST(mid+1, end);
		thisNode.setNext(right);
		return thisNode;
		
	}
	
	public static void main(String[] args) {
		DLLNode dll1=new DLLNode(10);
		DLLNode dll2=new DLLNode(11);
		dll1=add(dll1, 20, 1);
		dll1=add(dll1, 12, 2);
		dll1=addByData(dll1, 19);
		dll2=addByData(dll2, 88);
		dll2=addByData(dll2, 23);

		dll2=addByData(dll2, 85);
		dll2=addByData(dll2, 98);
		dll1=deleteByData(dll1, 12);
		
		System.out.println("size--->"+size(dll1));
		display(dll1);
		dll1=reverse(dll1);
		display(dll1);
		display(dll2);
		dll1=merge(dll1,dll2);
		display(dll1);
	//	displayFrmLast(dll1);
		System.out.println("\nfindNthNodeFromLast-->"+findNthNodeFromLast(dll1,7).getData());
		System.out.println("findNthNodeFromLastOneItr-->"+findNthNodeFromLastOneItr(dll1,7).getData());
		System.out.println("findMiddle-->"+findMiddle(dll1).getData());
		System.out.println("findmiddleOneItr-->"+findmiddleOneItr(dll1).getData());
	}
}
