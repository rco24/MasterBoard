package FactoryPattern;

public class ShapeFactory {
    public I_Shape getShape(String shape){
        switch (shape){
            case "Circle":  return (new Circle());
            case "Square":  return (new Square(1));
            default:
                return new UndefinedShape(shape);
        }
    }
}
