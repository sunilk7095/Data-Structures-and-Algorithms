class Solution {

    boolean canShip(int[] boxes, int days,int cap){
        int trucks_used =1;
        int current =  0;
        for(int box : boxes){
            if (current + box > cap){
                trucks_used += 1;
                current = 0;
            }
            current += box;
        }
        return trucks_used <= days;
    }
    int shipWithinDays(int[] boxes, int days) {
        int lo = 0;
        int hi = 0;
        for (int box : boxes) {
            lo = Math.max(lo, box);
            hi += box;
        }
        
            int answer = hi;
            while (lo <= hi){
                int mid = (lo + hi) /2;
                if(canShip(boxes, days, mid)){
                    answer = mid;
                    hi = mid - 1;
                }
                else{
                    lo = mid + 1;
                }
            }
                
            return answer;
    }
};


