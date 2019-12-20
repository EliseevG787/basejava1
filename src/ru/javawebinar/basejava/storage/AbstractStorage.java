package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

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
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private Object getExistResume(String uuid) {
        Object index = getIndex(uuid);
        if (isExistIndex(index)) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    protected abstract boolean isExistIndex(Object index);

    protected abstract Object getIndex(String uuid);

    protected abstract Resume getResume(Object index);

    protected abstract void deleteResume(Object index);

    protected abstract void updateResume(Object index, Resume resume);

    protected abstract void saveResume(Resume resume, Object index);
}
