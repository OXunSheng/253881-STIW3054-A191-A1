package com.xunsheng;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class scrapeDataJsoup {

    private final ArrayList<Data> data = new ArrayList<Data>();

    public void scrapeDataMI() throws IOException{
        String URL = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
        Document doc = Jsoup.connect(URL).get();
        Elements table = doc.select("td.d-block.comment-body.markdown-body.js-comment-body");


        for (Element tableNum:table){


            String matricTrial = tableNum.getElementsMatchingOwnText("\\d{5,6}").text();

            String matric;
            String link;
            String name;

            Pattern matricPattern = Pattern.compile("(\\d{5,6})");
            Pattern linkPattern = Pattern.compile("(https://github.com/[a-zA-Z0-9]+)");
            int linkIndex = matricTrial.lastIndexOf("ink");
            int nameIndex = matricTrial.lastIndexOf("ame");
            String namee =null;
            try{
                 namee = matricTrial.substring(nameIndex+3,linkIndex-1).replace(':',' ').trim();
            }catch (Exception e){
                System.out.print("");
            }

            Matcher matcher1 = matricPattern.matcher(matricTrial);
            Matcher matcher2 = linkPattern.matcher(matricTrial);


            if ((matcher1.find()) && (matcher2.find())){
                matric = matcher1.group(1).trim();
                link = matcher2.group(1).trim();



                data.add(new Data(matric, namee, link));


            }


        }
    }

    public ArrayList<Data> arrayList(){
        return data;
    }

}
