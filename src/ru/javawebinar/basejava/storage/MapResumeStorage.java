package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, Object res) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object resume) {
        return map.containsValue(resume);
    }

    @Override
    protected void doSave(Resume resume, Object res) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        Collection<Resume> values = map.values();
        List<Resume> resumes = new ArrayList<>();
        resumes.addAll(0, values);
        Collections.sort(resumes);
        return resumes;
    }

    @Override
    public int size() {
        return map.size();
    }
}
