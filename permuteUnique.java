class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums,lst,new ArrayList<Integer>(),0,new boolean[nums.length]);
        return lst;
    }
    public void backtrack(int[] nums,List<List<Integer>> lst, ArrayList<Integer> arr, int start,boolean[] visited) {
        if (arr.size()==nums.length) {
            lst.add(new ArrayList<Integer>(arr));
            return;
        }
        for (int i=start;i<nums.length;i++) {
            if (visited[i] || i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            visited[i]=true;
            arr.add(nums[i]);
            backtrack(nums,lst,arr,start,visited);
            visited[i]=false;
            arr.remove(arr.size()-1);
        }
    }
}
