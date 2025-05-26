// arquivo: src/apl2/DLinkedList.java

// Mateus Ribeiro Cerqueira - 10443901
// Pedro Henrique Carvalho Pereira - 10418861

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	
	private Node head;
	private Node tail;
	private int count;
	
	public DLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}
	
	public void destroy() {
		clear();
	}
	
	public void insert(String id, String nome, float nota) {
		Node node = new Node(id, nome, nota, head);
		
		if (isEmpty()) {
			tail = node;
		}
		
		head = node;
		++count;
	}
	
	public void append(String id, String nome, float nota) {
		Node node = new Node(id, nome, nota, null);
		
		if (isEmpty()) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		
		tail = node;
		++count;
	}
	
	public Node removeHead() {
		if (isEmpty()) {
			return null;
		}
		
		Node toRemove = head;

		head = head.getNext();
		--count;
		
		if (isEmpty()) {
			tail = null;
		}
		
		toRemove.setNext(null);
		return toRemove;
	}
	
	public Node removeTail() {
		if (head == tail)
			return removeHead();
		
		Node toRemove = tail;
		tail = toRemove.getPrevious();
		tail.setNext(null);
		--count;
		
		toRemove.setNext(null);
		toRemove.setPrevious(null);
		return toRemove;
	}
	
	public Node removeNode(String id) {
		Node toRemove = head;
		while (toRemove != null && !id.equals(toRemove.getId())) {
			toRemove = toRemove.getNext();
		}
		
		if (toRemove == null) {
			return null;
		}
		
		if (toRemove == head) {
			return removeHead();
		}
		
		if (toRemove == tail) {
			return removeTail();
		}
		
		(toRemove.getPrevious()).setNext(toRemove.getNext());

		if (toRemove.getNext() != null) {
			(toRemove.getNext()).setPrevious(toRemove.getPrevious());
		}
		--count;
		
		toRemove.setNext(null);		
		return toRemove;
	}

	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public Node getNode(String id) {
		Node node = head;
		while (node != null) {
			if (node.getId().equals(id)) {
				return node;
			}
			node = node.getNext();
		}
		
		return null;
	}
	
	public int count() {
		return count;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void clear() {
		while (!isEmpty()) {
			removeHead();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + count + ") \n");
		
		Node node = head;
		while (node != null) {
			sb.append("(")
			.append(node.getId())
			.append(";")
			.append(node.getNome())
			.append(";")
			.append(node.getNota())
			.append(")\n");
			node = node.getNext();
		}
		sb.append("null.");
		
		return sb.toString();
	}

}
