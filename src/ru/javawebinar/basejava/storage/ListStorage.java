package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    private ArrayList<Resume> resumes = new ArrayList<>();

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
    protected Resume getResume(Integer index) {
        return resumes.get(index);
    }

    @Override
    protected void deleteResume(Integer index) {
        resumes.remove(index.intValue());
    }

    @Override
    protected void updateResume(Integer index, Resume resume) {
        resumes.set(index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Integer index) {
        resumes.add(resume);
    }

    @Override
    protected Integer getIndex(String uuid) {
        for (int i = 0; i < resumes.size(); i++) {
            if (uuid.equals(resumes.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }
}
