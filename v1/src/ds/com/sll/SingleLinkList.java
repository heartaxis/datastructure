package ds.com.sll;

public class SingleLinkList2 {

	public static int size(SllNode head){
		int cntr=0;
		if(head==null)
			return 0;
		else{
			while(head!=null){
				head=head.getNext();
				cntr++;
			}			
		}
		return cntr;
	}
	
	public static SllNode add(SllNode head,int data,int pos){
		SllNode newnode=new SllNode(data);
		if(head==null)
			return newnode;
		else{
			int size=size(head);
			if(pos==1){
				newnode.setNext(head);
				return newnode;
			}else if(pos>1 && pos<=size){
				SllNode curr=head;
				SllNode prev=head;
				int cntr=1;
				while(cntr<pos){
					prev=curr;
					curr=curr.getNext();
					cntr++;
				}
				prev.setNext(newnode);
				newnode.setNext(curr);
			}
		}
		return head;
	}
	
	public static void display(SllNode head){
		if(head==null)
			System.out.println("list is empty");
		else{
			while(head!=null){
				System.out.print(head.getData()+"\t");
				head=head.getNext();
			}
		}
		System.out.println();
	}
	
	public static SllNode addByData(SllNode head,int data){
		SllNode newNode=new SllNode(data);
		if(head==null)
			return newNode;
		else{
			SllNode curr=head;
			while(curr.getNext()!=null){
				curr=curr.getNext();
			}
			curr.setNext(newNode);
		}
		return head;
	}
	public static SllNode delete(SllNode head,int pos){
		if(head==null)
			return head;
		else{
			int size=size(head);
			if(pos==1){
				return head.getNext();
			}else if(pos>1 && pos<=size){
				int cntr=1;
				SllNode curr=head;
				SllNode prev=head;
				while(cntr<pos){
					prev=curr;
					curr=curr.getNext();
					cntr++;
				}
				prev.setNext(curr.getNext());
				curr=null;
			}else{
				System.out.println("invalid pos");
			}
		}
		return head;
	}
	
	public static SllNode deleteByData(SllNode head,int data){
		if(head==null){
			return head;
		}else{
			int size=size(head);
			int cntr=1;
			boolean flag=false;
			SllNode curr=head;
			SllNode prev=head;
			while(curr!=null){
				if(curr.getData()==data){
					flag=true;
					break;
				}
				cntr++;
				prev=curr;
				curr=curr.getNext();
			}
			if(flag){
				if(cntr==1){
					return head.getNext();
				}else{
					prev.setNext(curr.getNext());
					curr=null;
				}
			}else{
				System.out.println("data not exist");
			}
		}
		return head;
	}
	
	public static SllNode reverse(SllNode head){
		SllNode temp=null;
		SllNode curr=null;
		if(head==null)
			return head;
		else{
			while(head!=null){
				curr=head.getNext();
				head.setNext(temp);
				temp=head;
				head=curr;
			}
		}
		return temp;
	}
	
	public static SllNode merge(SllNode sll1,SllNode sll2){
		if(sll1==null)
			return sll2;
		if(sll2==null)
			return sll1;
		SllNode curr=sll1;
		while(curr.getNext()!=null)
			curr=curr.getNext();
		curr.setNext(sll2);
		return sll1;
	}
	
	public static SllNode sortedMerge(SllNode sll1,SllNode sll2){
		SllNode temp=null;
		if(sll1==null)
			return sll2;
		if(sll2==null)
			return sll1;
		if(sll1.getData()<sll2.getData()){
			temp=sll1;
			temp.setNext(sortedMerge(sll1.getNext(), sll2));
		}else{
			temp=sll2;
			temp.setNext(sortedMerge(sll2.getNext(), sll1));
		}
		return temp;
	}
	
	public static void displayFromLast(SllNode head){
		if(head!=null){
			displayFromLast(head.getNext());
			System.out.print(head.getData()+"\t");
		}
	}
	public static SllNode findNthNodeFrmlast(SllNode head,int pos){
		if(head==null)
			return head;
		else{
			int size=size(head);
			int newPos=size-pos;
			int cntr=0;
			while(cntr<newPos){
				head=head.getNext();
				cntr++;
			}
		}
		return head;
	}
	public static SllNode findNthNodeFrmlastOneItr(SllNode head,int pos){
		SllNode tempArr[]=new SllNode[100];
		int newpos=0;
		if(head==null)
			return head;
		else{
			int cntr=0;
			while(head!=null){
				tempArr[cntr]=head;
				cntr++;
				head=head.getNext();
			}
			newpos=cntr-pos;
		}
		return tempArr[newpos];
			
	}
	
	public static SllNode findMiddleNode(SllNode head){
		int size=size(head);
		int newSize=size/2;
		int cntr=0;
		while(cntr<newSize){
			head=head.getNext();
			cntr++;
		}
		return head;
	}
	
	public static SllNode findMiddleNodeOneItr(SllNode head){
		SllNode slow=head;
		SllNode fast=head;
		while(fast.getNext()!=null){
			slow=slow.getNext();
			fast=fast.getNext();
			if(fast.getNext()!=null)
				fast=fast.getNext();
		}
		return slow;
	}
	
	public static boolean checkLoop(SllNode head){
		SllNode slow=head;
		SllNode fast=head;
		while(slow!=null && fast!=null){
			fast=fast.getNext();
			if(slow==fast){
				return true;
			}
			if(fast==null)
				return false;
			fast=fast.getNext();
			if(slow==fast)
				return true;
			
			slow=slow.getNext();
		}
		return false;
	}
	
//	public static SllNode reversePair(SllNode head){
//		SllNode newRoot=null;
//		SllNode buffer=null;
//		while(head!=null && head.getNext()!=null){
//			if(buffer!=null){
//				buffer.getNext().setNext(head.getNext());
//			}
//			buffer=head.getNext();
//			head.setNext(head.getNext().getNext());
//			buffer.setNext(head);
//			if(newRoot==null)
//				newRoot=buffer;
//			head=head.getNext();
//		}
//		return newRoot;
//	}
	
	public static SllNode reversePair(SllNode head)
	{
		SllNode buffer=null;
		SllNode temp=null;
		while(head!=null && head.getNext()!=null){
			if(buffer!=null){
				buffer.getNext().setNext(head.getNext());
			}
			
			buffer=head.getNext();
			head.setNext(head.getNext().getNext());
			buffer.setNext(head);
			if(temp==null)
				temp=buffer;	
			head=head.getNext();
		}
		return temp;
	}
	
	
	public static void main(String[] args) {
		SllNode sll1=new SllNode(8);
		SllNode sll2=new SllNode(9);
		sll1=addByData(sll1, 12);
		sll2=addByData(sll2, 23);
		sll1=add(sll1, 20, 1);
		sll1=add(sll1, 10, 2);
		sll1=add(sll1, 33, 2);
		sll1=add(sll1, 21, 2);
		sll1=add(sll1, 67, 2);
		sll1=add(sll1, 44, 2);
		sll1=add(sll1, 45, 2);
		display(sll1);
		sll1=delete(sll1, 1);
		sll1=delete(sll1, 3);
		sll1=deleteByData(sll1, 45);
		display(sll1);
		sll1=reverse(sll1);
		display(sll1);
		display(sll2);
		//sll1=merge(sll1, sll2);
		sll1=sortedMerge(sll1, sll2);
		display(sll1);
		//displayFromLast(sll1);
		//System.out.println();
		System.out.println("findNthNodeFrmlast-->"+findNthNodeFrmlast(sll1,2).getData());
		System.out.println("findNthNodeFrmlastOneItr-->"+findNthNodeFrmlastOneItr(sll1,2).getData());
		System.out.println("findMiddleNode-->"+findMiddleNode(sll1).getData());
		System.out.println("findMiddleNodeOneItr-->"+findMiddleNodeOneItr(sll1).getData());
		System.out.println("checkLoop-->"+checkLoop(sll1));
		System.out.println(size(sll1));
		display(sll1);
		sll1=reversePair(sll1);
		display(sll1);
	}
}
