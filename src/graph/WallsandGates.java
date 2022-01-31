/*

You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 

Example 1:


Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:

Input: rooms = [[-1]]
Output: [[-1]]
 

Constraints:

m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.
*/

class Solution {
    
    private int INF = 2147483647;
    
    public void wallsAndGates(int[][] rooms) {
        
        
        Queue<Point> queue = new LinkedList<>();
        
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j]==0) {
                    queue.add(new Point(i,j));
                }
            }
        }
        
        while(!queue.isEmpty()) {
            
            Point p = queue.poll();
            
            int row = p.i;
            int col = p.j;
            
            if(row-1>=0 && rooms[row-1][col]==INF) {
                queue.add(new Point(row-1,col));
                rooms[row-1][col] = rooms[row][col]+1;
            }
            
            if(row+1<rooms.length && rooms[row+1][col]==INF) {
                queue.add(new Point(row+1,col));
                rooms[row+1][col] = rooms[row][col]+1;
            }
            
            if(col-1>=0 && rooms[row][col-1]==INF) {
                queue.add(new Point(row,col-1));
                rooms[row][col-1] = rooms[row][col]+1;
            }
            
            if(col+1<rooms[0].length && rooms[row][col+1]==INF) {
                queue.add(new Point(row,col+1));
                rooms[row][col+1] = rooms[row][col]+1;
            }
            
        }
        
    }
}

class Point {
    
    int i;
    int j;
    
    Point(int i, int j) {
        this.i=i;
        this.j=j;
    }
}
