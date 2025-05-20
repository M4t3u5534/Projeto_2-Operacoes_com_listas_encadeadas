// arquivo: src/apl2/Node.java

// Mateus Ribeiro Cerqueira - 10443901
// Pedro Henrique Carvalho Pereira - 10418861

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
	
	private String id;
	private String nome;
	private float nota;
	private Node next;
	private Node previous;
	
	public Node() {
		this("", "", 0, null);
	}
	
	public Node(String id, String nome, float nota, Node next) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
		this.next = next;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}

	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	@Override
	public String toString() {
		return "[dados: (" + id + ";" + nome + ";" + nota + ") | next: " + next + "]";
	}

}