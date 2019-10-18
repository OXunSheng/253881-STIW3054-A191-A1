package com.xunsheng;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) throws IOException {
	// write your code here

        ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<Integer> wikiIndex = new ArrayList<Integer>();
        ArrayList<Integer> unknownIndex = new ArrayList<Integer>();
        ArrayList<Integer> submitIndex = new ArrayList<Integer>();



        scrapeDataJsoup scrape = new scrapeDataJsoup();
        scrape.scrapeDataMI();

        scrapeDataWIki scr = new scrapeDataWIki();
        scr.scrapeDataWiki();

        compareData compare = new compareData();
        compare.compareData(scrape.arrayList(),scr.arrayList());
        compare.getIndex(scrape.arrayList(),scr.arrayList(),index);

        Submitted submit = new Submitted();
        submit.makeNewArrayList(scr.arrayList(),index);

        for(int i =1; i<scr.arrayList().size(); i++){
            wikiIndex.add(i);
        }
        wikiIndex.removeAll(index);

        NotSubmitted notsubmit = new NotSubmitted();
        notsubmit.makeNewArrayList(scr.arrayList(),wikiIndex);


        compare.getIndex(submit.arrayList(),scrape.arrayList(),submitIndex);//get common index of the ones who have submitted
        for(int i =1;i<scrape.arrayList().size(); i++){
            unknownIndex.add(i);
        }
        unknownIndex.removeAll(submitIndex);
        Unknown unknown = new Unknown();
        unknown.makeNewArrayList(scrape.arrayList(),unknownIndex);


        Print submitList = new printSubmitted();
        submitList.printData(submit.arrayList());
        Print notSubmitList = new printNotsubmitted();
        notSubmitList.printData(notsubmit.arrayList());
        Print unknownList = new printUnknown();
        unknownList.printData(unknown.arrayList());

        exportToExcel excel = new exportToExcel();
        try{
            excel.exportExcel(submit.arrayList(), notsubmit.arrayList(),unknown.arrayList());
        }catch(Exception e){
            e.printStackTrace();
        }



















        }





}
