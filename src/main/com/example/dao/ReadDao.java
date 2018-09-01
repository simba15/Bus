package main.com.example.dao;

import main.com.example.entity.Bus;

import java.io.IOException;
import java.util.ArrayList;

public interface ReadDao {
    ArrayList<Bus> getAllBus (String fileWay) throws IOException;
}
