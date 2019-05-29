package com.urise.webapp.storage;

import com.urise.webapp.storage.serializationOfStorage.ObjectStreamStorage;

public class FileStorageTest extends AbstractStorageTest {
    protected static ObjectStreamStorage os = new ObjectStreamStorage();

    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, os));
    }
}
