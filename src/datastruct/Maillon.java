package datastruct;

public class Maillon<E> {
	private E element;
	private Maillon<E> next;
	private Maillon<E> prec;
	
	public Maillon(Maillon<E> prec, E e) {
		this.element = e;
		this.prec = prec;
		this.next = null;
	}
	
	public E getElement() {
		return this.element;
	}
	
	public Maillon<E> getPrev() {
		return this.prec;
	}
	
	public Maillon<E> getNext() {
		return this.next;
	}
	
	public void setNext(Maillon<E> e) {
		this.next = e;
	}
	
	public void setPrev(Maillon<E> e) {
		this.prec = e;
	}
}
