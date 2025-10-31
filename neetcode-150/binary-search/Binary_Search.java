class Solution {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        while(left<right){
            int mid = (right+left)/2;
            if(mid==target){
                return mid;
            }
            else if(mid<target){
                left = mid+1;
            }
            else{
                right= mid-1;
            }
        }
        return -1;
    }
}
public class Binary_Search {
    public static void main(String[] args) {
        int[] nums ={-1,0,2,4,6,8};
        Solution sol = new Solution();
        System.out.println(sol.search(nums,4));
    }
}

