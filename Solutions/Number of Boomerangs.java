/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points==null || points.length<2) {
            return 0;
        }
        
        int result=0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<points.length;i++) {
            for(int j=0;j<points.length;j++) {
                if(i==j) {
                    continue;
                }
                
                int dist = getDistance(points[i],points[j]);
                map.put(dist,map.getOrDefault(dist,0)+1);
            }
            
            for(int vals : map.values()) {
                result += vals*(vals-1); // all permutations of two numbers
            }
            
            map.clear(); // cleared the map for new set of points
        }
        
        return result;
    }
    
    private int getDistance(int[] p1,int[] p2) {
        int xDist = p1[0] - p2[0];
        int yDist = p1[1] - p2[1];
        
        return (xDist*xDist + yDist*yDist);
    }
}