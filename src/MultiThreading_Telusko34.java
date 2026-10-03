class MSWord extends Thread{
    @Override
    public void run(){
        String ThreadName = Thread.currentThread().getName();

        if (ThreadName.equals("TYPE")){
            typing();
        } else if (ThreadName.equals("SPELL")) {
            spellCheck();
        }else{
            autoSaving();
        }

    }

    public void typing(){
        try{
            for (int i = 0; i <3 ; i++) {
                System.out.println("Typing.....");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void spellCheck(){
        try{
            for (;;) {
                System.out.println("Spell Checking.....");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoSaving(){
        try{
            for (;;) {
                System.out.println("Auto Saving.....");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
public class MultiThreading_Telusko34 {
    static void main(String[] args) {
        MSWord ms1 = new MSWord();
        MSWord ms2 = new MSWord();
        MSWord ms3 = new MSWord();

        ms1.setName("TYPE");
        ms2.setName("SPELL");
        ms3.setName("SAVING");

        ms2.setDaemon(true);
        ms3.setDaemon(true);

        ms2.setPriority(1);
        ms3.setPriority(2);

        ms1.start();
        ms2.start();
        ms3.start();
    }
}
