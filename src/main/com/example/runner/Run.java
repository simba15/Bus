// 6:14PM 31.08

package main.com.example.runner;

import main.com.example.dao.Repository;
import main.com.example.service.WriteInFile;

import java.io.IOException;

public class Run {
    public static void main (String[]argv) {
        if (argv.length==0) {
            return;
        }
        try {
            WriteInFile.getResult(argv[0],new Repository());
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

}
