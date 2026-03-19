class Solution {
    public List<String> solve(int i, String s, Set<String> set, int n, HashMap<Integer, List<String>> map) {
        if (map.containsKey(i)) return map.get(i);
        List<String> res = new ArrayList<>();
        if (i == n) {
            res.add("");   
            return res;
        }
        String temp = "";
        for (int j = i; j < n; j++) {
            temp += s.charAt(j);
            if (set.contains(temp)) {
                List<String> next = solve(j + 1, s, set, n, map);
                for (int k = 0; k < next.size(); k++) {
                    String str = next.get(k);
                    if (str.equals(""))
                        res.add(temp);
                    else
                         res.add(temp + " " + str);
                }
            }
        }
        map.put(i, res);
        return res;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> map = new HashMap<>();
        return solve(0, s, set, s.length(), map);
    }
}