import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
	public double LOAD_FACTOR = 0.75;
	int bucketSize = 10;
	Node[] bucketArray = new Node[bucketSize];
	String nullValue = null;
	int elementCount = 0;
	
	public MyHashMap() {
	}
	
	public int size() {
		return elementCount;
	}

	public void put(String key, String value) {
		Node inputNode = new Node(key,value);
		int hashCode = Math.abs((key.hashCode()) %bucketSize);
		if(bucketArray[hashCode]==null) {
			bucketArray[hashCode] = inputNode;
			elementCount++;
			reHash();
		}
		else {
			Node tempNode = bucketArray[hashCode];
			while(tempNode.next!=null) {
				if(tempNode.key.equals(key)) {
					tempNode.value = value;
					return;
				}
				else {
					tempNode = tempNode.next;
				}
			}
			if(tempNode.key.equals(key)) {
				tempNode.value= value;
			}
			else {
				tempNode.next = new Node(key,value);
				elementCount++;
				reHash();
			}
		}
	}
	
	public String get(String checkString) {
		int hashCode = Math.abs(checkString.hashCode()%10);
		if(bucketArray[hashCode]==null) {
			return null;
		}
		else {
			Node tempNode = bucketArray[hashCode];
			while(tempNode.next!=null) {
				if(tempNode.key.equals(checkString)) {
					return tempNode.value;
				}
				else {
					tempNode = tempNode.next;
				}
			}
			if(tempNode.key.equals(checkString)) {
				return tempNode.value;
			}
			else
				return null;
		}
	}
	
	public void reHash() {
		
		if(elementCount >= LOAD_FACTOR* bucketSize * bucketSize) {
			bucketSize = 2 * bucketSize;
			//Creating new array of new BucketSize;
			List<Node> tempList = traverse();
			this.bucketArray = new Node[bucketSize];
			for(Node a: tempList) {
				put(a.key, a.value);
			}
		}
	}
	
	public List<Node> traverse() {
		List<Node> elementList = new ArrayList();
		for(int i = 0; i < bucketArray.length; i++) {
			if(bucketArray[i]!=null) {
				Node tempNode = bucketArray[i];
				while(tempNode.next!=null) {
					elementList.add(tempNode);
					tempNode = tempNode.next;
				}
				elementList.add(tempNode);
			}
		}
		return elementList;
	}
}
