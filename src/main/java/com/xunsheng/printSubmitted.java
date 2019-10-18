package com.xunsheng;

import java.util.ArrayList;

public class printSubmitted implements Print {


    //Overriding printData from Print.
    @Override
    public void printData(ArrayList<Data> submit) {
        System.out.printf("\nStudents who have submitted" +
                "\n _____________________________________________________________________________________________________" +
                "\n| No.  | Matric  | Name                                   | Github Link                               |" +
                "\n|------|---------|----------------------------------------|-------------------------------------------|");
        for(int i =0; i<submit.size(); i++){
            System.out.printf("\n|%5d | %7s |%39s |%42s |",(i+1),submit.get(i).getMatric(),submit.get(i).getName(),submit.get(i).getLink() );
        }
        System.out.printf("\n _____________________________________________________________________________________________________\n");
    }
}
