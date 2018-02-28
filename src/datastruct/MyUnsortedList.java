package datastruct;

public class MyUnsortedList<E> implements UnsortedList<E> {
	private int taille;
	private Maillon<E> first;
	private Maillon<E> last;
	
	public MyUnsortedList() {
		this.taille = 0;
		this.first = null;
		this.last = null;
	}
	
	@Override
	public boolean isEmpty() {
		return taille == 0;
	}

	@Override
	public int size() {
		return this.taille;
	}

	@Override
	public void append(E element) {
		Maillon<E> maillon = new Maillon<E>(this.last,element);
		
		if(this.isEmpty()) {
			this.first = maillon;
		} else {
			this.last.setNext(maillon);
		}
		
		this.last = maillon;
		taille ++;
	}

	@Override
	public E pop() throws EmptyListException {
		if (this.isEmpty()) {
			throw new EmptyListException();
		}
		
		E ret = this.first.getElement();
		this.first = this.first.getNext();
		if (this.first != null) {
			this.first.setPrev(null);
		}
		this.taille --;
		return ret;
	}

	@Override
	public void insert(E elem, int pos) throws IndexOutOfBoundsException {
		if (pos > this.taille || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (pos == this.taille) {
			this.append(elem);
			return;
		}
		// GETTING PREVIOUS NODE
		Maillon<E> init;
		if(pos == 0) { init = null; }
		else { init = this.first; }
		
		for(int i=1;i<pos;i++) {
			init = init.getNext();
		}
		// CREATING THE NODE
		Maillon<E> maillon = new Maillon<E>(init,elem);
		
		if(pos == 0) {
			this.first.setPrev(maillon);
			maillon.setNext(this.first);
			this.first = maillon;
		} else {
			maillon.setNext(init.getNext());
			maillon.getNext().setPrev(maillon);
			maillon.getPrev().setNext(maillon);
		}
		taille ++;
	}

	@Override
	public E remove(int pos) throws IndexOutOfBoundsException {
		if (pos >= this.taille || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (pos == 0) {
			try {
				return this.pop();
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
		}
		// GETTING PREVIOUS NODE
		Maillon<E> init = this.first;
		for(int i=1;i<pos;i++) {
			init = init.getNext();
		}
		E ret = init.getNext().getElement();
		
		init.setNext(init.getNext().getNext());
		if (init.getNext() != null) {
			init.getNext().setPrev(init);
		}
		
		this.taille --;
		return ret;
	}

}
