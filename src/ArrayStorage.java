import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int counter = 0;
    int i;


    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    void save(Resume r) {
        storage[counter] = r;
        counter++;
    }

    Resume get(String uuid) {
        if (searchUuid(uuid)) {
            return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        searchUuid(uuid);
        storage[i] = null;
        int StorageCounter = 0;
        for (int b = 0; b < storage.length; b++) {
            if (storage[b] != null) {
                storage[StorageCounter] = storage[b];
                StorageCounter++;
            }
        }
        counter--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] tempStorage = copyOf(storage, size());
        return tempStorage;
    }

    int size() {
        return counter;
    }

    boolean searchUuid(String uuid) {
        for (i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid) {
                break;
            }
            return false;
        }
        return true;
    }

}
