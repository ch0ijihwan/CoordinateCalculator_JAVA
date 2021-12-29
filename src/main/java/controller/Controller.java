package controller;

import model.ExpressionFormValidator;
import model.shape.Shape;
import model.shape.ShapeMaker;
import view.Input;
import view.ShowDisplay;

public class Controller {
    public Controller() {
        ShowDisplay.showInputDisplay();
        ExpressionFormValidator expressionFormValidator = new ExpressionFormValidator(Input.input());
        Shape shape = ShapeMaker.makeShape(expressionFormValidator.getPoints());
        ShowDisplay.showArea(shape.getShapeType(),shape.getArea());
    }
}
