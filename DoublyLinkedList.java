package tugas_1;


class Listing{
	Object data;
	Listing next;
	Listing prev;

	public Listing() {	
	}
	public Listing(Object data) {
		this(data,null,null);
	}
	public Listing(Object data,Listing next,Listing prev) {
		this.data=data;
		this.next=next;
		this.prev=prev;
	}
}

public class DoublyLinkedList {
	Listing head,tail;
	int size;
	public DoublyLinkedList() {
		makeEmpty();
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void makeEmpty() {
		head=tail=null;
		size=0;
	}
	public int size() {
		return size;
	}
	//penambahan
	public void addFirst(Object x) {
		Listing tmp=new Listing(x);
		if (head==null && tail==null) {
			head=tail=tmp;
			size++;
		}else {
			tmp.next=head;
			head.prev=tmp;
			tmp.prev=null;
			head=tmp;
			size++;
			}
		}
	public void addLast(Object x) {
		Listing tmp=new Listing(x);
		if (head==null && tail==null) {
			head=tail=tmp;
			size++;
		}else {
			tmp.prev=tail;
			tail.next=tmp;
			tmp.next=null;
			tail=tmp;
			size++;
		}
	}
	public void insertBefore(Object awal, Object x) {
		Listing search = head;
		Listing tmp = new Listing(x);
		if(isEmpty()) {
			head=tail=tmp;
			size++;
		}else if(head.data.equals(awal)){
			addFirst(x);
		}else {
			while(search.data != awal) {
				if(search.data.equals(awal)) {
					break;
				}
				search=search.next;
			}
			search.prev.next=tmp;
			tmp.prev=search.prev;
			tmp.next=search;
			search.prev=tmp;
			size++;
		}
	}
	public void insertAfter(Object awal, Object x) {
		Listing search = tail;
		Listing tmp = new Listing(x);
		if(isEmpty()) {
			head=tail=tmp;
			size++;
		}else if(tail.data.equals(awal)){
			addLast(x);
		}else {
			while(search.data != awal) {
				if(search.data.equals(awal)) {
					break;
				}
				search=search.prev;
			}
			search.next.prev=tmp;
			tmp.next=search.next;
			tmp.prev=search;
			search.next=tmp;
			size++;
		}
	}
	public void insertByIndex(int a, Object x) {
		Listing search=head;
		Listing tmp=new Listing(x);
		if(a==0) {
			head=tail=tmp;
			size++;
		}else if(a==1) {
			addFirst(x);
		}else if(a==this.size) {
			addLast(x);
		}else {
			do {
				search=search.next;
				a--;
			}while(a>1);
			search.prev.next=tmp;
			tmp.prev=search.prev;
			tmp.next=search;
			search.prev=tmp;
			size++;
		}
		
	}
	public void removeFirst() {
		if(!isEmpty()) {
			if(head==tail) {
				head=tail=null;
			}else {
				head.next.prev=null;
				head=head.next;
			}
			size--;
		}
	}
	public void removeLast() {
		if(!isEmpty()) {
			if(head==tail) {
				head=tail=null;
			}else {
				tail.prev.next=null;
				tail=tail.prev;
			}
			size--;
		}
	}
	public void removeByData(Object x) {
		if(head.data.equals(x)) {
			removeFirst();
		}else if(tail.data.equals(x)) {
			removeLast();
		}else {
			Listing search=head;
			while(search.data != x) {
				if(search.data.equals(x)) {
					break;
				}
				search=search.next;
			}
			search.next.prev=search.prev;
			search.prev.next=search.next;
			size--;
		}
	}
	public void removeByIndex(int x) {
		Listing search=head;
		if(x==1) {
			removeFirst();
		}else if(x==this.size) {
			removeLast();
		}else if(x<this.size) {
			do {
				search=search.next;
				x--;
			}while(x>1);
			search.next.prev=search.prev;
			search.prev.next=search.next;
			size--;
		}
	}	
	//print
	public void printToHead() {
		Listing p=tail;
		while (p!=null) {
			System.out.print(p.data + " ");
			p=p.prev;
		}
	}
	public void printToTail() {
		Listing p=head;
		while(p!=null) {
			System.out.print(p.data + " ");
			p=p.next;
		}
	}
}
