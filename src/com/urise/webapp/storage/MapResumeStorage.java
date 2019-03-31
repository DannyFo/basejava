package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;


public class MapResumeStorage extends AbstractStorage {


    private Map<String , Resume> mapStorage = new HashMap<>();

    private static final Comparator<Resume> RESUME_COMPARATOR_BY_FULLNAME = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> allSortedList = new ArrayList<>(mapStorage.values());
        allSortedList.sort(RESUME_COMPARATOR_BY_FULLNAME);
        return allSortedList;
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
