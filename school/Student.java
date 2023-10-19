package school;

import java.util.ArrayList;

public class Student{
    //멤버변수
    private int studentId;
    private String studentName;
    private Subject majorSubject;

    private ArrayList<Score> scoreList = new ArrayList<Score>();

    //생성자
    public Student(int studentId, String studentName, Subject majorSubject){
        this.studentId = studentId;
        this.studentName = studentName;
        this.majorSubject = majorSubject;
    }
    
    //메서드
    public void addSubjectScore(Score score){
        scoreList.add(score);
    }
    
    //getter,setter메서드 -> private한 멤버변수 접근하기 위해 사용
    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getStudentName(){
        return studentName;
    }
    
    public void setStudentNmae(String studentName){       
         this.studentName = studentName;
    }

    public Subject getMajorSubject(){
        return majorSubject;
    }

    public void setMajorSubject(Subject majorSubject){
        this.majorSubject = majorSubject;
    }

    public ArrayList<Score> getScoreList(){
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList){
        this.scoreList = scoreList;
    }
}