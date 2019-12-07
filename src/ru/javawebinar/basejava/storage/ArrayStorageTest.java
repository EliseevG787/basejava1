package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class ArrayStorageTest extends AbstractArrayStorageTest{

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Override
    protected Resume[] ArrayEquals(Resume r2, Resume r3) {
        return new Resume[]{r3, r2};
    }
}