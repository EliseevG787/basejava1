package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        sort();
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    private void sort() {
        for (int k = 0; k < size; k++) {
            Resume newElement = storage[k];
            int index = Arrays.binarySearch(storage, 0, size, newElement);
            if (index < 0) {
                index = -(index) - 1;
            }
            System.arraycopy(storage, index, storage, index + 1, k - index);
            storage[index] = newElement;
        }
    }
}
