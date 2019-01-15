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
        if (searchUuid(uuid) == -1) {
            return null;
        }
        return storage[searchUuid(uuid)];
    }

    void delete(String uuid) {
        int startIndex = searchUuid(uuid);
        storage[startIndex] = null;
        for (int b = startIndex; b < counter; b++) {
            storage[b] = storage[b + 1];
        }
        counter--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return copyOf(storage, counter);
    }

    int size() {
        return counter;
    }

    int searchUuid(String uuid) {
        for (i = 0; i < counter; i++) {
            if (storage[i].uuid == uuid) {
                return i;
            }
        }
        return -1;
    }

}
