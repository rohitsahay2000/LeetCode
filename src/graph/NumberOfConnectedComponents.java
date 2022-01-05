/*
Number of Connected Components in an Undirected Graph

Solution
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.


*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        
        UnionFind unionFind = new UnionFind(n);
        
        for(int [] edge : edges) {
            unionFind.union(edge[0],edge[1]);
        }
        
        int parent[] = unionFind.getParentArray();
        
        int count = 0;
        
        for(int i=0; i<parent.length; i++) {
            if(parent[i]==i)
                count++;
        }
        return count;
    }
}

class UnionFind {

    private int parent[];
    private int size [];

    public UnionFind(int n) {

        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n ; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    private int find(int A) {

        int root = A;
        while(root!=parent[root]) {
            root = parent[root];
        }

        while(A!=root) {
            int oldRoot = parent[A];
            parent[A] = root;
            A = oldRoot;
        }
        return root;
    }

    public boolean union(int A, int B) {

        int rootA = find(A);
        int rootB = find(B);

        if (rootA == rootB) {
            return false;
        }

        if(size[rootA] < size[rootB]) {
            parent[rootA]=rootB;
            size[rootB]+=size[rootA];
        }
        else {
            parent[rootB] = rootA;
            size[rootA]+=size[rootB];
        }

        return true;
    }
    
    public int [] getParentArray() {
        return parent;
    }
}
