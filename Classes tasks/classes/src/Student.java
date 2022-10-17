public class Student {
    String name;
    int numberOfGroup;
    int[] marks;

    public Student(){
        name="";
        numberOfGroup=0;
        marks = new int[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    private boolean isExcellentStudent(){
        for (int i=0;i<marks.length;i++) {
            if (marks[i]<9){
                return false;
            }
        }
        return true;
    }

    public void printExcellentStudent(){
        if(isExcellentStudent()){
            System.out.println(name+" "+numberOfGroup);
        }
    }
}
