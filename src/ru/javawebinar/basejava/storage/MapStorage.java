package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;

public class MapStorage  extends AbstractStorage {
    HashMap<String, Resume> hm = new HashMap<String, Resume>();

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected Resume getRes(int index) {
        return null;
    }

    @Override
    protected void delRes(int index) {

    }

    @Override
    protected void setRes(int index, Resume r) {

    }

    @Override
    protected void saveRes(Resume r) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
