
public class test {
/*
    private static void validatePutMethod(Storage storage, File file) throws Exception {

        checkFormatFile(storage, file);
        checkSizeStorage(storage, file);
        checkIdFile(storage, file.getId());
        checkEmptyItemsStorage(storage);
    }


    //Storage может хранить файлы только поддерживаемого формата
    private static void checkFormatFile(Storage storage, File file) throws Exception {

        for (String formatFile : storage.getFormatsSupported()) {
            if (formatFile.equals(file.getFormat()))
                return;
        }
        throw new Exception("file format" + file.getId() + "file not supported by storage" + storage.getId());
    }


    //Учитывайте макс размер хранилища
    private static void checkSizeStorage(Storage storage, File file) throws Exception {

        long size = 0;
        for (File fl : storage.getFiles()) {
            if (fl != null) {
                size += fl.getSize();
            }
        }
        if (file.getSize() + size > storage.getStorageSize())
            throw new Exception(file.getId() + "file size larger than storage size" + storage.getId());
    }


    //В одном хранилище не могут хранится файлы с одинаковым айди
    private static void checkIdFile(Storage storage, long id) throws Exception {

        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id) {
                throw new Exception("File" + file.getId() + "file already stored in storage" + storage.getId());
            }
        }

    }


    //проверка что есть пустая ячкйка в масиве Put
    private static boolean checkEmptyItemsStorage(Storage storage) {

        if (storage.getFiles() == null)
            return false;

        int index = 0;
        for (File fl : storage.getFiles()) {
            if (storage.getFiles()[index] != null) {
                fl = storage.getFiles()[index];
            }
            index++;
        }
        return true;
    }

*/
}
