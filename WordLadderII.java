import java.util.*;

class WordLadderII {
    private List<String> list;

    public List<List<String>> findLadders(String start, String end,
                                          Set<String> dict) {
        dict.add(start);
        dict.add(end);
        Map<String, List<String>> graph = getDictGraph(dict, start, end);
        List<List<String>> res = new LinkedList<List<String>>();
        list = new LinkedList<String>();
        backTrace(start, end, res, graph);
        return res;
    }

    private void backTrace(String start, String end,
                           List<List<String>> res, Map<String, List<String>> graph) {
        if (start.equals(end)) {
            list.add(0, end);
            res.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        if (!list.contains(end)) {
            list.add(0, end);
            for (String neighbor : graph.get(end)) {
                backTrace(start, neighbor, res, graph);
            }
            list.remove(0);
        }
    }

    private Map<String, List<String>> getDictGraph(Set<String> dict, String start, String end) {
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        for (String word : dict)
            graph.put(word, new LinkedList<String>());
        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>(dict);
        unvisited.remove(end);
        Queue<String> queue = new LinkedList<String>();
        queue.add(end);
        int curr = 1;
        boolean found = false;
        int next = 0;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curr--;
            for (int i = 0, len = word.length(); i < len; i++) {
                StringBuffer buffer = new StringBuffer(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    buffer.setCharAt(i, ch);
                    String w = buffer.toString();
                    if (unvisited.contains(w)) {
                        graph.get(word).add(w);
                        if (visited.add(w)) {
                            next++;
                            queue.add(w);
                            if (w.equals(start)) found = true;
                        }
                    }
                }
            }
            if (curr == 0) {
                if (found) break;
                curr = next;
                next = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }
        return graph;
    }
}
