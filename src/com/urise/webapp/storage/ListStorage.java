package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList<>();

    private static final Comparator<Resume> RESUME_COMPARATOR_BY_FULLNAME = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> allSortedList = new ArrayList<>(listStorage);
        allSortedList.sort(RESUME_COMPARATOR_BY_FULLNAME);
        return allSortedList;
//        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    protected Integer searchUuid(String uuid) {
        for (int counter = 0; counter < listStorage.size(); counter++) {
            if (listStorage.get(counter).getUuid().equals(uuid)) {
                return counter;
            }
        }
        return -1;
    }

    @Override
    protected boolean validForExistResume(Object searchKey) {
        return ((Integer) searchKey >= 0);
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        listStorage.add(r);
    }

    @Override
    protected Resume returnResume(Object searchKey) {
        return listStorage.get((Integer) searchKey);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        listStorage.remove(((Integer) searchKey).intValue());
    }

    @Override
    protected void updateResume(Object searchKey, Resume r) {
        listStorage.set((Integer) searchKey, r);
    }
}
