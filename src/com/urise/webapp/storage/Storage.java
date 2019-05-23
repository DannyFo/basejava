package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;


public interface Storage {

    void clear();

    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    void update(Resume resume);

    List<Resume> getAllSorted();

    int size();

}
