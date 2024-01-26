package bruteforce;

import java.io.*;
import java.util.*;

/**
 * @문제 <a href="https://www.acmicpc.net/problem/1107">리모컨</a>
 * @사이트 백준
 * @난이도 GOLD V
 * @알고리즘 브루트포스
 */
class BOJ1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        int targetChannel = Integer.parseInt(reader.readLine());
        if (targetChannel != 100) {
            // 기본값: 100에서 target까지 + 또는 -만 눌러서 이동한 카운트
            count = Math.abs(100 - targetChannel);

            // 고장난 버튼이 하나라도 있으면 broken 배열 수정
            boolean[] broken = new boolean[10];
            int brokenButtonCount = Integer.parseInt(reader.readLine());
            if (brokenButtonCount > 0) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int i = 0; i < brokenButtonCount; i++) {
                    broken[Integer.parseInt(tokenizer.nextToken())] = true;
                }
            }

            // 0번 채널
            if (!broken[0]) {
                count = Math.min(count, targetChannel + 1);
            }

            // 1~999999번 채널
            outer:
            for (int currentChannel = 1; currentChannel <= 999999; currentChannel++) {
                int digitCount = 0;
                int n = currentChannel;
                while (n > 0) {
                    if (broken[n % 10]) {
                        continue outer;
                    }
                    digitCount++;
                    n /= 10;
                }
                count = Math.min(count, digitCount + Math.abs(currentChannel - targetChannel));
            }
        }

        // target이 100이면 바로 0 출력
        writer.write(Integer.toString(count));
        reader.close();
        writer.close();
    }
}
