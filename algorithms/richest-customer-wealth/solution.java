class Solution {
    public int mostWordsFound(String[] sentences) {
        int len1 = 0;
        for (int i = 0; i < sentences.length; i++) {
            int wordCount = sentences[i].split(" ").length;
            if (wordCount > len1) {
                len1 = wordCount;
            }
        }
        return len1;
    }
}