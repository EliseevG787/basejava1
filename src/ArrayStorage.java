import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0;
    private Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void update(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i == -1) {
            System.out.println("Резюме с uuid = " + resume.getUuid() + " не существует");
        } else {
            storage[i] = resume;
            System.out.println("Резюме с uuid = " + resume.getUuid() + " обновлено");
        }
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Резюме с uuid = " + resume.getUuid() + " уже существует");
        } else if (size == storage.length) {
            System.out.println("Массив заполнен");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Резюме с uuid = " + uuid + " не существует");
            return null;
        }
        return storage[i];
    }

    public void delete(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Резюме с uuid = " + uuid + " не существует");
        } else {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println("Резюме с uuid = " + uuid + " удалено");
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
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

