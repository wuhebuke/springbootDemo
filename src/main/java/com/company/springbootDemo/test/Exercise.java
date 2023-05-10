package com.company.springbootDemo.test;

/**
 * @author : farid
 * @date : 2023/5/10 20:26
 */
public class Exercise {
    public void doWeek(Week week){
        switch (week){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("写代码");
                break;
            case SATURDAY:
                System.out.println("运动");
                break;
            case SUNDAY:
                System.out.println("睡大觉");
                break;

        }
    }

    public static void main(String[] args) {
        Exercise exercise = new Exercise();
        exercise.doWeek(Week.THURSDAY);
        exercise.doWeek(Week.SATURDAY);
    }
}

