import java.util.*;

class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        int s, e;
        int len = dict.size();
        String[] dicts = dict.toArray(new String[len]);
        dict.toArray();
        Vector<Integer>[] graph = getDictGraph(dicts);
        NodeColor[] color = new NodeColor[len];
        Queue<Integer> q = new LinkedList<Integer>();
        int[] d = new int[len];
        s = e = 0;
        for (int i = 0; i < len; i++) color[i] = NodeColor.white;
        int index = 0;
        while (!start.equals(dicts[s = index++])) ;
        index = 0;
        while (!end.equals(dicts[e = index++])) ;
        d[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            Iterator<Integer> it = graph[u].iterator();
            while (it.hasNext()) {
                int v = it.next();
                if (color[v] == NodeColor.white) {
                    color[v] = NodeColor.gray;
                    q.add(v);
                    d[v] = d[u] + 1;
                }
            }
            color[u] = NodeColor.black;
        }
        return d[e] != 0 ? d[e] + 1 : 0;
    }

    private Vector<Integer>[] getDictGraph(String[] dicts) {
        int len = dicts.length;
        Vector<Integer>[] graph = new Vector[dicts.length];
        for (int i = 0; i < len; i++)
            graph[i] = new Vector<Integer>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isNeighbor(i, j, dicts)) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        return graph;
    }

    private boolean isNeighbor(int x, int y, String[] dict) {
        String str1 = dict[x];
        String str2 = dict[y];
        int diffNum = 0;
        for (int i = 0, len = str1.length(); i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (++diffNum == 2)
                    return false;
            }
        }
        return true;
    }

    public enum NodeColor {
        black, gray, white
    }
}
