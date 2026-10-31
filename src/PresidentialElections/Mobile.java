package PresidentialElections;

public class Mobile extends Device implements MessageSender{
    public Integer mobileNumber;
    public Mobile(int number){
        mobileNumber = number;
    }

    public Mobile(){
    }

    @Override
    public void sendMessage(String message) {
        turnDeviceOn();;
        System.out.println("Contacting API to send the message: \"" + message + "\"");
        if (mobileNumber == null)
            System.out.print("An Unknown number");
        else
            System.out.print(mobileNumber);
        System.out.println(" sent the message successfully !! ");
        System.out.println();
    }
}
