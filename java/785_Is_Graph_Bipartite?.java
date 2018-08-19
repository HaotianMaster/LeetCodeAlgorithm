//Our goal is trying to use two colors to color the graph and see if there are any adjacent nodes having the same color.
//Initialize a color[] array for each node. Here are three states for colors[] array:
//-1: Haven't been colored.
//0: Blue.
//1: Red.
//For each node,

//If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
//If it has been colored, check if the current color is the same as the color that is going to be used to color it. (Please forgive my english... Hope you can understand it.)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, -1, i))
                return false;
        }
        return true;
    }
    
    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int j = 0; j < graph[node].length; j++) {
            if (!validColor(graph, colors, -color, graph[node][j]))
                return false;
        }
        return true;
    }
}