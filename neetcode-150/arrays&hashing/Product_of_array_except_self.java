class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; // get array length
        int[] res = new int[n]; // result array to store products

        // Step 1: compute prefix products (product of all elements before current index)
        int leftIndex = 1; // initialize product from left side
        for (int i = 0; i < n; i++) {
            res[i] = leftIndex; // store left-side product before current element
            leftIndex *= nums[i]; // multiply to include current element for next iteration
        }

        // Step 2: compute suffix products (product of all elements after current index)
        int rightIndex = 1; // initialize product from right side
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightIndex; // multiply stored prefix with right-side product
            rightIndex *= nums[i]; // update right product for next iteration
        }

        // Step 3: return the result array containing final products
        return res;
    }
}
