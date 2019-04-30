package lesson19.HomeWork;

public class Controller {


    //добавляет файл в хранилище. гарантируется что файл уже есть в условной БД
    public static File put(Storage storage, File file) {

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
    public void delete(Storage storage, File file) {

        int i = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 != null) {
                storage.getFiles()[i] = file1;
                file1 = null;
            }
        }
    }

    ////////////////// VALIDATE////////
    //Storage может хранить файлы только поддерживаемого формата
    private static void validateFileFormat(Storage storage, String format) throws Exception {

        for (String formatFile : storage.getFormatsSupported()) {
            if (formatFile.equals(format))
                return;
        }
        throw new Exception(format + "format not supported" + storage.getId());

    }

    //Учитывайте макс размер хранилища
    private static void validateMaxSizeStorage(Storage storage, long fileSize) throws Exception {

        long size = 0;
        for (File file : storage.getFiles()) {
            if (file != null) {
                size += file.getSize();
            }
            if (fileSize + size > storage.getStorageSize())
                throw new Exception("Storage" + storage.getId() + "file size larger than storage size");
        }
    }

    private static void validateCompareFileId(Storage storage, long id) throws Exception {

        for (File file : storage.getFiles()) {
            if (file.getId() == id) {
                throw new Exception("File" + file.getId() + "file already stored in storage");
            }
        }

    }

    private static void validateNameSizeFile(Storage storage, String name){


    }
}
