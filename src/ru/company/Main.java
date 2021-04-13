package ru.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.startProgram("src\\ru\\company\\text", "src\\ru\\company\\result");
    }
}
