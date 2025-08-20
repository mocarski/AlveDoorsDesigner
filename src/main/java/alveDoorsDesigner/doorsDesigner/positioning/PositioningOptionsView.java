package alveDoorsDesigner.doorsDesigner.positioning;


import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.model.Door;
import com.vaadin.ui.*;

import java.util.LinkedList;
import java.util.List;

public class PositioningOptionsView extends VerticalLayout {

    private final Wardrobe wardrobe;
    private final HorizontalLayout positioningOptionsLayout;

    Label label = new Label(Constants.ACCESSORIES);

    public PositioningOptionsView(Wardrobe wardrobe, HorizontalLayout positioningOptionsLayout) {
        this.wardrobe = wardrobe;
        this.positioningOptionsLayout = positioningOptionsLayout;

        positioningOptionsLayout.setMargin(false);
        addComponents(label, positioningOptionsLayout);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        setWidthUndefined();
        setMargin(false);
        setStyleName("MarginTopAndBottom");
        setVisible(false);
    }

    public void createPositioningOptions() {
        positioningOptionsLayout.removeAllComponents();

        for (Door door : wardrobe.getDoors())
            positioningOptionsLayout.addComponent(new PositioningOptionSelect(wardrobe, door));
    }

    public void updateAvailablePositioningOptions() {
        for (PositioningOptionSelect positioningOptionSelect : getPositioningOptionSelects())
            positioningOptionSelect.update();
    }

    private List<PositioningOptionSelect> getPositioningOptionSelects(){
        List<PositioningOptionSelect> selects = new LinkedList<>();
        for(Component component : (Iterable<Component>) () -> positioningOptionsLayout.getComponentIterator())
            selects.add((PositioningOptionSelect)component);

        return selects;
    }
}
