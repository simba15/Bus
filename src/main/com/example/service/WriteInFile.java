package main.com.example.service;

import main.com.example.dao.ReadDao;
import main.com.example.entity.Bus;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class WriteInFile {
    public static void getResult(String fileWay , ReadDao readDao) throws IOException {
        ArrayList<Bus> list = readDao.getAllBus(fileWay);

        list.sort(Comparator.comparing(Bus::hashCode));
        

        ArrayList<Bus> poshList = new ArrayList<>();
        ArrayList<Bus> grottyList = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            int count=0;
            for (int j=0;j<list.size();j++){
                if (i==j){
                    continue;
                }
                if (comparisonBus(list.get(i),list.get(j))==false) {
                    count++;
                    //System.out.println(list.get(i));

                    break;
                }
            }
            if (count==0 && list.get(i).getComanyName().equals("Posh")) {
                poshList.add(list.get(i));
            } else if (count==0 && list.get(i).getComanyName().equals("Grotty")) {
                grottyList.add(list.get(i));
            }
        }

        /*System.out.println("Posh");
        for (Bus bus:poshList) {
            System.out.println(bus);
        }

        System.out.println("Grotty");
        for (Bus bus:grottyList) {
            System.out.println(bus);
        }*/

        inputeFile(poshList,grottyList);

    }

    private static boolean comparisonBus (Bus firstBus,Bus secondBus) {

        if (firstBus.getDurationMinutes()>60){
            return false;
        }

        if ((firstBus.getBeginHours()==secondBus.getBeginHours())&&(firstBus.getBeginMinutes()==secondBus.getBeginMinutes())) {
            if ((firstBus.getDurationMinutes()<secondBus.getDurationMinutes())) {
                return false;
            }
        }
        if (firstBus.getBeginHours()==secondBus.getBeginHours()) {
            if ((firstBus.getBeginMinutes()<secondBus.getBeginMinutes())&&((firstBus.getEndHours()==secondBus.getEndHours())&&(firstBus.getEndMinutes()==secondBus.getEndMinutes()))) {
                return false;
            }
        }

        if ((firstBus.getBeginHours()==secondBus.getBeginHours())&&(firstBus.getBeginMinutes()==secondBus.getBeginMinutes())) {
            if (((firstBus.getEndHours()==secondBus.getEndHours())&&(firstBus.getEndMinutes()==secondBus.getEndMinutes()))&&(firstBus.getComanyName().equals("Grotty"))) {
                return false;
            }
        }

        if (firstBus.getBeginHours()==secondBus.getBeginHours()) {
            if ((firstBus.getBeginMinutes()<secondBus.getBeginMinutes())&&((firstBus.getEndHours()==secondBus.getEndHours())&&(firstBus.getEndMinutes()>=secondBus.getEndMinutes()))) {
                return false;
            }
        }
        return true;
    }

    private static void inputeFile (ArrayList<Bus> poshList,ArrayList<Bus> grottyList) throws IOException {
        FileWriter fileWriter = new FileWriter("src/resources/output.txt", false);
        for (Bus bus:poshList) {
            fileWriter.write("<posh_service>"+bus.getComanyName()+" "+bus.getBeginWay()+" "+bus.getEndWay()+"\n");
        }

        fileWriter.write("<blank line>\n");
        for (Bus bus:grottyList) {
            fileWriter.write("<grotty_service>"+bus.getComanyName()+" "+bus.getBeginWay()+" "+bus.getEndWay()+"\n");
        }
        fileWriter.write("<end-of-file>");
        fileWriter.close();
    }

}
