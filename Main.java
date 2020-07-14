import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        String sentence = br.readLine();
        for (int i=0;i<sentence.length();i++) {
            left.push(sentence.charAt(i)); // 문장의 끝으로 포인터 설정
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String Command = br.readLine();
            switch (Command) {
                case "L" :
                    if (!left.empty()) {
                        char temp = left.pop();
                        right.push(temp);
                    }
                    break;
                case "D" :
                    if (!right.empty()) {
                        char temp = right.pop();
                        left.push(temp);
                    }
                    break;
                case "B" :
                    if (!left.empty()) {
                        left.pop();
                    }
                    break;
                default :
                    char word = Command.charAt(2);
                    left.push(word);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.empty()) {
            right.push(left.pop());
        }
        while (!right.empty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
        br.close();
    }
}
