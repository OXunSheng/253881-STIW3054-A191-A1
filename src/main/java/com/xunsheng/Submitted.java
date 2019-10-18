package com.xunsheng;

import java.util.ArrayList;

public class Submitted {

    private final ArrayList<Data> submitted = new ArrayList<Data>();

    //Create a new ArrayList for students who submitted
    public void makeNewArrayList(ArrayList<Data> wiki, ArrayList<Integer>index){
        for(int i =0; i<index.size();i++){
            submitted.add(new Data(wiki.get(index.get(i)).getMatric(), wiki.get(index.get(i)).getName(), wiki.get(index.get(i)).getLink()));
            submitted.get(i).setNum(i+1);
        }


    }

    public ArrayList<Data> arrayList(){
        return submitted;
    }
}
