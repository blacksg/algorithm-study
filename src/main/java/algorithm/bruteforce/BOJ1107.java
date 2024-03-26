package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1107">리모컨</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 브루트포스
 */
class BOJ1107 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int targetChannel = Integer.parseInt(reader.readLine());
        int answer = 0;
        if (targetChannel != 100) {
            // 기본값 : 100번 채널에서 +/- 버튼만 눌러서 이동하는 경우
            answer = Math.abs(targetChannel - 100);
            // 각 버튼에 대한 고장 여부 저장
            boolean[] broken = new boolean[10];
            int brokenButtonCount = Integer.parseInt(reader.readLine());
            if (brokenButtonCount > 0) {
                String[] strings = reader.readLine().split(" ");
                for (int i = 0; i < brokenButtonCount; i++) {
                    broken[Integer.parseInt(strings[i])] = true;
                }
            }
            // 0번 채널로 이동한 뒤 +/- 버튼으로 이동하는 경우
            if (!broken[0]) {
                answer = Math.min(answer, targetChannel + 1);
            }
            // 1 ~ 999999번 채널로 이동한 뒤 +/- 버튼으로 이동하는 경우
            channelLoop:
            for (int channel = 1; channel <= 999999; channel++) {
                int digitCount = 0;
                int n = channel;
                while (n > 0) {
                    if (broken[n % 10]) continue channelLoop;
                    digitCount++;
                    n /= 10;
                }
                answer = Math.min(answer, digitCount + Math.abs(channel - targetChannel));
            }
        }
        System.out.println(answer);
        reader.close();
    }
}
