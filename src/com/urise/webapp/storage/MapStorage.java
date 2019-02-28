package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;


public class MapStorage extends AbstractStorage {


    Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return mapStorage.values().toArray(new Resume[mapStorage.size()]);
    }

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    protected Object searchUuid(String uuid) {
        if (mapStorage.containsKey(uuid)) {
            return uuid;
        }
        return -1;
    }

    @Override
    protected boolean validForExistResume(Object searchKey) {
        return mapStorage.containsKey(searchKey);
    }

    @Override
    protected boolean validForNotExistResume(Object searchKey) {
        return !mapStorage.containsKey(searchKey);
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected Resume returnResume(Object searchKey) {
        return mapStorage.get(searchKey);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        mapStorage.remove(searchKey);
    }

    @Override
    protected Resume updateResume(Object searchKey, Resume r) {
        saveResume(r, searchKey);
        return mapStorage.get(r.getUuid());
    }
}
