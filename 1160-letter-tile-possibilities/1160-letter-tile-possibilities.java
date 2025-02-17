class Solution {
    Set<String> set = new HashSet<>();

    public void backtrack(String tiles, String word, boolean[] visited) {
        for(int i = 0; i < tiles.length(); i++) {
            if(visited[i]) continue;
            String seq = word + tiles.charAt(i);
            visited[i] = true;
            set.add(seq);
            backtrack(tiles, seq, visited);
            visited[i] = false;
        }
    }

    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tiles, "", visited);
        return set.size();
    }
}