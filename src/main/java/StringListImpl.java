import java.util.ArrayList;
import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] stringArray;

    public StringListImpl(int sizeStringArray) {
        if (sizeStringArray > 0) {
            this.stringArray = new String[sizeStringArray];
        } else {
            throw new IllegalArgumentException("Недопустимый размер списка");
        }
    }

    private int size = size();

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Индекс превышает длину списка");
    }

    private String add(String item, int index) {
        rangeCheckForAdd(index);
        stringArray[index] = item;
        size++;
        return stringArray[index];
    }

    @Override
    public String add(String item) {
        if (size < stringArray.length) {
            return add(item, size);
        }
        String[] stringArrayTemp = new String[stringArray.length + 10];
        System.arraycopy(stringArray, 0, stringArrayTemp, 0, size);
        stringArray = stringArrayTemp;
        return add(item, size);
    }

    @Override
    public String add(int index, String item) {
        rangeCheckForAdd(index);
        if (stringArray.length < size + 1) {
            String[] stringArrayTemp = new String[stringArray.length + 10];
            System.arraycopy(stringArray, 0, stringArrayTemp, 0, stringArray.length);
            stringArray = stringArrayTemp;
        }
        for (int i = index; i < size + 1; i++) {
            stringArray[i + 1] = stringArray[i];
        }
        return add(item, index);
    }

    @Override
    public String set(int index, String item) {
        rangeCheckForAdd(index);
        stringArray[index] = item;
        return stringArray[index];
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        String strTemp = stringArray[index];
        if (index>0){
                for (int j = index; j < stringArray.length; j++) {
                    stringArray[j] = stringArray[j - 1];
                }
                size--;
                return strTemp;
            }
        throw new IllegalArgumentException("Элемента нет в списке");
    }

    @Override
    public String remove(int index) {
        rangeCheckForAdd(index);
        String strTemp = stringArray[index];
        for (int i = index; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i + 1];
        }
        size--;
        return strTemp;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i <= size; i++) {
            if (stringArray[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringArray.length - 1; i >= 0; i--) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        rangeCheckForAdd(index);
        return stringArray[index];
    }

    @Override
    public boolean equals(String[] otherList) {
        if (stringArray.length != otherList.length) {
            return false;
        }
        return Arrays.equals(stringArray, otherList);
    }

    @Override
    public int size() {
        for (int i = 0; i < stringArray.length; i++) {
            if (!stringArray[i].equals(null)) {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(stringArray, null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newStringArray = new String[stringArray.length];
        int j = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (!stringArray[i].equals(null)) {
                newStringArray[j] = stringArray[i];
                j++;
            }
        }
        return newStringArray;
    }
}
