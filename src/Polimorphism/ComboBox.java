package Polimorphism;

import java.util.ArrayList;
import java.util.List;
public class ComboBox extends UIControl{
    private List<String> elements;

    public ComboBox(){
        elements = new ArrayList<>();
    }

    public void addElement(String s){
        elements.add(s);
    }
    public void clearAll(){
        elements.clear();
    }
    @Override
    public void render() {
        System.out.println("Rendering a ComboBox");
        for(var e: elements){
            System.out.println("     " + e.toString());
        }
        System.out.println();
    }
}
