package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;


public class MapUuidStorage extends AbstractStorage {


    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    protected List<Resume> getList() {
        return new ArrayList<>(mapStorage.values());
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
    protected void saveResume(Resume resume, Object searchKey) {
        mapStorage.put(resume.getUuid(), resume);
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
    protected void updateResume(Object searchKey, Resume resume) {
        mapStorage.replace(resume.getUuid(),resume);
    }
}
