package lesson19.HomeWork;

public class Controller {


    //добавляет файл в хранилище. гарантируется что файл уже есть в условной БД
    public static void put(Storage storage, File file) {

        int i = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 == null) {
                storage.getFiles()[i] = file1;
                break;
            }
            i++;
        }

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

    //трансфер всех файлов из одного хранилища в другое
    public static void transferAll(Storage storageFrom, Storage storageTo){

        int count;

        for (File file : storageFrom.getFiles()){
            for (File file1 : storageTo.getFiles()){
                if (file.getFormat().equals(file1.getFormat()) && )
            }
        }
    }
}
