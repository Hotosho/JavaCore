package lesson19.HomeWork;

public class Controller {


    //добавляет файл в хранилище. гарантируется что файл уже есть в условной БД
    public static File put(Storage storage, File file) throws Exception {

        validatePutMethod(storage, file);

        int i = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 == null) {
                storage.getFiles()[i] = file1;
                break;
            }
            i++;
        }
        return storage.getFiles()[i];
    }

    //удаляет файл из хранилища
    public static File delete(Storage storage, File file) {

        if (file == null || storage.getFiles() == null)
            return null;

        for (File file1 : storage.getFiles()){
            if (file1 != null && file1.equals(file))
                file1 = null;
        }
        return file;
    }

    //трансфер всех файлов из одного хранилища в другое
    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        validateTransferAll(storageFrom, storageTo);

        int i = 0;
        for (File file : storageFrom.getFiles()) {
            if (file != null) {
                for (File file1 : storageTo.getFiles()) {
                    if (file1 == null) {
                        storageTo.getFiles()[i] = file;
                    } else
                        i++;
                }
            }
        }

    }

    //трансфер файла с хранилища одного хранилища в другое по его айди. Гарантируется что файл с таким id точно есть в хранилище storageFrom
    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
    }


    //********** VALIDATE********


    //Storage может хранить файлы только поддерживаемого формата
    private static void validateFileFormat(Storage storage, String format, File file) throws Exception {

        for (String formatFile : storage.getFormatsSupported()) {
            if (formatFile.equals(format))
                return;
        }
        throw new Exception(file.getId() + "file not supported by storage" + storage.getId());
    }


    //Учитывайте макс размер хранилища
    private static void validateMaxSizeStorage(Storage storage, long fileSize) throws Exception {

        long size = 0;
        for (File file : storage.getFiles()) {
            if (file != null) {
                size += file.getSize();
            }
        }
        if (fileSize + size > storage.getStorageSize())
            throw new Exception("Storage" + storage.getId() + "file size larger than storage size");
    }

    //В одном хранилище не могут хранится файлы с одинаковым айди
    private static void validateCompareFileId(Storage storage, long id) throws Exception {

        for (File file : storage.getFiles()) {
            if (file.getId() == id) {
                throw new Exception("File" + file.getId() + "file already stored in storage" + storage.getId());
            }
        }

    }

    //проверка что есть пустая ячкйка в масиве Put
    private static boolean checkEmptyItemsInStorage(Storage storage) {
        if (storage.getFiles() == null)
            return false;

        int index = 0;

        for (File file : storage.getFiles()) {
            if (storage.getFiles()[index] != null) {
                file = storage.getFiles()[index];
            }
            index++;
        }
        return true;
    }

    private static void validatePutMethod(Storage storage, File file) throws Exception {

        validateFileFormat(storage, file.getFormat(), file);
        validateMaxSizeStorage(storage, file.getSize());
        validateCompareFileId(storage, file.getId());
        checkEmptyItemsInStorage(storage);
    }

    private static boolean validateFormatTransfer(Storage storageFrom, Storage storageTo) throws Exception {

        if (storageFrom.getFormatsSupported().equals(storageTo.getFormatsSupported()))
            return true;
        throw new Exception("storageFrom" + storageFrom.getId() + "storages not supported this format" + "storageTo" + storageTo.getId());
    }

    private static boolean validateSizeTransfer(Storage storageFrom, Storage storageTo) throws Exception {

        int sizeFile = 0;
        for (File file : storageFrom.getFiles()) {
            if (file != null)
                sizeFile += file.getSize();
            if (sizeFile + storageFrom.getStorageSize() > storageTo.getStorageSize())
                throw new Exception(storageFrom.getId() + "size more than" + storageTo.getId());
        }
        return true;
    }

    private static void validateTransferAll(Storage storageFrom, Storage storageTo) throws Exception {

        validateFormatTransfer(storageFrom, storageTo);
        validateSizeTransfer(storageFrom, storageTo);

    }
}
