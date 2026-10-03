class MusicPlayer extends Thread{

    public void downloader(){
        int i = 1;
        while(i <= 100){
            if(i % 10 == 0){
                System.out.println("Downloading....." + i + "%");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            i++;
        }

        System.out.println("Download Complete!");
        System.out.println("Ready for Playing Music.....");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

    }

    public void MusicPlay(){
        int i = 1;
        while(i <= 100){
            if(i % 10 == 0){
                System.out.println("Playing Music.....");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {}
            }
            i++;
        }

        System.out.println("Music Complete!");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}
public class MultiThreading_Telusko40 {
    static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        Thread Downloader = new Thread(()->{
            musicPlayer.downloader();
        });

        Thread playMusic = new Thread(()->{
            musicPlayer.MusicPlay();
        });

        Downloader.start();
        playMusic.start();
    }
}
