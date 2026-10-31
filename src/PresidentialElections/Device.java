package PresidentialElections;

abstract class Device {
    public boolean isOn;

    public Device(){
        isOn = false;
    }

    public void turnDeviceOn(){
        System.out.println("Starting device...");
        isOn = true;
        System.out.println("Device up and running! ");
    }
}
