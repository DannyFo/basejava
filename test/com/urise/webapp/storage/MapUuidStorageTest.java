package com.urise.webapp.storage;

import org.junit.Ignore;
import org.junit.Test;

public class MapUuidStorageTest extends AbstractArrayStorageTest {

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Ignore
    @Test
    public void saveWithOverflow() {
    }
}