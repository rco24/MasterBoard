package PresidentialElections;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args){
        System.out.println("Starting...");

        var campaignList = new Campain();

        campaignList.addMessenger(new Dove("Azulin","Blue", 2));
        campaignList.addMessenger(new Person("Ronald", "Castellon"));
        campaignList.addMessenger(new Dove("Pajarin"));
        campaignList.addMessenger(new Person("Donald", "Trump"));
        campaignList.addMessenger(new Mobile(70771234));
        campaignList.addMessenger(new Mobile());
        campaignList.addMessenger(new Person());

        campaignList.startCampain("Vote for ME!");

        System.out.println();
        System.out.println("Total birds used in campaign: " + Bird.getBirdCounter());
    }
}
