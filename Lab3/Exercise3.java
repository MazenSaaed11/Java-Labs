package Lab3;

import java.util.ArrayList;

public class Exercise3 {
    public static void main(String[] args) {
        MyStringBuffer m = new MyStringBuffer();
        m.insert(0,"8565");
        m.print();
        m.insert(2,"hgf");
        m.print();
        m.erase(1,3);
        m.print();
        System.out.println(m.indexOf('8'));
    }
}


class MyStringBuffer {
    private ArrayList<Character> a;


    MyStringBuffer() {
        a = new ArrayList<Character>();
    }

    void print() {
        for (Character c : a)
            System.out.print(c);

        System.out.println();
    }

    int indexOf(char c) {
        for (int i = 0; i < a.size(); i++)
            if (a.get(i) == c)
                return i;

        return -1;
    }

    int length() {
        return a.size();
    }

    void erase(int idx, int length) {
        for (int i = idx; i < a.size();) {
            if (length == 0)
                break;

            length--;
            a.remove(i);
        }
    }

    void insert(int idx, String str) {
        for (int i = 0; i < str.length(); i++)
            a.add(idx + i, str.charAt(i));
    }

}