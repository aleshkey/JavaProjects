package com.my_tg_bot.tg_bot.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static Document getPage(String town) throws IOException {
     String url = "https://yandex.by/pogoda/"+town.toLowerCase();
     Document page = Jsoup.parse(new URL(url), 3000);
     return page;
    }

    public static String searchWeather(String town) throws IOException {
        Document page = getPage(town);
        int count=0;

        List<String> weak = new ArrayList<>();
        //System.out.println(page);
        Elements days = page.select("a[class=link link_theme_normal text forecast-briefly__day-link i-bem]");
        for (Element day : days) {
            if (count < 9) {
                String result=new String();
                //System.out.println(day+"\n");
                String date = day.select("time[class=time forecast-briefly__date]").text();
                String temperature = divideTemperature(day.select("span[class=temp__value temp__value_with-unit]").text());
                String type = day.select("div[class=forecast-briefly__condition]").text();
                switch (count){
                    case 0:{
                        result="Вчера: ";
                        break;
                    }
                    case 1:{
                        result="Сегодня: ";
                        break;
                    }
                    case 2:{
                        result="Завтра: ";
                        break;
                    }
                }
                count++;
                result=result+date + "\n" + temperature+"\n"+type+"\n";
                weak.add(result);
            }
        }

        return toString(weak);
    }

    private static String divideTemperature(String temperature){
        String result="Днем: ";
        String buffer="";
        for (int i=0; i<temperature.length();i++) {
            if (temperature.charAt(i) != ' ') {
                buffer = buffer + temperature.charAt(i);
            }
            else{
                result = result+buffer+"°C\n"+"Ночью: ";
                buffer="";
            }
        }
        result = result+buffer+"°C";
        return result;
    }

    private static String toString(List<String> strings){
        String res ="";
        for(String str : strings){
            res=res+str+"\n";
        }
        return res;
    }
}
