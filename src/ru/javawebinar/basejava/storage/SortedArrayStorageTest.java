package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Override
    protected Resume[] ArrayEquals(Resume r2, Resume r3) {
        return new Resume[]{r2, r3};
    }
}
