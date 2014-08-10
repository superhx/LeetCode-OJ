import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<Integer,UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
		Stack<UndirectedGraphNode> remain=new Stack<UndirectedGraphNode>();
		if(node==null)
			return node;
		remain.push(node);
		map.put(node.label,(node=new UndirectedGraphNode(node.label)));
		UndirectedGraphNode temp;
		UndirectedGraphNode mapNode;
		while(!remain.isEmpty()){
			temp=remain.pop();
			mapNode=map.get(temp.label);
			for(UndirectedGraphNode neighbor:temp.neighbors){
				if(!map.containsKey(neighbor.label)){
					UndirectedGraphNode newNeighbor=new UndirectedGraphNode(neighbor.label);
					map.put(neighbor.label,newNeighbor);
					remain.push(neighbor);
					mapNode.neighbors.add(newNeighbor);
				}else{
					mapNode.neighbors.add(map.get(neighbor.label));
				}
			}
		}
		return node;
	}
}