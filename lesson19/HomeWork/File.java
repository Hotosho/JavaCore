package lesson19.HomeWork;

import java.util.Objects;

public class File {

    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception {
        if (name == null || name.length() > 10) {
            this.id = id;
            this.name = name;
            this.format = format;
            this.size = size;
            throw new Exception(name + id + "name has more than 10 characters");

        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getFormat() {
        return format;
    }


    public long getSize() {
        return size;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id &&
                name.equals(file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
