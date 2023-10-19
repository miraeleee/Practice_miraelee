package school;

import java.util.ArrayList;
import utils.Define;

public class Subject{
    //멤버변수
    private String subjectName;
    private int subjectId;
    private int grade;

    private ArrayList<Student> studentList = new ArrayList<Student>();

    //생성자
    public Subject(String subjectName, int subjectId){
        this.subjectName = subjectName;
        this.subjectId = subjectId;
        this.grade = Define.AB_TYPE;
    }
    
    //getter,setter메서드
    public String getSubjectName(){
        return subjectName;    
    }

    public void setSubjectName(String subjectName){
        this.subjectName = subjectName;
    }

    public int getSubjectId(){
        return subjectId;
    }

    public void setSubjectId(int subjectId){
        this.subjectId = subjectId;
    }

    public ArrayList<Student> getStudentList(){
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList){
        this.studentList = studentList;
    }

    public int getGrade(){
        return grade;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }
    //메소드
    public void register(Student student){
        studentList.add(student);
    }
}