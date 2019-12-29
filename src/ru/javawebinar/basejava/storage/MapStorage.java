package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> tmStorage = new TreeMap<>();

    @Override
    protected boolean isExistIndex(Object index) {
        return tmStorage.containsKey(index);
    }

    @Override
    protected String getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getResume(Object index) {
        return tmStorage.get(index);
    }

    @Override
    protected void deleteResume(Object index) {
        tmStorage.remove(index);
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        tmStorage.put((String) index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        tmStorage.put((String) index, resume);
    }

    @Override
    public void clear() {
        tmStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume resumes[] = new Resume[tmStorage.size()];
        return tmStorage.values().toArray(resumes);
    }

    @Override
    public int size() {
        return tmStorage.size();
    }
}

