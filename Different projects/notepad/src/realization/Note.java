package realization;

import java.util.Scanner;

public class Note {
    private String title;
    private String date;
    private String email;
    private String body;

    private boolean checkInput(String str, String regExp){
        return str.matches(regExp);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + "\n" +
                date + "\n" +
                email  +"\n"+
                body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        while (!flag) {
            if (checkInput(email, "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b")) {
                this.email = email;
                flag= true;
            }
            else System.out.println("incorrect input");
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
