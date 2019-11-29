package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillArray(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }

    @Override
    protected void sortArray() {
        int index = Arrays.binarySearch(storage, 0, size, storage[size - 1]);
        if (index < 0) {
            index = -(index) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = storage[size];
            storage[size] = null;
        }
    }
}

