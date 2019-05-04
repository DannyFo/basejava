package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() && !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected File searchUuid(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean validForExistResume(File file) {
        return file.exists();
    }

    @Override
    protected void saveResume(Resume resume, File file) {
        try {
            file.createNewFile();
            doWrite(resume, file);

        } catch (IOException e) {
            throw new StorageException("I0 error", file.getName(), e);
        }
    }

    @Override
    protected Resume returnResume(File file) {
        return doRead(file);
    }

    @Override
    protected void deleteResume(File file) {
        file.delete();
    }

    @Override
    protected void updateResume(File file, Resume resume) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("I0 error", file.getName(), e);
        }
    }

    @Override
    protected List<Resume> getList() {
        ArrayList<Resume> listResume = new ArrayList<>();
        File[] list = directory.listFiles();
        if (list != null) {
            for (File file : list) {
                listResume.add(doRead(file));
            }
        }
        return listResume;
    }

    @Override
    public void clear() {
        directory.delete();
    }

    @Override
    public int size() {
        return directory.list().length;
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;


    protected abstract Resume doRead(File file);
}
