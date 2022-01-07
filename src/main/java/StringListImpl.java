import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] storage;
    private int size;

    public StringListImpl(int sizeStringArray) {
        if (sizeStringArray < 0) {
            throw new IllegalArgumentException("Недопустимый размер списка");
        }
        this.storage = new String[sizeStringArray];
    }

    private void validateIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Индекс превышает длину списка");
        }
    }

    private String add(String item, int index) {
        validateIndex(index);
        storage[index] = item;
        size++;
        return storage[index];
    }

    @Override
    public String add(String item) {
        if (size < storage.length) {
            return add(item, size);
        }
        if (size == storage.length) {
            grow();
        }
        return add(item, size);
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        if (storage.length < size + 1) {
            grow();
        }
        for (int i = index; i < size + 1; i++) {
            storage[i + 1] = storage[i];
        }
        return add(item, index);
    }

    private void grow() {
        String[] newStringArray = new String[storage.length + storage.length / 2];
        System.arraycopy(storage, 0, newStringArray, 0, storage.length);
        storage = newStringArray;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        storage[index] = item;
        return storage[index];
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        String strTemp = storage[index];
        if (index > 0) {
            System.arraycopy(storage, index + 1, storage, index, storage.length - index - 1);
            size--;
            return strTemp;
        }
        throw new IllegalArgumentException("Элемента нет в списке");
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String strTemp = storage[index];
        System.arraycopy(storage, index + 1, storage, index, storage.length - index - 1);
        size--;
        return strTemp;
    }

    @Override
    public boolean contains(String item) {

        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = storage.length - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(String[] otherList) {
        if (storage.length != otherList.length) {
            return false;
        }
        return Arrays.equals(toArray(), otherList);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }
}
