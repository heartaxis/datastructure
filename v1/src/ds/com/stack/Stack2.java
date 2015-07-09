package ds.com.stack;

import ds.com.sll.SllNode;

public class Stack2 {
	SllNode headNode;
	public Stack2(){
		headNode=null;
	}
	
	public void push(int data){
		SllNode newNode=new SllNode(data);
		if(headNode==null)
			headNode=newNode;
		else{
			newNode.setNext(headNode);
			headNode=newNode;
		}
	}
	
	public int top(){
		if(headNode==null)
			return 0;
		else
			return headNode.getData();		
	}
	
	public int pop(){
		int data=0;
		if(top()==0){
			System.out.println("stack is empty");
			return 0;
		}else{
			data=headNode.getData();
			headNode=headNode.getNext();
		}
		return data;
	}
	public void show(){
		SllNode curr=headNode;
		while(curr!=null){
			System.out.println(curr.getData());
			curr=curr.getNext();
		}
	}
	public boolean isEmpty(){
		if(headNode==null)
			return true;
		else
			return false;
	}
	
	public static Stack2 sortASC(Stack2 st){
		Stack2 st2=new Stack2();
		while(!st.isEmpty()){
			int tmp=st.pop();
			if(!st2.isEmpty() && st2.top()<tmp){
				st.push(st2.pop());
			}
			st2.push(tmp);
		}
		return st2;
	}
	
	public static Stack2 reverse(Stack2 st1){
		Stack2 st2=new Stack2();
		while(!st1.isEmpty()){
			int tmp=st1.pop();
			st2.push(tmp);
		}
		return st2;
	}
	public static void main(String[] args) {
		Stack2 st=new Stack2();
		//System.out.println(st.isEmpty());
	//	st.push(10);
		st.push(20);
		//st.push(1);
		st.push(80);
		st.push(11);
		//st.pop();
	//	st.pop();
		st.show();
		System.out.println("--------------");
		st=sortASC(st);
		st.show();
		System.out.println("---------------");
		st=reverse(st);
		st.show();
		//System.out.println(st.isEmpty());
	}
}
