package Graph;

public class LinkedDisjSets implements DisjSetsInterface {

	public LinkedSet[] sets;

	public LinkedDisjSets(int num){
		sets = new LinkedSet[num];
		for(int i=0;i<num;i++){
			sets[i] = new LinkedSet();
			sets[i].insert(i);
		}
	}

	class Node{
		public int key;
		public Node next;
		public Node rep;
		public Node(int k){
			this.key = k;
			this.next = null;
			this.rep = null;
		}
		
		public void setRep(Node r){
			this.rep = r;
		}
		
		public int getRep(){
			return rep.key;
		}
	}
	
	public class LinkedSet{
		public Node head;
		Node tail;
		int size;
		
		public void insert(int k){
			Node newNode = new Node(k);
			if(head==null){
				head = tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = newNode;
			}
			newNode.setRep(head);
			size++;
		}
		
		public Node find(int k){
			Node t = head;
			while(t!=null && t.key!=k){
				t = t.next;
			}
			return t;
		}
		
		public int getRep(){
			return head.getRep();
		}
		
		public void print(){
			System.out.println("The set is:");
			Node t = head;
			while(t!=null){
				System.out.print(t.key+" ");
				t = t.next;
			}
			System.out.println("");
		}
	}
	
	public int findSet(int t){
		for(int i=0;i<sets.length;i++){
			LinkedSet set = sets[i];
			if(set!=null){
				Node target = set.find(t);
				if(target!=null){
					return target.getRep();
				}
			}
		}
		return -1;
	}
	
	public void union(int u, int v){
		int head1 = findSet(u);
		int head2 = findSet(v);
		int unioned;
		if(head1!=head2){
		LinkedSet first,last;
		if(sets[head1].size<=sets[head2].size){
			first = sets[head1];
			last = sets[head2];
			unioned = head2;
		}
		else{
			first = sets[head2];
			last = sets[head1];
			unioned = head1;
		}
		Node n = last.head;
		while(n!=null){
			n.rep = first.head;
			n=n.next;
		}
		first.tail.next = last.head;
		first.tail = last.tail;
		sets[unioned]=null;
		}
	}
	
	public int size(){
		int count=0;
		for(int i=0;i<sets.length;i++){
			if(sets[i]!=null)
				count++;
		}
		return count;
	}
	
	public void printSets(){
		for(int i=0;i<sets.length;i++){
			if(sets[i]!=null)
				sets[i].print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedDisjSets sets = new LinkedDisjSets(6);
		//System.out.print(sets.findSet(3));
		//LinkedSet[] s = sets.sets;
		//System.out.print(s[3].getRep());
		sets.union(3,5);
		sets.union(5,2);
		sets.union(0,3);
		sets.printSets();
		System.out.print("The size of disjSets is "+ sets.size());
		
	}

}
