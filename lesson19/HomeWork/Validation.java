package lesson19.HomeWork;

public class Validation {

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
        for (File file : storage.getFiles()) {
            if (file != null)
                usedSize += file.getSize();
        }
        if (usedSize + fileSize > storage.getStorageSize())
            throw new Exception("No free space in storage" + storage.getId());
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


    private static void checkFormat(Storage storage, String fileFormat) throws Exception{
        for (String format : storage.getFormatsSupported()){
            if (format.equals(fileFormat))
                return;
        }
        throw new Exception(fileFormat + "is not supported in storage" + storage.getId());
    }


    private static File findById(Storage storage, long id) throws Exception{
        for (File file : storage.getFiles()){
            if (file != null && file.getId() == id)
                throw new Exception("File" + id + "already exist in storage " + storage.getId());
        }
        return null;
    }


}
