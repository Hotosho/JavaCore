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
    public static void delete(Storage storage, File file) {

        int i = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 != null) {
                storage.getFiles()[i] = file1;
                i++;
                if (file1.equals(file))
                    file1 = null;
            }
        }
    }

    //трансфер всех файлов из одного хранилища в другое
    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception{



    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id){

    }
    //********** VALIDATE********

    //Storage может хранить файлы только поддерживаемого формата
    private static void validateFileFormat(Storage storage, String format) throws Exception {

        for (String formatFile : storage.getFormatsSupported()) {
            if (formatFile.equals(format))
                return;
        }
        throw new Exception(format + "file not supported by storage" + storage.getId());
        // тут когда пробовал переменной дать id  в throw new, то тогда метод validatePutMethod работать не будет.
        // private static void validateFileFormat(Storage storage, String format, long id) throws Exception {
        //
        //        for (String formatFile : storage.getFormatsSupported()) {
        //            if (formatFile.equals(format))
        //                return;
        //        }
        //        throw new Exception(format + id + "file not supported by storage" + storage.getId());

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

        validateFileFormat(storage, file.getFormat());
        validateMaxSizeStorage(storage, file.getSize());
        validateCompareFileId(storage, file.getId());
        checkEmptyItemsInStorage(storage);
    }
}
