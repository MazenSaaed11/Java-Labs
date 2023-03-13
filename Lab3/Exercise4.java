package Lab3;

import java.util.ArrayList;

public class Exercise4 {

    public static void main(String[] args) {
        MyString ms = new MyString("Absdkgjcd");
        ms.print();
        System.out.println(ms.indexOf('c'));
        System.out.println(ms.indexOf('g'));
        ms.erase(2,4);
        ms.print();
        ms.insert(2,"gfddf");
        ms.print();
    }
}
class MyString {

    ArrayList<Character> arr;

    MyString(String s) {
        arr = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++)
            arr.add(s.charAt(i));
    }

    public void print() {
        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i));

        System.out.println();
    }

    public int indexOf(char c) {
        for (int i = 0; i < arr.size(); i++)
            if (arr.get(i) == c)
                return i;

        return -1;
    }

    public void erase(int s, int length) {
        ArrayList<Character> arr2 = new ArrayList<Character>();
        int e = s + length - 1;
        for (int i = 0; i < arr.size(); i++) {
            if (!(i >= s && i <= e))
                arr2.add(arr.get(i));
        }
        arr = arr2;
    }

    public void insert(int idx, String s) {
        ArrayList<Character> arr2 = new ArrayList<Character>();
        for (int i = 0; i < idx; i++)
            arr2.add(arr.get(i));
        for (int i = 0; i < s.length(); i++)
            arr2.add(s.charAt(i));
        for (int i = idx; i < arr.size(); i++)
            arr2.add(arr.get(i));

        arr = arr2;
    }
}