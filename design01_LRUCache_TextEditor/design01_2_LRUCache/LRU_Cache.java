package src.design01_LRUCache_TextEditor.design01_2_LRUCache;

import java.util.HashMap;

/**
 * 
 * LRU Cache 
 * 
 * 
 * Problem statement:
 * 
 *  recently called objects in cache 
 *  Cache Capacity C 
 *  if obj already in cache , 
 *         change position 
 *  if cache not full - add curr obj 
 *  if cache full - remove least recently called , add curr obj
 * 
 * 
 * 
 * @author shree
 * 
 *
 */
public class LRU_Cache {

	public static void main(String[] args) {
		
		// LRU cache 
		LRU_LRU_CACHE llc=new LRU_LRU_CACHE(5);
		llc.add(0,"geek");
		llc.add(1,"for");
		llc.add(2, "geeks");
		llc.add(0,"geek");
		System.out.println(llc.get(0));
		llc.add(3,"Works");
		llc.add(4,"Code");
		llc.add(5,"Put together");
		llc.toString();
		llc.printLRU();
		llc.add(6," excess ");
		System.out.println(llc.get(1));
		llc.add(0,"New-geek");
		llc.printLRU();

	}

}

class LRU_LRU_CACHE{
	
	private HashMap<Integer,LRU_Node> lru;
	private int capacity;
	private LRU_Node head;
	private LRU_Node tail;
	
	public LRU_LRU_CACHE(int c) {
		capacity=c;
		lru=new HashMap<Integer,LRU_Node>(c);
		head=null;tail=null;
	}
	
	public boolean add(int key,String val) {
		
		System.out.println(" LRU size "+lru.size());
		if(head==null) { // empty LRU 
			System.out.println(" Empty lru .....");
			LRU_Node curr=new LRU_Node(key,val);
			head=curr;
			tail=curr;
			lru.put(key,curr);//update in lru
		}
		else if(lru.containsKey(key)){  // Already present , only change pos to head 
			System.out.println(" Exists in lru .....");
			LRU_Node curr=new LRU_Node(key,val);// updating in-case new val 
		    lru.put(key,curr);// again updating with new val 
			
			if(curr.prev==null) {
				return true;//already head 
			}
			
			
			if(curr.next==null) {// curr is the tail , make prev as tail 
				tail=curr.prev;// tail updation done !!! 
			}
			
			curr.prev.next=curr.next;// remove from existing point , works for tail also 
			
			curr.next=head;
			head.prev=curr;
			curr.prev=null;//make head 
			this.head=curr;// head updation done 
		}
		
		
		// Not present in LRU 
		// Case 1 : Storage exist 
		else if(lru.size()<capacity) {
			System.out.println(" Storage Available .....");
			LRU_Node curr=new LRU_Node(key,val);
			
			lru.put(key, curr);// update in lru
			
			// put as head , No need for tail updation 
			head.prev=curr;
			curr.next=head;
			this.head=curr;//head updation done 
		}
		//Case 2 : Storage Full 
		else {
			System.out.println(" Storage full ..deletion...addition .....");
			
			//Tail handling 
			LRU_Node toremove=tail;
			tail=tail.prev; // Tail updation 
			tail.next=null; // Remove Tail 
			
			lru.remove(toremove.key);//remove from lru
			
			//Add new at head 
			LRU_Node curr=new LRU_Node(key,val);
			lru.put(key, curr);// update in lru
			// put as head , No need for tail updation 
			head.prev=curr;
			curr.next=head;
			this.head=curr;//head updation done 
			
		}
		this.printLRU();
		return true;
	}
	
	public String get(int key) {
		System.out.println("Get ... "); this.printLRU();
		if(lru.containsKey(key)) {
			System.out.println(" Data present for key "+key+" .....");
			return lru.get(key).data;
		}
		System.out.println(" Data NOT found for key "+key+" .....");
		return "Not Found";
	}
	
	public void printLRU() {
	
		LRU_Node prev=head;
		int c=0;
		while(prev!=null) {
			System.out.println(c+" ---> "+prev.key+" :- "+prev.data);
			prev=prev.next;
			c++;
		}
	}
	
}

class LRU_Node{
	LRU_Node next;
	LRU_Node prev;
	String data;
	int key;// not necessary
	LRU_Node(int x,String str){
		key=x;
		data=str;
		next=null;
		prev=null;
	}
}

