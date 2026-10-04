class Hospital{
    boolean isPatientAva = true;
    boolean registrationDone = false;
    boolean consultationDone = false;
    boolean bloodTest = false;
    boolean xRay = false;
    boolean testResult = false;
    boolean doctorReview = false;
    boolean havePrescription = false;
    boolean haveMedicine = false;

    synchronized public void setPatientAva() throws InterruptedException{
        while(!isPatientAva){
            System.out.println("Waiting for Patients...");
            wait();
        }
        registrationDone = true;
        System.out.println("Registration is completed.");
        notifyAll();
    }

    synchronized public void setRegistrationDone()throws InterruptedException{
        while(!registrationDone){
            System.out.println("Waiting for Patients Registration.");
            wait();
        }
        consultationDone = true;
        System.out.println("Consultation is done.");
        notifyAll();
    }

    synchronized public void setXRayTest()throws InterruptedException{
        while(!consultationDone){
            System.out.println("Waiting for the patient for Test");
            wait();
        }

        xRay =true;
        System.out.println("X-Ray is completed");
        notifyAll();
    }

    synchronized public void setBloodTest()throws InterruptedException{
        while(!consultationDone){
            System.out.println("Waiting for the patient for Test");
            wait();
        }
        bloodTest = true;
        System.out.println("Blood Test is Completed");
        notifyAll();
    }


    synchronized public void setTestCompleted()throws InterruptedException{
        while (!bloodTest || !xRay){
            System.out.println("Waiting for the Patient Test Completion");
            wait();
        }

        testResult = true;
        System.out.println("Test result is arrived");
        notifyAll();
    }

    synchronized public void setTestResult()throws InterruptedException{
        while(!testResult){
            System.out.println("Waiting for the Test Result");
            wait();
        }
        doctorReview =true;
        System.out.println("Doctor Review is Completed");
        notifyAll();
    }

    synchronized public void setHavePrescription()throws InterruptedException{
        while(!doctorReview){
            System.out.println("Waiting for Doctor Prescription");
            wait();
        }
        havePrescription = true;
        System.out.println("Searching for the Medicine");
        notifyAll();
    }

    synchronized public void setHaveMedicine() throws InterruptedException {
        while(!havePrescription){
            System.out.println("Waiting for Prescription");
            wait();
        }

        haveMedicine = true;
        System.out.println("Medicine are Available");
        System.out.println("Billing of Medicine.");
        notifyAll();
    }
}
public class MultiThreading_Telusko49 {
    static void main(String[] args)throws InterruptedException {
        Hospital h1 = new Hospital();

        Thread t1 = new Thread(()->{
            try{
                h1.setPatientAva();
            } catch (InterruptedException _) {}
        });

        Thread t2 = new Thread(()->{
            try{
                h1.setRegistrationDone();
            } catch (InterruptedException _) {}
        });

        Thread t3 = new Thread(()->{
            try{
                h1.setBloodTest();
            } catch (InterruptedException _) {}
        });

        Thread t4 = new Thread(()->{
            try{
                h1.setXRayTest();
            } catch (InterruptedException _) {}
        });

        Thread t5 = new Thread(()->{
            try{
                h1.setTestCompleted();
            } catch (InterruptedException _) {}
        });

        Thread t6 = new Thread(()->{
            try{
                h1.setTestResult();
            } catch (InterruptedException _) {}
        });

        Thread t7 = new Thread(()->{
            try{
                h1.setHavePrescription();
            } catch (InterruptedException _) {}
        });

        Thread t8 = new Thread(()->{
            try{
                h1.setHaveMedicine();
            } catch (InterruptedException _) {}
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();


    }
}
