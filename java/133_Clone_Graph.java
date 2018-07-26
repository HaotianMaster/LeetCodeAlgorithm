/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// BFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        queue.offer(node);
        // BFS traverse the whole graph and make a copy of node using HashMap.
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            UndirectedGraphNode copy = new UndirectedGraphNode(curr.label);
            map.put(curr, copy);
            for (UndirectedGraphNode next : curr.neighbors) {
                if (!map.containsKey(next)) {
                    queue.offer(next);
                }
            }
        }
        // Create the neighbors connection for the copy. 
        for (UndirectedGraphNode origin : map.keySet()) {
            UndirectedGraphNode copy = map.get(origin);
            for (UndirectedGraphNode neighbor : origin.neighbors) {
                copy.neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}

// DFS, which is mnuch faster than BFS in this case.
public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneHelper(node);
    }
    public UndirectedGraphNode cloneHelper(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(cloneHelper(neighbor));
        }
        return copy;
    }
}

public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node);
    }
    public UndirectedGraphNode helper(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        copy.neighbors = new ArrayList<>();
        map.put(node, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(helper(neighbor));
        }
        return copy;
    }
}


