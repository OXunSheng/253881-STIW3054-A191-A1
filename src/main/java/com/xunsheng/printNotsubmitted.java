package com.xunsheng;

import java.util.ArrayList;

public class printNotsubmitted implements Print {


    //Overriding printData from Print.
    @Override
    public void printData(ArrayList<Data> notSubmit) {
        System.out.printf("\nStudents who have not submitted" +
                "\n _____________________________________________________________________________________________________" +
                "\n| No.  | Matric  | Name                                   | Github Link                               |" +
                "\n|------|---------|----------------------------------------|-------------------------------------------|");
        for(int i =0; i<notSubmit.size(); i++){
            System.out.printf("\n|%5d | %7s |%39s |%42s |",(i+1),notSubmit.get(i).getMatric(),notSubmit.get(i).getName(),notSubmit.get(i).getLink() );
        }
        System.out.printf("\n _____________________________________________________________________________________________________\n");
    }
}
