package ru.javawebinar.basejava.storage;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void fillArray(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void sortArray() {

    }
}

