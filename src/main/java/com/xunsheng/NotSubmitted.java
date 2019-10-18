package com.xunsheng;

import java.util.ArrayList;

public class NotSubmitted {

    private final ArrayList<Data> notSubmitted = new ArrayList<Data>();

    public void makeNewArrayList(ArrayList<Data> wiki, ArrayList<Integer>index){
        for(int i =0; i<index.size();i++){
            notSubmitted.add(new Data(wiki.get(index.get(i)).getMatric(), wiki.get(index.get(i)).getName(), wiki.get(index.get(i)).getLink()));
            notSubmitted.get(i).setNum(i+1);
        }


    }

    public ArrayList<Data> arrayList(){
        return notSubmitted;
    }
}
