import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int counter = 0;

    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        searchForEmptyCell();
        storage[counter] = r;
    }

    Resume get(String uuid) {
        if (searchUuid(uuid)){
            return storage[counter];
        }
        return null;
    }

    void delete(String uuid) {
        searchUuid(uuid);
        storage[counter] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] tempStorage = copyOf(storage, size());

        int tempStorageCounter = 0;
        for (int i = 0; i<storage.length; i++) {
            if (storage[i] != null) {
                tempStorage[tempStorageCounter] = storage[i];
                tempStorageCounter++;
            }
        }
        return tempStorage;
    }

    int size() {
        counter = 0;
        for (Resume i:storage) {
            if (i != null) {
                counter++;
            }
        }
        return counter;
    }

    boolean searchUuid(String uuid) {
        for (counter = 0; counter < storage.length; counter++) {
            if (storage[counter].uuid == uuid) {
                break;
            }
            return false;
        }
        return true;
    }

    void searchForEmptyCell(){
        while (storage[counter] != null) {
            counter++;
        }
    }
}
