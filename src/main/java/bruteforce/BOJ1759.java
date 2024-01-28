package bruteforce;

import java.io.*;
import java.util.Arrays;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1759">암호 만들기</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 브루트포스, 조합론
 */
class BOJ1759 {
    
    private static final StringBuilder builder = new StringBuilder();
    
    private static int length;
    
    private static int characterCount;
    
    private static String[] characters;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = reader.readLine().split(" ");
        length = Integer.parseInt(info[0]);
        characterCount = Integer.parseInt(info[1]);
        characters = reader.readLine().split(" ");
        
        Arrays.sort(characters);
        searchCandidates(0, 0, "", 0);
        writer.write(builder.toString());
        
        reader.close();
        writer.close();
    }
    
    private static void searchCandidates(int currentStep, int currentIndex, String candidate, int vowelCount) {
        if (currentStep == length) {
            if (1 <= vowelCount && vowelCount <= length - 2) {
                builder.append(candidate).append('\n');
            }
            return;
        }
        for (int i = currentIndex; i <= characterCount - length + currentStep; i++) {
            searchCandidates(
                currentStep + 1,
                i + 1,
                candidate + characters[i],
                vowelCount + (isVowel(characters[i]) ? 1 : 0)
            );
        }
    }
    
    private static boolean isVowel(String character) {
        switch (character) {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return true;
            default:
                return false;
        }
    }
}
