package service;


import com.google.gson.Gson;
import models.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static List<Book> books = new ArrayList<>();

    private static String pythonFile = "D:\\python\\practice\\pythonProject\\KP\\translator";

    private static Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 250000);
        return page;
    }

    private static String translate(String str){
        ProcessBuilder pb = new ProcessBuilder("python", "D:\\python\\practice\\pythonProject\\KP\\translator\\translator.py", str);
        String res = "";
        try {
            Process p = pb.start();
            p.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s ="";
            while ((s = br.readLine()) != null) {
                res = res + s;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static Book getDateDescriptionGenre(String url, Book book){
        String description = "";
        String date = "";
        List<String> genres = new ArrayList<>();
        try {
            Document page = getPage(url);
            var section = page.select("div[class=m4n24q-0 feXlWY]");
            var st = section.select("div[class=iszfik-2 gAFRve]").select("p").text().split("Читайте онлайн полную")[0];
            book.setDescription(section.select("div[class=iszfik-2 gAFRve] > p").text().split("Читайте онлайн полную")[0]);
            if (!section.select("dd[class=iszfik-18 iEusfO]").isEmpty())
                book.setReleased_on(section.select("dd[class=iszfik-18 iEusfO]").first().text());
            Elements sectionsWithGenres = page.select("div[class=sc-1sg8rha-0 gHinNz]");
            for (var s : sectionsWithGenres){
                genres.add(section.select("div[class=sc-1sbv3y7-1 eVvZLL]").select("a[href]").text());
            }
            book.setGenre(genres.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    public static void searchBooks(String url) throws IOException {
        Document page = getPage(url);

        Elements allSections = page.select("div[class=e4xwgl-0 iJwsmp]");
        for (var section : allSections) {
            Book book = new Book();
            String childURL ="https://mybook.ru"+section.select("a[href]").first().attr("href");
            book.setTitle(section.select("p[class=lnjchu-1 hhskLb]").text());
            book.setAuthor(section.select("div[class=dey4wx-1 jVKkXg]").text());
            book = getDateDescriptionGenre(childURL, book);
            books.add(book);
        }
    }


    public static void main(String[] args) throws IOException {
        /*searchBooks("https://mybook.ru/catalog/books/?cursor=cj0xJnA9MTY3NTUx&o=readers&ysclid=le9rx5usm7739380815");

        for(var b : books) {
            System.out.println(b);
        }

        System.out.println(books.size());

        /*for (int i = 1; i < 100; i++) {
            searchBooks("https://nice-books.ru/books/page/" + i);
        }

        Gson gson = new Gson();
        String json="";
        for(var b : books){
            System.out.println(b);
            json =json + gson.toJson(b)+"\n\n";
        }
        //System.out.println(json);
        BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(new File("D:\\java\\Parsers\\BestBooks\\info.json")));

        bufferedWriter.write(json);
        bufferedWriter.flush();
        bufferedWriter.close();

        System.out.println(books.size());
*/

        System.out.println(getPage("https://mybook.ru/author/evgenij-zamyatin/my/"));
    }
}