package ds.com.sll;

public class SllNode {
	private int data;
	private SllNode next;
	public SllNode(int data){
		this.data=data;
	}
	
	public void setData(int data){
		this.data=data;
	}
	public int getData(){
		return this.data;
	}
	public void setNext(SllNode next){
		this.next=next;
	}
	public SllNode getNext(){
		return this.next;
	}
}

