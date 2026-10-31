package Polimorphism;

public class Main {
    public static void main(String[] args){
        ComboBox combobox = new ComboBox();
        combobox.addElement("Option One");
        combobox.addElement("Option Two");
        UIControl[] controls = {new TextBox(), new CheckBox(), combobox};
        renderUIControls(controls);
    }
    public static void renderUIControls(UIControl[] c){
        for(var control: c){
            control.render();
        }
    }
}
