package com.urise.webapp.storage;

import com.urise.webapp.storage.serializationOfStorage.ObjectStreamStorage;

public class PathStorageTest extends AbstractStorageTest {
    protected static final String PATH_DIR = STORAGE_DIR.getAbsolutePath();
    protected static ObjectStreamStorage os = new ObjectStreamStorage();
    public PathStorageTest() {
        super(new PathStorage(PATH_DIR, os));
    }
}