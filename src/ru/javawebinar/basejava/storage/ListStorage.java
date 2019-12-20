package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume resumes[] = new Resume[storage.size()];
        return storage.toArray(resumes);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Resume getResume(Object  index) {
        return storage.get((Integer)index);
    }

    @Override
    protected void deleteResume(Object  index) {
        storage.remove(((Integer)index).intValue());
    }

    @Override
    protected void updateResume(Object  index, Resume resume) {
        storage.set((Integer)index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Object  index) {
        storage.add(resume);
    }

    @Override
    protected Integer getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExistIndex(Object  index) {
        return index != null;
    }
}
