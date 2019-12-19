package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public Resume get(String uuid) {
        Integer index = getNotExistResume(uuid);
        return getResume(index);
    }

    public void delete(String uuid) {
        Integer index = getNotExistResume(uuid);
        deleteResume(index);
    }

    public void update(Resume resume) {
        Integer index = getNotExistResume(resume.getUuid());
        updateResume(index, resume);
    }

    public void save(Resume resume) {
        Integer index = getExistResume(resume.getUuid());
        saveResume(resume, index);
    }


    private Integer getNotExistResume(String uuid) {
        Integer index = getIndex(uuid);
        if (!isExistIndex(index)) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private Integer getExistResume(String uuid) {
        Integer index = getIndex(uuid);
        if (isExistIndex(index)) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }


    protected abstract boolean isExistIndex(Integer index);

    protected abstract Integer getIndex(String uuid);

    protected abstract Resume getResume(Integer index);

    protected abstract void deleteResume(Integer index);

    protected abstract void updateResume(Integer index, Resume resume);

    protected abstract void saveResume(Resume resume, Integer index);
}
