package lesson6.part_02.frame_08;

public class DemoLauncher {

    public static void main(String[] args) {
        Subscriber name01 = new Subscriber();
        name01.setName("Anton");
        name01.setMail("aaa@ukr.net");

        Subscriber name02 = new Subscriber();
        name02.setName("Igor");
        name02.setMail("igor@ukr.net");


        Newspaper np01 = new Newspaper();
        np01.setNewspaperTitle("Sport");

        Newspaper np02 = new Newspaper();
        np02.setNewspaperTitle("Biznes");

        Magazine mg01 = new Magazine();
        mg01.setJournalTitle("Auto 2016");


        NewReleaseNumbersObserver newReleaseObserveNpr01 = new NewReleaseNumbersObserver();
        NewReleaseNumbersObserver newReleaseObserveNpr02 = new NewReleaseNumbersObserver();
        NewReleaseNumbersObserver newReleaseObserveMg01 = new NewReleaseNumbersObserver();

        NewSubscruberRegistrationObserver subsRegistrObserverNp01 = new NewSubscruberRegistrationObserver();
        NewSubscruberRegistrationObserver subsRegistrObserverNp02 = new NewSubscruberRegistrationObserver();
        NewSubscruberRegistrationObserver subsRegistrObserverMg01 = new NewSubscruberRegistrationObserver();

        np01.addObserver(newReleaseObserveNpr01);
//        np02.addObserver(newReleaseObserveNpr02);
//        mg01.addObserver(newReleaseObserveMg01);
//
//        np01.addObserver(subsRegistrObserverNp01);
//        np02.addObserver(subsRegistrObserverNp02);
//        mg01.addObserver(subsRegistrObserverMg01);
//
//
        np01.addNewSubscruber(name01);
        np01.addNewSubscruber(name02);
//        np02.addNewSubscruber(name01);
//        printSeparator();
//
        np01.releaseNewNumbers();
//        np02.releaseNewNumbers();
//        printSeparator();
//
//        mg01.addNewSubscruber(name01);
//        mg01.addNewSubscruber(name02);
//        printSeparator();
//
//        mg01.releaseNewNumbers();
//        printSeparator();
//
//        np01.removeSubscruber(name01);
//
//        np01.releaseNewNumbers();
//        printSeparator();
    }

    public static void printSeparator(){
        System.out.println("*****************************************************************");
    }
}
