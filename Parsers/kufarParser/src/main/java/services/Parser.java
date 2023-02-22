package services;

import models.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static List<Product> products = new ArrayList<>();

    private static Document getPage() throws IOException {
        String url = "https://www.kufar.by/l/r~minsk/monitory?utm_queryOrigin=Previously_searched&utm_suggestionType=Query_only";
        Document page = Jsoup.parse(new URL(url), 25000);
        return page;
    }

    public static void searchProducts() throws IOException {
        Document page = getPage();

        Elements allSections = page.select("section > a");
        for (var section : allSections) {
            String name = section.select("h3[class=styles_title__XS_QS]").text();
            String price="";
            if (!section.select("p[class=styles_price__tiO8k]").select("span").isEmpty())
                price = section.select("p[class=styles_price__tiO8k]").select("span").text();
            String description = section.select("div[class=styles_secondary__dylmH]").select("p").text();
            String url = section.select("a[class=styles_wrapper__IMYdY]").attr("href").toString();
            products.add(new Product(name, price, url, description));
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            searchProducts();
            for (var m : products) {
                System.out.println(m);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }/*
        System.out.println(
                getPage()
        );*/
    }
}