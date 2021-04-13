package ru.company;

import ru.company.exceptions.IsDigitException;

import java.io.*;
import java.util.*;

public class Application {

    int i;
    String answer = "продолжить";

    public void startProgram(String inputFile, String outputFile) throws IOException {
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile);
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Программа начала работу!");
        System.out.println("");

        try {
            while((i=fis.read())!= -1 && answer.equals("продолжить")) {
                if(Character.isDigit((char)i)) {
                    System.out.println("Попалась цифра. Хотите закончить или продолжить?");
                    answer = read.readLine();
                }
                if(answer.equals("закончить")) {
                    throw new IsDigitException();
                }else if(!(answer.equals("закончить")) && !(answer.equals("продолжить"))){
                    System.out.print("Неккоректный ввод данных! ");
                }
                fos.write(i);
            }
            fos.close();
            System.out.print("Программа закончила работу!");
        }
        catch(IsDigitException e) {
            File file = new File(outputFile);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                System.out.print(scanner.nextLine());
            }
            scanner.close();
        }
    }
}
