package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

<<<<<<< HEAD
    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

    public void update(Resume r) {
        Object searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNotExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
=======
    public Resume get(String uuid) {
        Object index = getNotExistResume(uuid);
        return getResume(index);
    }

    public void delete(String uuid) {
        Object index = getNotExistResume(uuid);
        deleteResume(index);
    }

    public void update(Resume resume) {
        Object index = getNotExistResume(resume.getUuid());
        updateResume(index, resume);
    }

    public void save(Resume resume) {
        Object index = getExistResume(resume.getUuid());
        saveResume(resume, index);
    }

    private Object getNotExistResume(String uuid) {
        Object index = getIndex(uuid);
        if (!isExistIndex(index)) {
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

<<<<<<< HEAD
    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
=======
    private Object getExistResume(String uuid) {
        Object index = getIndex(uuid);
        if (isExistIndex(index)) {
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
<<<<<<< HEAD
}
=======

    protected abstract boolean isExistIndex(Object index);

    protected abstract Object getIndex(String uuid);

    protected abstract Resume getResume(Object index);

    protected abstract void deleteResume(Object index);

    protected abstract void updateResume(Object index, Resume resume);

    protected abstract void saveResume(Resume resume, Object index);
}
>>>>>>> de240463f5c7805f764ac172f128e2640f081a7a
