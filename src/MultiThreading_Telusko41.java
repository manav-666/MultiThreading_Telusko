class Student {
    String name;
    int marks1;
    int marks2;
    int marks3;
    int total;
    double percentage;

    Student(String name, int marks1, int marks2, int marks3) {
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public void CalculateTotal(){
        total = marks1 + marks2 + marks3;
    }

    public void CalculatePercentage(){
        System.out.println("Calculating the Percentage.....");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        percentage = (double) total / 3;
    }

    public void displayResult(){
        System.out.println("Student: " + name);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage);
    }
}

public class MultiThreading_Telusko41 {
    static void main(String[] args) throws InterruptedException{
        Student s1 = new Student("Vishal", 95,89,90);
        Thread CalTotal = new Thread(()->{
            s1.CalculateTotal();
        });
        Thread CalPercentage = new Thread(()->{
            s1.CalculatePercentage();
        });

        Thread displayResult = new Thread(()->{
            s1.displayResult();
        });

        CalTotal.start();
        CalTotal.join();

        CalPercentage.start();
        CalPercentage.join();

        displayResult.start();

    }
}
