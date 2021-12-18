import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] stringArray;

    public StringListImpl(int sizeStringArray) {
        this.stringArray = new String[sizeStringArray];
    }

    @Override
    public String add(String item) {

        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == null) {
                stringArray[i] = item;
                return stringArray[i];
            }
        }
        String[] stringArrayTemp = new String[stringArray.length + 10];
        int sizeArray = stringArray.length;
        System.arraycopy(stringArray, 0, stringArrayTemp, 0, stringArray.length);
        stringArrayTemp[stringArray.length] = item;
        stringArray = stringArrayTemp;
        return stringArray[sizeArray];
    }

    @Override
    public String add(int index, String item) {
        for (int i = 0; i < index; i++) {
            if (stringArray[i] == null) {
                throw new IndexOutOfBoundsException("Индекс превышает длину списка");
            }
        }
        if (index < stringArray.length - 1) {
            String[] stringArrayTemp = new String[stringArray.length + 1];
            System.arraycopy(stringArray, 0, stringArrayTemp, 0, index);
            stringArrayTemp[index] = item;
            System.arraycopy(stringArray, index, stringArrayTemp, index + 1, stringArray.length - index - 1);
            stringArray = stringArrayTemp;
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Индекс превышает длину массива");
    }

    @Override
    public String set(int index, String item) {
        for (int i = 0; i < index; i++) {
            if (stringArray[i] == null) {
                throw new IndexOutOfBoundsException("Индекс превышает длину списка");
            }
        }
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
                for (int j = i + 1; j < stringArray.length; j++) {
                    stringArray[j] = stringArray[j - 1];
                }
                String[] stringArrayTemp = new String[stringArray.length - 1];
                System.arraycopy(stringArray, 0, stringArrayTemp, 0, stringArray.length - 1);
                stringArray = stringArrayTemp;
                return strTemp;
            }
        }
        throw new IllegalArgumentException("Элемента нет в списке");
    }

    @Override
    public String remove(int index) {
        if (index < stringArray.length) {
            String strTemp = stringArray[index];
            for (int i=index; i<stringArray.length; i++){
                stringArray[i]=stringArray[i+1];
            }
            String[] stringArrayTemp = new String[stringArray.length - 1];
            System.arraycopy(stringArray, 0, stringArrayTemp, 0, stringArray.length - 1);
            stringArray = stringArrayTemp;
            return strTemp;
        }
        throw new IndexOutOfBoundsException("Индекс превышает длину массива");
    }

    @Override
    public boolean contains(String item) {
        for (int i=0; i< stringArray.length;i++) {
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
        if (index < stringArray.length) {
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Индекс превышает размер массива");
    }

    @Override
    public boolean equals(String[] otherList) {
        if (stringArray.length != otherList.length) {
            return false;
        } else {
            for (int i = 0; i < stringArray.length; i++) {
                if (!stringArray[i].equals(otherList[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        int listSize = 0;
        for (int i=0;i< stringArray.length;i++) {
            if (!stringArray[i].equals(null)){
                listSize++;
            }
        }
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        for (int i=0; i< stringArray.length; i++) {
            if (!stringArray[i].equals(null)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(stringArray, null);
    }

    @Override
    public String[] toArray() {
        String[] newStringArray = new String[stringArray.length];
        int j = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] != null) {
                newStringArray[j] = stringArray[i];
                j++;
            }
        }
        return newStringArray;
    }
}
