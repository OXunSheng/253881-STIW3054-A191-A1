package com.xunsheng;

import java.util.ArrayList;
import java.util.Collections;

public class compareData {


    public void compareData(ArrayList<Data> mainIssue, ArrayList <Data> wiki){
        for(int i = 0; i < mainIssue.size(); i++){

            for(int j = 0; j < wiki.size(); j++){
                if((mainIssue.get(i).getMatric().equals(wiki.get(j).getMatric())) || (mainIssue.get(i).getName().equals(wiki.get(j).getName()))) {

                    mainIssue.get(i).setMatric(wiki.get(j).getMatric());
                    mainIssue.get(i).setName(wiki.get(j).getName());
                    wiki.get(j).setLink(mainIssue.get(i).getLink());
                }
            }

        }

    }

    public void getIndex(ArrayList<Data> mainIssue, ArrayList <Data> wiki, ArrayList<Integer>index){
        for(int i = 0; i < mainIssue.size(); i++){

            for(int j = 0; j < wiki.size(); j++){
                if((mainIssue.get(i).getMatric().equals(wiki.get(j).getMatric())) || (mainIssue.get(i).getName().equals(wiki.get(j).getName()))) {

                    index.add(j);
                }
            }

        }
        Collections.sort(index);

    }






}
