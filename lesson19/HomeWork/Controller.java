package lesson19.HomeWork;

public class Controller {


    //добавляет файл в хранилище. гарантируется что файл уже есть в условной БД
    public static File put(Storage storage, File file) throws Exception {
        validate(storage, file);


        int index = 0;
        for (File fl : storage.getFiles()) {
            if (fl == null) {
                storage.getFiles()[index] = file;
                break;
            }
            index++;
        }
        return storage.getFiles()[index];
    }


    //удаляет файл из хранилища
    public static void delete(Storage storage, File file) throws Exception {
        // check that file exists

        boolean isExist = false;
        for (File fl : storage.getFiles()) {
            if (fl != null && fl.equals(file)) {
                isExist = true;
                break;
            }
        }
        if (!isExist)
            throw new Exception("File does not exist in storage" + storage.getId() + ". Can't be deleted");

        int index = 0;
        for (File fl : storage.getFiles()) {
            if (fl != null && fl.equals(file)) {
                storage.getFiles()[index] = null;
            }
            index++;
        }
    }


    private static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        //check that files from storageFrom does not exist
        //check that storage supports format
        //check that enough place
        //check that enough size

        long sizeOfFilesFromStorage = 0;
        for (File fileFromStorage : storageFrom.getFiles()) {
            findById(storageTo, fileFromStorage.getId());
            checkFormat(storageTo, fileFromStorage.getFormat());

            sizeOfFilesFromStorage += fileFromStorage.getSize();
        }

        checkForFreePlace(storageTo, storageFrom.getFiles().length);
        checkForSize(storageTo, sizeOfFilesFromStorage);

        for (File fileFromStorage : storageFrom.getFiles()) {
            if (fileFromStorage != null) {
                delete(storageFrom, fileFromStorage);
                put(storageTo, fileFromStorage);

            }
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        for (File fileFromStorage : storageFrom.getFiles()) {
            if (fileFromStorage.getId() == id) {
                put(storageTo, fileFromStorage);
                return;
            }
        }
    }


    //******VALIDATION******


    private static void validate(Storage storage, File file) throws Exception {
        //check that file doesn't exist
        //check that storage supports format
        //check that enough place
        //check that enough size

        findById(storage, file.getId());
        checkFormat(storage, file.getFormat());
        checkForFreePlace(storage);
        checkForSize(storage, file.getSize());

    }


    private static void checkForSize(Storage storage, long fileSize) throws Exception {
        long usedSize = 0;
        for (File fl : storage.getFiles()) {
            if (fl != null)
                usedSize += fl.getSize();
        }
        if (usedSize + fileSize > storage.getStorageSize())
            throw new Exception("File" + "No free space in storage" + storage.getId());
    }


    private static void checkForFreePlace(Storage storage) throws Exception {
        for (File file : storage.getFiles()) {
            if (file == null)
                return;
        }
        throw new Exception("Ni free place in storage" + storage.getId());
    }


    private static void checkForFreePlace(Storage storage, int placesNeeded) throws Exception {
        int count = 0;
        for (File file : storage.getFiles()) {
            if (file == null)
                count++;
        }
        if (count < placesNeeded)
            throw new Exception("No free place in storage" + storage.getId());
    }


    private static void checkFormat(Storage storage, String fileFormat) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(fileFormat))
                return;
        }
        throw new Exception(fileFormat + "is not supported in storage" + storage.getId());
    }


    private static File findById(Storage storage, long id) throws Exception {
        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                throw new Exception("File" + id + "already exist in storage " + storage.getId());
        }
        return null;
    }

}
