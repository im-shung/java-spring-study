package arrayAndString;

/*
순열 확인: 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드를 작성하라.
주의할 점
- 대소문자를 구별해서 따져야 하는가?
- 공백은 어떻게 처리해야 하는지?
 */
public class Problem2 {

    /*
        #1. 두 문자열이 순열관계에 있다는 말이 무슨 의미인지 설명해 보라. 그 정의에 따라 문자열을 확인할 수 있겠는가?
        #2. O(n long n) 시간의 해법이 하나 존재한다. 다른 해법은 추가 공간을 사용하지만 O(n) 시간이 걸린다.
        #3. 해시테이블이 유용한가?
        #4. 서로 순열 관계에 있는 두 문자열은 같은 문자 집합으로 이루어져 있고, 그 순서만 다를 것이다. 순서도 같게 만들 수 있는가?
     */

    public static void main(String[] args) {
        String s = "god";
        String t = "dog";
    }

    // 풀이 #1: 정렬하라
    public String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content); // 어떤 정렬 알고리즘을 사용하는가?
        return new String(content);
    }

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(t);
    }

    // 풀이 #2: 문자열에 포함된 문자의 출현 횟수가 같은지 검사하라
    public boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++; // s 내에서 각 문자의 출현 횟수를 센다.
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
