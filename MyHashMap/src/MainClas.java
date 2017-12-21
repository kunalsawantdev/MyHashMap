
public class MainClas {
	public static void main(String args[]) {
		MyHashMap map = new MyHashMap();
		map.put("hello", "jello");
		map.put("jungya", "chhaknu");
		map.put("jungya", "joog");
		map.put("joker", "nevermind");
		map.put("man", "told" );
		System.out.println(map.elementCount);
		System.out.println(map.bucketSize);
		System.out.println(map.traverse());
		System.out.println(map.bucketSize);
	}
	
	
}
