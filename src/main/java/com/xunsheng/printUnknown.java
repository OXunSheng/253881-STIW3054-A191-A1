package com.xunsheng;

import java.util.ArrayList;

public class printUnknown implements Print {

    //Overriding printData from Print
    @Override
    public void printData(ArrayList<Data> unknown) {
        System.out.printf("\nStudents who have submitted but does not exist in the List of Student" +
                "\n _____________________________________________________________________________________________________" +
                "\n| No.  | Matric  | Name                                   | Github Link                               |" +
                "\n|------|---------|----------------------------------------|-------------------------------------------|");
        for(int i =0; i<unknown.size(); i++){
            System.out.printf("\n|%5d | %7s |%39s |%42s |",(i+1),unknown.get(i).getMatric(),unknown.get(i).getName(),unknown.get(i).getLink() );
        }
        System.out.printf("\n _____________________________________________________________________________________________________\n");
    }
}
