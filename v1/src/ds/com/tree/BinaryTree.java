package ds.com.tree;

public class BinaryTree {

	public void insert(BTNode root,int data){
		if(data<root.getData()){
			if(root.getLeft()!=null){
				insert(root.getLeft(), data);
			}else{
				root.setLeft(new BTNode(data));
				System.out.println("inserted left:"+data);
			}
		}else if(data>root.getData()){
			if(root.getRight()!=null){
				insert(root.getRight(), data);
			}else{
				root.setRight(new BTNode(data));
				System.out.println("inserted right:"+data);
			}
		}
	}
	
	public void preorder(BTNode root){
		if(root!=null){
			System.out.print(root.getData()+"\t");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	
	public void inorder(BTNode root){
		if(root!=null){
			inorder(root.getLeft());
			System.out.print(root.getData()+"\t");
			inorder(root.getRight());
		}
	}
	
	public void postorder(BTNode root){
		if(root!=null){
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.print(root.getData()+"\t");
		}
	}
	
	public int size(BTNode root){
		if(root==null)
			return 0;
		return (size(root.getLeft())+1+size(root.getRight()));
	}
	
	public int maxData(BTNode root){
		int max=0;
		int ldata,rdata,rootData=0;
		if(root!=null){
			
			rootData=root.getData();
			ldata=maxData(root.getLeft());
			rdata=maxData(root.getRight());
			if(ldata>rdata)
				max=ldata;
			else
				max=rdata;
			
			if(rootData>max)
				max=rootData;
		}
		return max;
	}
	
	public boolean findNode(BTNode root,int data){
		boolean flag=false,lflag,rflag,rootflag;
		
		if(root!=null){
			if(data==root.getData()){
				rootflag=true;
			}else{
				rootflag=false;
			}
			
			lflag=findNode(root.getLeft(), data);
			rflag=findNode(root.getRight(), data);
			
			if(lflag || rflag){
				flag=true;
			}else{
				flag=false;
			}
			if(rootflag){
				flag=true;
			}
		}
		return flag;
	}
	
	public int height(BTNode root){
		int lheight,rheight;
		if(root==null)
			return 0;
		lheight=1+height(root.getLeft());
		rheight=1+height(root.getRight());
		
		if(lheight>rheight)
			return lheight;
		else
			return rheight;
	}
	
	public int sumOfAllNodes(BTNode root){
		if(root==null)
			return 0;
		return (root.getData()+sumOfAllNodes(root.getLeft())+sumOfAllNodes(root.getRight()));
	}
	
	public int leastheight(BTNode root){
		int lheight,rheight;
		if(root==null)
			return 0;
		lheight=1+leastheight(root.getLeft());
		rheight=1+leastheight(root.getRight());
		
		if(lheight>rheight)
			return rheight;
		else
			return lheight;
	}
	public int diameter(BTNode root,int diameter){
		int left,right,max=0;
		if(root==null)return 0;
		left=diameter(root.getLeft(), diameter);
		right=diameter(root.getRight(), diameter);
		if(left+right>diameter)
			diameter=left+right;
		return Math.max(left, right)+1;
		
	}
	public void printPaths(BTNode root){
		int path[]=new int[256];
		printPaths(root,path,0);
	}
	public void printPaths(BTNode root,int[] path,int pathLen){
		if(root==null)return;
		path[pathLen]=root.getData();
		pathLen++;
		if(root.getLeft()==null && root.getRight()==null){
			printArr(path,pathLen);
		}else{
			printPaths(root.getLeft(), path, pathLen);
			printPaths(root.getRight(), path, pathLen);
		}
	}
	
	public void printArr(int[] ints,int len){
		for(int i=0;i<len;i++){
			System.out.print(ints[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BTNode root=new BTNode(50);
		BinaryTree btree=new BinaryTree();
		btree.insert(root, 20);
		btree.insert(root, 90);
		
		btree.insert(root, 45);
		btree.insert(root, 12);
		btree.insert(root, 100);
		btree.insert(root, 85);
		btree.insert(root, 110);
		
//		btree.insert(root, 150);
//		btree.insert(root, 70);
//		
//		btree.insert(root, 130);
//		btree.insert(root, 60);
//		
//		btree.insert(root, 55);
//		btree.insert(root, 65);
		
		btree.inorder(root);
		System.out.println();
		System.out.println("least height-->"+btree.leastheight(root));
		System.out.println("max height--->"+btree.height(root));
		/*btree.insert(root, 1);
		btree.insert(root, 3);
		btree.preorder(root);
		System.out.println();
		btree.inorder(root);
		System.out.println();
		btree.postorder(root);
		System.out.println();
		System.out.println("size-->"+btree.size(root));
		System.out.println("max data->"+btree.maxData(root));
		System.out.println("find node--->"+btree.findNode(root, 178));
		System.out.println("height--->"+btree.height(root));
		System.out.println("sum of all nodes-->"+btree.sumOfAllNodes(root));
		*/
		System.out.println("max data->"+btree.maxData(root));
		btree.inorder(root);
		System.out.println("\ndiameter->"+btree.diameter(root,0));
		btree.printPaths(root);
	}
}
