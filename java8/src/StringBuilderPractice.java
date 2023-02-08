import java.util.Arrays;

class MyStringBuilder {

    private char[] value;
    private int count;

    public MyStringBuilder() {
        this(16);
    }

    public MyStringBuilder(int capacity) {
        value = new char[capacity];
    }

    public MyStringBuilder(String str) {
        this(str.length() + 16);
        append(str);
    }

    public int length() {
        return count;
    }

    public int capacity() {
        return value.length;
    }

    public MyStringBuilder append(String str) {
        if (str == null) {
            str = "null";
        }
        int len = str.length();
        ensureCapacity(count + len);
        // 문자열에서 문자 배열로 문자들을 복사
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity - value.length > 0) {
            value = Arrays.copyOf(value, newCapacity(minimumCapacity));
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (value.length << 1) + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
                       ? hugeCapacity(minCapacity)
                       : newCapacity;
    }

    private int hugeCapacity(int minCapacity) {
        if (Integer.MAX_VALUE - minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE)
                       ? minCapacity : MAX_ARRAY_SIZE;
    }

    public String toString() {
        return new String(value, 0, count);
    }

}

public class StringBuilderPractice {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("aaa");
        System.out.println(sb.length() + " " + sb.capacity());

        MyStringBuilder msb = new MyStringBuilder();
        msb.append("aaa");
        System.out.println(msb.length() + " " + msb.capacity());

    }
}

