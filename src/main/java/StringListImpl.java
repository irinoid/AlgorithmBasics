import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] stringArray;

    public StringListImpl() {
        this.stringArray = new String[]{"abc", "def", "ghi", "jkl", "mno"};
    }

    @Override
    public String[] getArray() {
        return stringArray;
    }

    @Override
    public String add(String item) {
        String[] stringArrayTemp = new String[stringArray.length + 1];
        System.arraycopy(stringArray, 0, stringArrayTemp, 0, stringArray.length);
        stringArrayTemp[stringArrayTemp.length - 1] = item;
        stringArray = Arrays.copyOf(stringArrayTemp, stringArrayTemp.length);
        return stringArray[stringArray.length - 1];
    }

    @Override
    public String add(int index, String item) {
        if (index < stringArray.length - 1) {
            String[] stringArrayTemp = new String[stringArray.length + 1];
            System.arraycopy(stringArray, 0, stringArrayTemp, 0, index);
            stringArrayTemp[index] = item;
            for (int i = index; i < stringArray.length; i++) {
                stringArrayTemp[i + 1] = stringArray[i];
            }
            stringArray = Arrays.copyOf(stringArrayTemp, stringArrayTemp.length);
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Индекс превышает длину массива");
    }

    @Override
    public String set(int index, String item) {
        if (index < stringArray.length - 1) {
            stringArray[index] = item;
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Индекс превышает длину массива");
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == item) {
                String strTemp = stringArray[i];
                String[] stringArrayTemp = new String[stringArray.length - 1];
                if (!(i == 0)) {
                    System.arraycopy(stringArray, 0, stringArrayTemp, 0, i - 1);
                    //System.arraycopy(stringArray, i + 1, stringArrayTemp, i, stringArrayTemp.length);
                }
                System.arraycopy(stringArray, i + 1, stringArrayTemp, i, stringArray.length - i - 1);
                stringArray = Arrays.copyOf(stringArrayTemp, stringArrayTemp.length);
                return strTemp;
            }
        }
        throw new IllegalArgumentException("Элемента нет в списке");

    }

    @Override
    public String remove(int index) {
        if (index < stringArray.length) {
            String strTemp = stringArray[index];
            String[] stringArrayTemp = new String[stringArray.length - 1];
            if (index != 0) {
                System.arraycopy(stringArray, 0, stringArrayTemp, 0, index);
            }
            System.arraycopy(stringArray, index + 1, stringArrayTemp, index, stringArray.length - index - 1);
            stringArray = Arrays.copyOf(stringArrayTemp, stringArrayTemp.length);
            return strTemp;
        }
        throw new IndexOutOfBoundsException("Индекс превышает длину массива");
    }

    @Override
    public boolean contains(String item) {
        for (String i : stringArray) {
            if (i == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringArray.length - 1; i >= 0; i--) {
            if (stringArray[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < stringArray.length) {
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Индекс превышает размер массива");
    }

    @Override
    public boolean equals(String[] otherList) {
        boolean arrEqual = true;
        if (stringArray.length != otherList.length) {
            arrEqual = false;
        } else {
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i] != otherList[i]) {
                    arrEqual = false;
                    break;
                }
            }
        }
        return arrEqual;
    }

    @Override
    public int size() {
        int arrSize = 0;
        for (String i : stringArray) {
            if ((i != null) && (i != "")) {
                arrSize++;
            }
        }
        return arrSize;
    }

    @Override
    public boolean isEmpty() {
        boolean arrEmpty = true;
        for (String i : stringArray) {
            if ((i != null)) {
                arrEmpty = false;
                break;
            }
        }
        return arrEmpty;
    }

    @Override
    public void clear() {
        for (String i : stringArray) {
            i = null;
        }
    }

    @Override
    public String[] toArray() {
        stringArray = new String[]{"", "", "", ""};
        return stringArray;
    }
}
