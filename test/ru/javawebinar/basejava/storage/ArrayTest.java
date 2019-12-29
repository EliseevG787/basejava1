package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class ArrayTest extends AbstractStorageTest{
    protected ArrayTest(Storage storage) {
        super(storage);
    }

   @Test(expected = StorageException.class)
    public void saveOverflow() {
       storage.clear();
       try {
           for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
               storage.save(new Resume("fullName"));
           }
       } catch (StorageException e) {
           Assert.fail("Test failed");
       }
       storage.save(new Resume("fullName"));
    }
}
