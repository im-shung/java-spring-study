package arrayAndString;

/*
중복이 없는가: 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘을 작성하라.
자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라.
 */
public class Problem1 {

    public static void main(String[] args) {
        String[] strs = {"avd", "avatar", "season", "hi", "vsdfsf"};
        for (String str : strs) {
            if (isUniqueChars(str)) {
                System.out.println("unique");
            } else {
                System.out.println("not unique");
            }
        }
    }

    /*
    시간 복잡도 O(n) (n은 문자열이 길이)
    공간 복잡도는 O(1)
     */
    private static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        int len = str.length();
        for (int idx = 0; idx < len; idx++) {
            int val = str.charAt(idx);
            if (charSet[val] == true) { // 이 문자는 이미 문자열 내에 있음
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    /*
    자료구조를 추가로 사용할 수 없다면 다음과 같이 할 수도 있다.
    1. 문자열 내의 각 문자를 다른 모든 문자와 비교한다. 이렇게 하면 O(N^2) 시간이 걸리고 공간 복잡도는 O(1)이 된다.
    2. 입력 문자열을 수정해도 된다면, O(n log n) 시간에 문자열을 정렬한 뒤 문자열을 처음부터 훑어 가면서 인접한 문자가 동일한지 검사해볼 수도 있다.
    이때 많은 정렬 알고리즘이 공간을 추가로 쓴다는 사실을 주의하라.
     */

}
