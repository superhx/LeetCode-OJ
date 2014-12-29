import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	LinkedHashMap<Integer, Integer> map;
	int capacity;
	public LRUCache( int capacity) {
		this.capacity=capacity;
		map = new LinkedHashMap<Integer, Integer>(capacity);
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Integer res=map.get(key);
			map.remove(key);
			map.put(key, res);
			return res;
		}
		return -1;
	}

	public void set(int key, int value) {
		 if (map.containsKey(key) || map.size() < capacity) {
	            map.remove(key);
	            map.put(key, value);
	            return;
	        }

	        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
	        if (iterator.hasNext()) {
	            Integer toRmKey = iterator.next().getKey();
	            map.remove(toRmKey);
	        }
	        map.put(key, value);
	}
}

