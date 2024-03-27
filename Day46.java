// Given a matrix mat[][] with r rows and c columns, where some cells are landmines (marked as 0) and others are safe to traverse. Your task is to find the shortest safe route from any cell in the leftmost column to any cell in the rightmost column of the mat. You cannot move diagonally, and you must avoid both the landmines and their adjacent cells (up, down, left, right), as they are also unsafe.


class Solution {
    public static int findShortestPath(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [][]visited = new int[m][n];
        boolean [][]vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0 && vis[i][j]==false){
                    vis[i][j]=true;
                    if(i+1<m){
                        mat[i+1][j]=0;
                        vis[i+1][j]=true;
                    }if(i-1>=0){
                        mat[i-1][j]=0;
                        vis[i-1][j]=true;
                    }if(j+1<n){
                        mat[i][j+1]=0;
                        vis[i][j+1]=true;
                    }if(j-1>=0){
                        mat[i][j-1]=0;
                        vis[i][j-1]=true;
                    }
                }
            }
        }
        int arr[] = new int[1];
        arr[0] = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            dfs(i,0,mat,visited,1,arr);
        }
        if(arr[0]==Integer.MAX_VALUE){
            return -1;
        }
        return arr[0];
    }
    static void dfs(int r,int c,int[][] mat,int [][]visited,int count,int []arr){
        // System.out.println(count+" (" +r +" "+ c+")");
        if(mat[r][c]==0){
            return;
        }
        if(c == mat[0].length-1){
            if(count<arr[0]){
                arr[0] = count;
            }
            return;
        }
        visited[r][c]=1;
        if(r+1<mat.length && mat[r+1][c]==1 && visited[r+1][c]==0){
            dfs(r+1,c,mat,visited,count+1,arr);
        }if(c+1<mat[0].length && mat[r][c+1]==1 && visited[r][c+1]==0){
            dfs(r,c+1,mat,visited,count+1,arr);
        }if(r-1>=0 && mat[r-1][c]==1 && visited[r-1][c]==0){
            dfs(r-1,c,mat,visited,count+1,arr);
        }if(c-1>=0 && mat[r][c-1]==1 && visited[r][c-1]==0){
            dfs(r,c-1,mat,visited,count+1,arr);
        }
        
        visited[r][c]=0;
    }
}


