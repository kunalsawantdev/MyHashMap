
public class Node {
	public String key;
	public String value;
	public Node next;
	
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public String toString() {
		return "{" + key + "," + value+ "}";
	}
}

