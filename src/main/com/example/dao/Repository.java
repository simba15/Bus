package main.com.example.dao;

import main.com.example.entity.Bus;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Repository implements ReadDao{
    private ArrayList<Bus> list;
    @Override
    public ArrayList<Bus> getAllBus(String fileWay) throws IOException {
        FileReader fileReader = new FileReader(fileWay);
        list = new ArrayList<>();
        Scanner in  = new Scanner(fileReader);
        while (in.hasNextLine()) {
            String[]line = in.nextLine().split(" ");
            if (line[0].equals("<end-of-file>")) {
                break;
            }
            list.add(new Bus(line[0].substring(9),line[1],line[2]));
        }
        fileReader.close();
        return list;
    }
}
