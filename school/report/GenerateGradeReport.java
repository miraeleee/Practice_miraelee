package school.report;

import java.util.ArrayList;

import grade.MajorEvaluation;
import grade.PassFailEvaluation;
import grade.BaseEvaluation;
import grade.GradeEvaluation;
import school.Student;
import school.Subject;
import school.Score;
import school.School;
import utils.Define;

public class GenerateGradeReport {
        School school = School.getInstance();
        public static final String TITLE = "수강생 학점\t\t\n";
        public static final String HEADER ="이름 | 학번 | 필수과목 | 점수 \n";
        public static final String LINE ="----------------------\n";

        private StringBuffer buffer = new StringBuffer();

        public String getReport(){
            ArrayList<Subject> subjectList = school.getSubjectList();
            
            //배열전용 for문
            for(Subject subject : subjectList){
                makeHeader(subject);
                makeBody(subject);
                makeFooter();
            }
            return buffer.toString();
        }

        public void makeHeader(Subject subject){
            buffer.append(GenerateGradeReport.LINE);
            buffer.append("\t" + subject.getSubjectName());
            buffer.append(GenerateGradeReport.TITLE);
            buffer.append(GenerateGradeReport.HEADER);
            buffer.append(GenerateGradeReport.LINE);
        }

        public void makeBody(Subject subject){
            ArrayList<Student> studentList = subject.getStudentList();

            for(int i = 0; i < studentList.size(); i++){
                Student student = studentList.get(i);
                buffer.append(student.getStudentName());
                buffer.append("|");
                buffer.append(student.getStudentId());
                buffer.append("|");
                buffer.append(student.getMajorSubject().getSubjectName()+ "\t");
                buffer.append("|");

                getScoreGrade(student, subject.getSubjectId());

                buffer.append("\n");
                buffer.append(LINE);
            }
        }

        public void getScoreGrade(Student student, int subjectId){
            ArrayList<Score> scoreList = student.getScoreList();
            int majorId = student.getMajorSubject().getSubjectId();
            GradeEvaluation[] gradeEvaluation = {new BaseEvaluation(),
                new MajorEvaluation(),new PassFailEvaluation()};

            for(int i=0; i<scoreList.size(); i++){
                Score score = scoreList.get(i);
                if(score.getSubject().getSubjectId()==subjectId){
                    String grade;
                    if(score.getSubject().getGrade() ==Define.PF_TYPE){
                        grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
                    }
                    else{
                        if(score.getSubject().getSubjectId()==subjectId)
                          grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
                          else
                          grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
                    }

                      buffer.append(score.getPoint());
                      buffer.append(":");
                      buffer.append(grade);
                      buffer.append("|");
                }
            }
        }

        public void makeFooter(){
            buffer.append("\n");
        }
    }
