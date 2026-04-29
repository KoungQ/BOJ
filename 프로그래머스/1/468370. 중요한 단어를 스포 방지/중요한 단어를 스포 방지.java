import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        int rangeCount = spoiler_ranges.length;

        Set<String> normalWords = new HashSet<>();
        List<List<String>> revealedAt = new ArrayList<>();

        for (int i = 0; i < rangeCount; i++) {
            revealedAt.add(new ArrayList<>());
        }

        int rangeIdx = 0;
        int i = 0;

        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int wordStart = i;

            while (i < n && message.charAt(i) != ' ') {
                i++;
            }

            int wordEnd = i - 1;
            String word = message.substring(wordStart, wordEnd + 1);

            while (rangeIdx < rangeCount && spoiler_ranges[rangeIdx][1] < wordStart) {
                rangeIdx++;
            }

            boolean isSpoilerWord = false;
            int revealIndex = -1;

            int j = rangeIdx;
            while (j < rangeCount && spoiler_ranges[j][0] <= wordEnd) {
                isSpoilerWord = true;
                revealIndex = j;
                j++;
            }

            if (isSpoilerWord) {
                revealedAt.get(revealIndex).add(word);
            } else {
                normalWords.add(word);
            }
        }

        int answer = 0;
        Set<String> alreadyRevealed = new HashSet<>();

        for (int click = 0; click < rangeCount; click++) {
            for (String word : revealedAt.get(click)) {
                if (!normalWords.contains(word) && !alreadyRevealed.contains(word)) {
                    answer++;
                    alreadyRevealed.add(word);
                } else {
                    alreadyRevealed.add(word);
                }
            }
        }

        return answer;
    }
}