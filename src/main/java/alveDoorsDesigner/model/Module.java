package alveDoorsDesigner.model;

import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentType;

/*Represents place where fulfillment is visible from client point of view.
* Place between vertical and horizontal bars*/
public class Module {
    private int width;
    private int height;
    private FulfillmentType fulfillmentType = FulfillmentType.GLASS;

    public Module(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getWidth() {
        return width;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public int getHeight() {
        return height;
    }

    public void setFulfillmentType(FulfillmentType fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

    public FulfillmentType getFulfillmentType()
    {
        return fulfillmentType;
    }
}

