package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    ArrayList<Resume> resumes = new ArrayList<>();

    @Override
    public void clear() {
        resumes.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume res[] = new Resume[resumes.size()];
        return resumes.toArray(res);
    }

    @Override
    public int size() {
        return resumes.size();
    }

    @Override
    protected Resume getRes(int index) {
        return resumes.get(index);
    }

    @Override
    protected void delRes(int index) {
        resumes.remove(index);
    }

    @Override
    protected void setRes(int index, Resume r) {
        resumes.set(index, r);
    }

    @Override
    protected void saveRes(Resume r) {
        resumes.add(r);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return resumes.indexOf(searchKey);
    }
}
