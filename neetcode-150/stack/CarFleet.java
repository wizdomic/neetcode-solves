class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // create a time array (indexed by position) to store each car's time to reach target
        float[] time = new float[target + 1];
        for (int i = 0; i < speed.length; i++) {
            // time = distance / speed for each car
            time[position[i]] = (float)(target - position[i]) / speed[i];
        }

        int count = 0; // number of car fleets
        float maxi = 0; // track max time (slowest car/fleet ahead)
        // iterate from the car closest to target towards start
        for (int i = time.length - 1; i >= 0; i--) {
            if (time[i] > maxi) { // if this car takes longer, forms a new fleet
                count++;
                maxi = time[i]; // update max time for this fleet
            }
        }
        return count; // return total fleets
    }
}
