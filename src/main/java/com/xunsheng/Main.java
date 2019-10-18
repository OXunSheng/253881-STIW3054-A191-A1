package com.xunsheng;

import java.io.IOException;

import java.util.ArrayList;


public class Main {


    public static void main(String[] args) throws IOException {

        //Create multiple Arraylists to store different indices.
        ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<Integer> wikiIndex = new ArrayList<Integer>();
        ArrayList<Integer> unknownIndex = new ArrayList<Integer>();
        ArrayList<Integer> submitIndex = new ArrayList<Integer>();

        //Create scrapeDataJsoup object.
        scrapeDataJsoup scrape = new scrapeDataJsoup();
        //Call method to scrape data from Issue Page (MainIssue).
        scrape.scrapeDataMI();

        //Create scrapeDataWIki object.
        scrapeDataWIki scr = new scrapeDataWIki();
        //Call method to scrape data from Wiki Page (ListOfStudent).
        scr.scrapeDataWiki();

        //Create compareData object.
        compareData compare = new compareData();
        //Compare data that are the same and set appropriate matric number, link and name.
        compare.compareData(scrape.arrayList(),scr.arrayList());
        //Get index of same element in two different ArrayList and add into a new ArrayList.
        compare.getIndex(scrape.arrayList(),scr.arrayList(),index);

        //Create Submitted object.
        Submitted submit = new Submitted();
        //Call method to create a new ArrayList for students who submitted.
        submit.makeNewArrayList(scr.arrayList(),index);

        //Loop for No. of Student in ListOfStudents
        for(int i =1; i<scr.arrayList().size(); i++){
            wikiIndex.add(i);
        }
        //Remove all same element from wikiIndex and index
        wikiIndex.removeAll(index);

        //Create NotSubmitted object.
        NotSubmitted notsubmit = new NotSubmitted();
        //Call method to create a new ArrayList for students who did not submit.
        notsubmit.makeNewArrayList(scr.arrayList(),wikiIndex);


        //Get index of student who have submitted in both ArrayList.
        compare.getIndex(submit.arrayList(),scrape.arrayList(),submitIndex);

        //Loop for No. of Student in MainIssue
        for(int i =1;i<scrape.arrayList().size(); i++){
            unknownIndex.add(i);
        }
        //Remove all same element from unknownIndex and submitIndex
        unknownIndex.removeAll(submitIndex);

        //Create Unknown object.
        Unknown unknown = new Unknown();
        //Call method to create a new ArrayList for students who submitted but does not exist in the list of student.
        unknown.makeNewArrayList(scrape.arrayList(),unknownIndex);


        //Create printSubmitted object.
        Print submitList = new printSubmitted();
        //Call method to print list of student that submitted.
        submitList.printData(submit.arrayList());

        ////Create printSubmitted object.
        Print notSubmitList = new printNotsubmitted();
        //Call method to print list of student that did not submit.
        notSubmitList.printData(notsubmit.arrayList());

        //Create printSubmitted object.
        Print unknownList = new printUnknown();
        //Call method to print list of student that submitted but does not exist in the list of student.
        unknownList.printData(unknown.arrayList());

        //Create exportToExcel object.
        exportToExcel excel = new exportToExcel();

        try{
            //Call method to export to Excel.
            excel.exportExcel(submit.arrayList(), notsubmit.arrayList(),unknown.arrayList());
        }catch(Exception e){
            e.printStackTrace();
        }



















        }





}
