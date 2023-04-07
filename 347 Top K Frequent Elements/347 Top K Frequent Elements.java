public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //result vector
        int[] result = new int[k];
        //count for the frequencies
        int count = 0;
        //map in which key is the number and k is the occurences
        Map<Integer, Integer> pair = new HashMap<Integer,Integer>();
        int max = 0;

        //for each element in nums count the occurences only if the number does not exist
        for(int i=0; i<nums.length; i++){
            if(!pair.containsKey(nums[i])){
                count = 0;
                for(int j=0; j<nums.length; j++){
                    if(nums[i]==nums[j]){
                        count++;
                    }
                }
                pair.put(nums[i], count);
            }
        }


        Set<Integer> set = pair.keySet();
        TreeSet<Integer> keys = new TreeSet<Integer>(set);

        int temp = 0;
        int top = 0;
        int w = 0;
        boolean write = false;


        for(int i=0; i<k; i++){
            w = i;
            max = 0;
            write = false;
            keys = new TreeSet<Integer>(set);
            

            int size = keys.size();
            for(int j=0; j<size; j++){
                temp = keys.pollFirst();
                
                if(pair.get(temp) > max){
                    max = pair.get(temp);
                    top = temp;
                    write = true;
                }
            }
            if(write){
                result[i] = top;
                set.remove(top);
            }
        }
        return result;
    }
}