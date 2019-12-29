package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
<<<<<<< HEAD
    protected static final int STORAGE_LIMIT = 10000;
=======
    protected static final int STORAGE_LIMIT = 10_000;
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
<<<<<<< HEAD
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
=======
    protected void updateResume(Object index, Resume resume) {
        storage[(Integer)index] = resume;
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public List<Resume> getAllSorted() {
        Resume[] arr = Arrays.copyOfRange(storage, 0, size);
        List<Resume> resumes = Arrays.asList(arr);
        Collections.sort(resumes);
        return resumes;
    }

    @Override
<<<<<<< HEAD
    protected void doSave(Resume r, Object index) {
=======
    protected void saveResume(Resume resume, Object index) {
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
<<<<<<< HEAD
            insertElement(r, (Integer) index);
=======
            insertElement(resume, (Integer)index);
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
            size++;
        }
    }

    @Override
<<<<<<< HEAD
    public void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
=======
    protected void deleteResume(Object index) {
        fillDeletedElement((Integer)index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume getResume(Object index) {
        return storage[(Integer)index];
    }

    @Override
    protected boolean isExistIndex(Object index) {
        return (Integer)index >= 0;
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

<<<<<<< HEAD
    protected abstract Integer getSearchKey(String uuid);
=======
    protected abstract Integer getIndex(String uuid);
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
}