package com.example.utils;

import java.io.IOException;

public interface FileSerializable<T> {
    void saveToFile(String fileName, T object) throws IOException;
    T loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
