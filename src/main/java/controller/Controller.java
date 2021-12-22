package controller;

import model.Validator;
import model.shape.Shape;
import model.shape.ShapeMaker;
import view.Input;
import view.ShowDisplay;

public class Controller {
    public Controller() {
        ShowDisplay.showInputDisplay();
        Validator validator = new Validator(Input.input());
        Shape shape = ShapeMaker.makeShape(validator.getPoints());
        ShowDisplay.showArea(shape.getShapeType(),shape.getArea());
    }
}
