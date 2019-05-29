package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializationOfStorage.IOStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;

    public IOStrategy ioStrategy;

    protected PathStorage(String dir, IOStrategy ioStrategy) {
        Objects.requireNonNull(dir, "directory must not be null");
        this.ioStrategy = ioStrategy;
        directory = Paths.get(dir);
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }


    @Override
    protected Path searchUuid(String uuid) {
        return directory.resolve(uuid);
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
            return ioStrategy.doRead(new BufferedInputStream(Files.newInputStream(path)));
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
            ioStrategy.doWrite(resume, new BufferedOutputStream(Files.newOutputStream(path)));
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

    @Override
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
}
