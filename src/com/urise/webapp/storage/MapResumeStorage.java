package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;


public class MapResumeStorage extends AbstractStorage {



    private Map<String , Resume> mapStorage = new HashMap<>();


    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    protected List<Resume> getArrayList () {
        return new ArrayList<>(mapStorage.values());
    }
    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    protected Object searchUuid(String uuid) {//возвращает резюме
        return mapStorage.get(uuid);
    }

    @Override
    protected boolean validForExistResume(Object searchKey) {
        return mapStorage.containsValue(searchKey);
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
        saveResume(resume, searchKey);
        mapStorage.get(resume.getUuid());
    }
}
