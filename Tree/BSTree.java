package Tree;


public class BSTree {
	
	Node root = null;
	
	 class Node{
		int value;
		Node parent;
		Node left;
		Node right;
		public Node(int v){
			value = v;
		}
		
		@Override
		public String toString(){
			return String.valueOf(value);
		}
	}
	
	public void buildFromArray(int[] array){
		//Node root = null;
		for(int i=0; i<array.length; i++){
			root = insert(root, array[i]);
		}
	}
	
	public Node insert(Node node, int value){
		Node y = null;
		Node x = node;
		Node newNode = new Node(value);
		while(x != null){
			y=x;
			if(value < x.value){
				x = x.left;
			}
			else {
				x = x.right;
			}
		}
		newNode.parent = y;
		if(y==null){
			node = newNode;
		}
		else {
			if(newNode.value<y.value)
				y.left = newNode;
			else {
				y.right = newNode;
			}
		}
		return node;
	}
	
	public void inorder(Node n){
		Node x = n;
		if(x!=null){
			inorder(x.left);
			System.out.print(x+" ");
			inorder(x.right);
		}
//		else {
//			System.out.print("Empty Tree");
//		}
	}
	
	//·µ»ØStringµÄpreorder·½·¨
//	public String preorder(Node node){
//		//String preorderString = "";
//		Node x = node;
//		if(x!=null){
//			String s1,s2,s3;
//			s1 = x+" ";
//			s2 = preorder(x.left);
//			s3 = preorder(x.right);
//			return s1+s2+s3;
//		}
//		else {
//			return "";
//		}
//	}
	
	public void preorder(Node node){
		Node x = node;
		if(x!=null){
			System.out.print(x+" ");
			preorder(x.left);
			preorder(x.right);
		}
	}
	
	public void postorder(Node node){
		Node x = node;
		if(x!=null){
			postorder(x.left);
			postorder(x.right);
			System.out.print(x+" ");
		}
	}
	
	public int height(Node node){
		if(node == null){
			return 0;
		}
		else {
			int left_height = 0;
			int right_height = 0;
			left_height = height(node.left);
			right_height = height(node.right);
			return (left_height<right_height)? right_height+1:left_height+1;
		}
	}
	
	public Node successor(Node node){
		if(node == null)
			return null;
		else if (node.right != null) {
			Node r = node.right;
			while(r.left!=null)
				r = r.left;
			return r;
		}
		else {
			Node p = node.parent;
			Node t = node;
			while(p != null && t == p.right){
				t = p;
				p = p.parent;
			}
			return p;
		}
	}
	
	public Node search(Node node, int key){
		if(node == null || key == node.value)
			return node;
		if(key<node.value){
			return search(node.left, key);
		}
		else {
			return search(node.right, key);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] treeKey = {2,4,1,5,8,3};
		BSTree t = new BSTree();
		t.buildFromArray(treeKey);
		t.inorder(t.root);
		System.out.println("");
		t.preorder(t.root);
		System.out.println("");
		t.postorder(t.root);
		System.out.println("");
		System.out.print("Height:"+t.height(t.root));
		
		System.out.println("");
		System.out.println("successor: " + t.successor(t.search(t.root, 9)));
	}
}
