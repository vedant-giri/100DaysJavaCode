// Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        
        // code here
        // int count = 0;
        // for(int i=0; i<n-1; i++){
        //     for(int j=i+1; j<n; j++){
                
        //         if(arr[i] + arr[j] == k){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        // int left=0;
        // int right=n-1;
        
        // int count=0;
        
        // int sum=0;
        
        // Arrays.sort(arr);
        
        // while(left<right){
        //     sum=arr[left]+arr[right];
            
        //     if(sum==k){
        //         count++;
        //     }else if(sum<k){
        //         left++;
        //     }else{
        //         right--;
        //     }
        // }
        
        // return count;
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // Initialize count of pairs
        int count = 0;
   
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
      
        for (int num : arr) {
            
            if (map.containsKey(k - num)) {
                if(k-num!=num){
                    count+=map.get(k-num);
                }else{
                    count+=map.get(num)-1;
                }
               
            }
        }
        
       
        return count / 2;