package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;


public class MapUuidStorage extends AbstractStorage<String> {


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
    protected String searchUuid(String uuid) {
        return uuid;
    }

    @Override
    protected boolean validForExistResume(String searchKey) {
        return mapStorage.containsKey(searchKey);
    }

    @Override
    protected void saveResume(Resume resume, String searchKey) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume returnResume(String searchKey) {
        return mapStorage.get(searchKey);
    }

    @Override
    protected void deleteResume(String searchKey) {
        mapStorage.remove(searchKey);
    }

    @Override
    protected void updateResume(String searchKey, Resume resume) {
        mapStorage.replace(resume.getUuid(), resume);
    }
}
