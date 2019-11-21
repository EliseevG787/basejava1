import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Резюме с uuid = " + resume.getUuid() + " уже существует");
        } else if (size == storage.length) {
            System.out.println("Массив заполнен");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    Resume get(String uuid) {
        if (getIndex(uuid) == -1) {
            System.out.println("Резюме с uuid = " + uuid + " не существует");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        if (getIndex(uuid) == -1) {
            System.out.println("Резюме с uuid = " + uuid + " не существует");
        } else {
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println("Резюме с uuid = " + uuid + " удалено");
        }
    }
    
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

