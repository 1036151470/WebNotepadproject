package com.project;

public class Justpojo {
    private String name;
    private String address;
    private String size;
    private String context;
    private String absoluteFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAbsoluteFile() {
        return absoluteFile;
    }

    public void setAbsoluteFile(String absoluteFile) {
        this.absoluteFile = absoluteFile;
    }

    @Override
    public String toString() {
        return "Justpojo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", size='" + size + '\'' +
                ", context='" + context + '\'' +
                ", absoluteFile='" + absoluteFile + '\'' +
                '}';
    }
}
