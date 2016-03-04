package DataStructure;

public class LinkedList {
	
	private Node head = null;
	
	class Node{
		int key;
		Node next;
		public Node(int k, Node next){
			key = k;
			next = next;
		}
	}
	
	public LinkedList(){
		
	}
	
	public void insert(int key){
		Node n = new Node(key, null);
		if(head == null){
			head = n;
		}
		else{
			n.next = head;
			head = n;
		}
	}
	
	public Node[] search(int key){
		Node[] nodes = new Node[2];
		Node t = head;
		Node pre = null;
		while(t!=null && t.key!=key){
			pre = t;
			t = t.next;
		}
		nodes[0]=pre;
		nodes[1]=t;
		return nodes;
	}
	
	public void delete(int key){
		Node pre = null;
		Node curr = head;
		while(curr!=null && curr.key!=key){
			pre = curr;
			curr = curr.next;
		}
		if(curr==null){
			System.out.print("No such key");
		}
		else if(curr==head){
			head = curr.next;
		}
		else{
			pre.next = curr.next;
			curr = null;
		}
	}
	
	public void reverseList(){
		Node curr = head;
		Node pre = null;
		while(curr!=null){
			Node tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		head = pre;
	}
	
	//µÝ¹é°æ±¾
	public Node reverseListR(Node h){
		if(h==null || h.next==null){
			return h;
		}
		Node p = reverseListR(h.next);
		h.next.next = h;
		h.next = null;
		return p;
	}
	
	
	public void print(){
		Node p = head;
		while(p!=null){
			System.out.print(p.key+" ");
			p = p.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(9);
		list.insert(12);
		list.insert(7);
		list.print();
		list.reverseList();
		list.print();
	}

}
