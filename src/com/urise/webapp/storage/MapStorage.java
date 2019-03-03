package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class MapStorage extends AbstractStorage {


    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] storage = mapStorage.values().toArray(new Resume[mapStorage.size()]);
        Arrays.sort(storage, new SortByUuid());
        return storage;
    }

    class SortByUuid implements Comparator<Resume> {
        public int compare(Resume a, Resume b) {
            return (a.getUuid().compareTo(b.getUuid()));
        }
    }

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    protected Object searchUuid(String uuid) {
        return uuid;
    }

    @Override
    protected boolean validForExistResume(Object searchKey) {
        return mapStorage.containsKey(searchKey);
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
    protected void updateResume(Object searchKey, Resume r) {
        saveResume(r, searchKey);
        mapStorage.get(r.getUuid());
    }
}
