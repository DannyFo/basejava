package com.urise.webapp.storage.serialization;

import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IOStrategy {

    void doWrite(Resume resume, OutputStream os) throws IOException;

    Resume doRead (InputStream is) throws IOException;
}
