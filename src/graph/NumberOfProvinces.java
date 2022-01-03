/*

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.




*/


class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int root[] = new int [isConnected.length];
        
        for(int i=0; i<root.length; i++) {
            root[i]=i;
        }
        
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j]==1 && i!=j) {
                    union(root,i,j);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < root.length; i++) {
            if (root[i] == i)
                count++;
        }
        
        return count;
        
    }
    
    private void union (int [] root, int i, int j) {
        
        int rootI = find(i,root);
        int rootJ = find(j,root);
        root[rootJ] = rootI;
        
    }
    
    private int find(int i, int [] root) {
        
        if (root[i]==i) 
            return i;
        return find(root[i],root);
        
    }
}
