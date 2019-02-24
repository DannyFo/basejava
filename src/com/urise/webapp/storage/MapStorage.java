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
    protected int searchUuid(String uuid) {
        if (mapStorage.containsKey(uuid)) {
            return 1;
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume r, int foundIndex) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected Resume returnResume(int foundIndex, String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    protected void deleteResume(int foundIndex, String uuid) {
        mapStorage.remove(uuid);
    }

    @Override
    protected Resume updateResume(int foundIndex, Resume r) {
        saveResume(r, foundIndex);
        return mapStorage.get(r.getUuid());
    }
}
