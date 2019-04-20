package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;


public class MapResumeStorage extends AbstractStorage<Resume> {

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
    protected Resume searchUuid(String uuid) {//возвращает резюме
        return mapStorage.get(uuid);
    }

    @Override
    protected boolean validForExistResume(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected void saveResume(Resume resume, Resume searchKey) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume returnResume(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void deleteResume(Resume searchKey) {
        mapStorage.remove(searchKey.getUuid());
    }

    @Override
    protected void updateResume(Resume searchKey, Resume resume) {
        mapStorage.replace(resume.getUuid(), resume);
    }
}
