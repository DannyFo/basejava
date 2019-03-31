package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    void update(Resume r);

//    Resume getByFullName(String fullName);


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    //TODO
    // List<Resume> getAllSorted();
    // return list, sorted by name;
    List<Resume> getAllSorted();

    int size();

}
