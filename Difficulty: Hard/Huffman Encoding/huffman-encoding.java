class Solution {

    class Node {
        int freq;
        int idx; // smallest character index in subtree
        Node left, right;

        Node(int freq, int idx) {
            this.freq = freq;
            this.idx = idx;
        }
    }

    void dfs(Node root, String code, ArrayList<String> ans) {

        if (root.left == null && root.right == null) {
            if (code.length() == 0) code = "0";
            ans.add(code);
            return;
        }

        dfs(root.left, code + "0", ans);
        dfs(root.right, code + "1", ans);
    }

    public ArrayList<String> huffmanCodes(String s, int f[]) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq)
                return a.freq - b.freq;

            return a.idx - b.idx;
        });

        for (int i = 0; i < f.length; i++) {
            pq.offer(new Node(f[i], i));
        }

        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(
                left.freq + right.freq,
                Math.min(left.idx, right.idx)
            );

            parent.left = left;
            parent.right = right;

            pq.offer(parent);
        }

        Node root = pq.poll();

        ArrayList<String> ans = new ArrayList<>();
        dfs(root, "", ans);

        return ans;
    }
}