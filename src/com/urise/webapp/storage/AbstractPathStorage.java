package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected Path searchUuid(String uuid) {
        try {
            return Files.copy(directory, Paths.get(uuid));
        } catch (IOException e) {
            throw new StorageException("Couldn't search Path ", uuid, e);
        }
    }

    @Override
    protected boolean validForExistResume(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void saveResume(Resume resume, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Couldn't create Path " + path.toFile().getAbsolutePath(), path.toFile().getName(), e);
        }
        updateResume(path, resume);
    }

    @Override
    protected Resume returnResume(Path path) {
        try {
            return doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.toFile().getName(), e);
        }
    }

    @Override
    protected void deleteResume(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", path.toFile().getName(), e);
        }
    }

    @Override
    protected void updateResume(Path path, Resume resume) {
        try {
            doWrite(resume, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Update error", path.toFile().getName(), e);
        }
    }

    @Override
    protected List<Resume> getList() {
        List<Resume> list = new ArrayList<>(size());
        try {
            Files.newDirectoryStream(directory).forEach(path -> list.add(returnResume(path)));
        } catch (IOException e) {
            throw new StorageException("getList error", null, e);
        }
        return list;
    }

    @Override //ЭТОТ МЕТОД ГОТОВ!
    public void clear() {
        try {
            Files.list(directory).forEach(this::deleteResume);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        String[] list = directory.toFile().list();
        if (list == null) {
            throw new StorageException("Directory size error", null);
        }
        return list.length;
    }

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;
}
