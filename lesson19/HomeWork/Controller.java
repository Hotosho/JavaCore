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
    public void delete(Storage storage, File file) throws Exception {
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

        int index = 0;
        for (File fileFrom : storageFrom.getFiles()) {
            if (fileFrom != null) {
                for (File fileTo : storageTo.getFiles()) {
                    if (fileTo == null) {
                        storageTo.getFiles()[index] = fileFrom;
                        break;
                    } else index++;
                }
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
        checkFormat(storage, file);
        checkForFreePlace(storage);
        checkForSize(storage, file);

    }

    private static void validateTransferAll(Storage storage, File file) throws Exception{

    }

    private static void checkForSize(Storage storage, File file) throws Exception {
        long usedSize = 0;
        for (File fl : storage.getFiles()) {
            if (fl != null)
                usedSize += fl.getSize();
        }
        if (usedSize + file.getSize() > storage.getStorageSize())
            throw new Exception("File" + file.getId() + "No free space in storage" + storage.getId());
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


    private static void checkFormat(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat()))
                return;
        }
        throw new Exception("File format" + file.getId() + "is not supported in storage" + storage.getId());
    }


    private static File findById(Storage storage, long id) throws Exception {
        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                throw new Exception("File" + file.getId() + "already exist in storage " + storage.getId());
        }
        return null;
    }



}
