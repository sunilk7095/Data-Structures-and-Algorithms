class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack();
        int[] list = new int[n];
        

        // for(int i =0; i< n; i++){
        //     list.append(0);
        // }

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int oldIdx = st.pop();
                list[oldIdx] = i - oldIdx; 
            }
            st.push(i);
        }
        return list;
    }
}