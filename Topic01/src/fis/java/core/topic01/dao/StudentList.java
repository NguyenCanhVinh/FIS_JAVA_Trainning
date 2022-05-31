package fis.java.core.topic01.dao;

import fis.java.core.topic01.core.Student;
import fis.java.core.topic01.dao.ISortStrategy;
import fis.java.core.topic01.dao.SelecttionSortStrategy;

public class StudentList  {
    public final  int MAX=100;
    private Student[] students;
    private  int count;
    private ISortStrategy sortStrategy;
    public StudentList() {
        this.count=0;
        this.students= new Student[MAX];
        this.sortStrategy=new SelecttionSortStrategy();

    }


    public void  addStudent(Student student){

    }

    public Student remove(int code){

        return null;
    }

    public void display(){

    }
    public void  sort(){

    }

    public void setSortStrategy(ISortStrategy iSortStrategy){

        this.sortStrategy=sortStrategy;
    }

}
