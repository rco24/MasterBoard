package AnonymousClass;

public class Main {
    public static void main(String[] args){
        //  Anonymous class = A class that doesn't have a name, used to instantiate only one object, it cannot be reused.
        //                    Add custom behavior without having to create a new class.
        //                    Often used for one time uses (TimerTask, Runnable, callbacks)

        Animal myAnimal = new Animal();
        myAnimal.makeNoise();

        //here is the anonymous class
        Animal bigfoot = new Animal(){
          @Override
            public void makeNoise(){
              System.out.println("Grawlneenlnenlengehehe");
          }
        };
        bigfoot.makeNoise();

        // anonymous class that implements an interface
        Runnable myAnonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm an anonymous runnable");
            }
        };
        myAnonymousRunnable.run();
    }
}
