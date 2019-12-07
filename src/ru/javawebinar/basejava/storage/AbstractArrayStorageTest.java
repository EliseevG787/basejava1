package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @org.junit.Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @org.junit.Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @org.junit.Test
    public void update() {
        Resume r = new Resume(UUID_1);
        storage.update(r);
        Assert.assertEquals(r, storage.get(UUID_1));
    }

    @org.junit.Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume r = new Resume("uuid4");
        storage.update(r);
    }

    @org.junit.Test
    public void getAll() {
        Resume r1 = new Resume(UUID_1);
        Resume r2 = new Resume(UUID_2);
        Resume r3 = new Resume(UUID_3);
        Resume[] r = {r1, r2, r3};
        Assert.assertArrayEquals(r, storage.getAll());
    }

    @org.junit.Test
    public void save() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        Assert.assertEquals(r, storage.get("uuid4"));
    }

    @org.junit.Test(expected = ExistStorageException.class)
    public void saveExist() {
        Resume r = new Resume(UUID_1);
        storage.save(r);
    }

    @org.junit.Test(expected = StorageException.class)
    public void saveOverflow() {
        for (int i = 0; i < 9998; i++) {
            String UUID = Integer.toString(i);
            storage.save(new Resume(UUID));
        }
    }

    @org.junit.Test
    public void saveNotOverflow() {
        try {
            for (int i = 0; i < 9997; i++) {
                String UUID = Integer.toString(i);
                storage.save(new Resume(UUID));
            }
        } catch (StorageException e) {
            Assert.fail("Test failed");
        }
    }

    @org.junit.Test
    public void delete() {
        storage.delete(UUID_1);
        Resume r2 = new Resume(UUID_2);
        Resume r3 = new Resume(UUID_3);
        Resume[] r = ArrayEquals(r2, r3);
        Assert.assertArrayEquals(r, storage.getAll());
    }

    @org.junit.Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("uuid4");
    }

    @org.junit.Test
    public void get() {
        Resume r = new Resume(UUID_1);
        Assert.assertEquals(r, storage.get(UUID_1));
    }

    @org.junit.Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    protected abstract Resume[] ArrayEquals(Resume r2, Resume r3);
}