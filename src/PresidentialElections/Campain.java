package PresidentialElections;

import java.util.ArrayList;

public class Campain {
    private ArrayList<MessageSender> messengersList;

    public Campain(){
        messengersList = new ArrayList<>();
    }

    public void addMessenger(MessageSender messenger){
        messengersList.add(messenger);
    }

    public void startCampain(String message){

        System.out.println("Starting Campaign.. ");
        System.out.println();
        for (MessageSender messenger: messengersList){
            messenger.sendMessage(message);
        }
    }
}
