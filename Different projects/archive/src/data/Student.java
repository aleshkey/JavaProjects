package data;

import java.io.Serializable;

public class Student implements Serializable {
    private String group;
    private String name, last_name, id, mark_math, mark_language, mark_IT;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark_math() {
        return mark_math;
    }

    public void setMark_math(String mark_math) {
        this.mark_math = mark_math;
    }

    public String getMark_language() {
        return mark_language;
    }

    public void setMark_language(String mark_language) {
        this.mark_language = mark_language;
    }

    public String getMark_IT() {
        return mark_IT;
    }

    public void setMark_IT(String mark_IT) {
        this.mark_IT = mark_IT;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id='" + id + '\'' +
                ", mark_math='" + mark_math + '\'' +
                ", mark_language='" + mark_language + '\'' +
                ", mark_IT='" + mark_IT + '\'' +
                '}';
    }
}
