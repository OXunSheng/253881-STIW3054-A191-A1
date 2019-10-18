package com.xunsheng;

import java.util.ArrayList;

public class Unknown {

    private final ArrayList<Data> unknown = new ArrayList<Data>();

    //Create a new ArrayList for students who submitted but does not exist in the list of student
    public void makeNewArrayList(ArrayList<Data> wiki, ArrayList<Integer>index){
        for(int i =0; i<index.size();i++){
            unknown.add(new Data(wiki.get(index.get(i)).getMatric(), wiki.get(index.get(i)).getName(), wiki.get(index.get(i)).getLink()));
            unknown.get(i).setNum(i+1);
        }


    }

    public ArrayList<Data> arrayList(){
        return unknown;
    }
}
