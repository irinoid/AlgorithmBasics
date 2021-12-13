import java.util.Arrays;

public class CorrectWorkCheck {

    public static void main(String[] args) {
        final StringListImpl stringList = new StringListImpl();
        // stringList.add("pqr");
        // stringList.add(2,"123");
        // stringList.set(3,"вася");
        // stringList.remove("abc");
        // stringList.remove(2);
        // System.out.println(stringList.contains("mno"));
        // System.out.println(stringList.indexOf("pqr"));
        // System.out.println(stringList.lastIndexOf("ghi"));
        // System.out.println(stringList.get(4));
        // String[] otherList = new String[]{"abc", "def", "ghi", "jkl"};
        // System.out.println(stringList.equals(otherList));
        // System.out.println(stringList.size());
        // System.out.println(stringList.isEmpty());
        // stringList.clear();
        // stringList.toArray();

        System.out.println(Arrays.toString(stringList.getArray()));
    }
}
