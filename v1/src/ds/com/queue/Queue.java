package ds.com.queue;

import ds.com.sll.SllNode;
import ds.com.stack.Stack2;

public class Queue {
	SllNode front;
	SllNode rear;
	Queue(){
		front=null;
		rear=null;
	}
	
	public boolean isEmpty(){
		if(front==null)
			return true;
		else
			return false;
	}
	public void enQueue(int data){
		SllNode newnode=new SllNode(data);
		if(rear!=null){
			rear.setNext(newnode);
		}
		rear=newnode;
		if(front==null)
			front=rear;
	}
	
	public int deQueu(){
		int data=0;
		if(isEmpty()){
			System.out.println("queue is empty");
			return 0;
		}else{
			data=front.getData();
			front=front.getNext();
		}
		return data;
	}
	
	public static Queue reverse(Queue q){
		Stack2 st=new Stack2();
		while(!q.isEmpty()){
			st.push(q.deQueu());
		}
		while(!st.isEmpty()){
			q.enQueue(st.pop());
		}
		return q;
	}
	public static void main(String[] args) {
		Queue q=new Queue();
		q.enQueue(20);
		q.enQueue(22);
		q.enQueue(90);
		q.enQueue(12);
		q=reverse(q);
		System.out.println(q.deQueu());
		System.out.println(q.deQueu());
	}
}
