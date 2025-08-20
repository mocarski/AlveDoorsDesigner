package alveDoorsDesigner.doorsDesigner.visualization;

import alveDoorsDesigner.model.Module;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.Constants;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.WardrobeToolbox;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;


public class VisualizationView extends AbsoluteLayout {
    private final Wardrobe wardrobe;

    //Variable to change size of visualization by hand quickly
    private int divider = 8;

    public VisualizationView(Wardrobe wardrobe){
        this.wardrobe = wardrobe;
        setStyleName("FrameColorAndMarginTopBottom");
        setVisible(false);
    }

    public void update() {
        removeAllComponents();

        setWidth(wardrobe.getDoorsWidth() / divider + "px");
        setHeight(wardrobe.getDoorsHeight() / divider + "px");

        for (Door door : wardrobe.getDoors()) {
            for(Module module : door.getModules()) {
                Button button = createButtonForModule(wardrobe, door, module);
                addComponent(button, countCssPosition(wardrobe, door, module));
            }
        }
    }

    private Button createButtonForModule(Wardrobe wardrobe, Door door, Module module) {
        Button button = new NativeButton();
        button.setWidth(Math.round(calculateWidthOfButton(wardrobe, door, module)) + "px");
        button.setHeight(Math.round(calculateHeightOfButton(door, module)) + "px");
        button.setStyleName(getBorderStyleDependsOnModulePosition(wardrobe, door, module));

        return button;
    }

    private String getBorderStyleDependsOnModulePosition(Wardrobe wardrobe, Door door, Module module) {
        if (WardrobeToolbox.isSingleModule(wardrobe, door, module))
            return "Only";
        else if (WardrobeToolbox.isOnlyModuleInLeftSection(wardrobe, door, module))
            return "LeftOnly";
        else if (WardrobeToolbox.isOnlyModuleInRightSection(wardrobe, door, module))
            return "RightOnly";
        else if (WardrobeToolbox.isOnlyModuleInMiddleSection(wardrobe, door, module))
            return "MiddleOnly";
        else if (WardrobeToolbox.isTopModuleInLeftSection(wardrobe, door, module))
            return "LeftTop";
        else if (WardrobeToolbox.isBottomModuleInLeftSection(wardrobe, door, module))
            return "LeftBottom";
        else if (WardrobeToolbox.isTopModuleInRightSection(wardrobe, door, module))
            return "RightTop";
        else if (WardrobeToolbox.isBottomModuleInRightSection(wardrobe, door, module))
            return "RightBottom";
        else if (WardrobeToolbox.isMiddleModuleInLeftSection(wardrobe, door, module))
            return "MiddleLeft";
        else if (WardrobeToolbox.isMiddleModuleInRightSection(wardrobe, door, module))
            return "MiddleRight";
        else if (WardrobeToolbox.isTopModuleInMiddleSection(wardrobe, door, module))
            return "MiddleTop";
        else if (WardrobeToolbox.isBottomModuleInMiddleSection(wardrobe, door, module))
            return "MiddleBottom";
        else
            return "Middle";
    }

    private String countCssPosition(Wardrobe wardrobe, Door door, Module module) {
        return String.format("top: %spx; left: %spx", WardrobeToolbox
                        .countSummaryHeightOfModulesOnTheTop(door, module) / divider, WardrobeToolbox
                        .countSummaryWidthOfSectionsOnTheLeft(wardrobe, door) / divider);
    }

    private int calculateHeightOfButton(Door door, Module module) {
        if (WardrobeToolbox.isSingleModule(door, module))
            return (module.getHeight() + 2* Constants.HORIZONTAL_PROFILE_WIDTH)/ divider;
        else if (WardrobeToolbox.isUtmostModule(door, module))
            return (module.getHeight() + Constants.HORIZONTAL_PROFILE_WIDTH + Constants.HBAR_WIDTH/2)/
                    divider;
        else
            return (module.getHeight() + Constants.HBAR_WIDTH)/ divider;
    }

    private int calculateWidthOfButton(Wardrobe wardrobe, Door door, Module module) {

        if (WardrobeToolbox.isOnlySection(wardrobe,door))
            return door.getWidth()/ divider;
        else if (WardrobeToolbox.isUtmostDoor(wardrobe,door))
            return (int) ((door.getWidth() - 0.5*Constants.VERTICAL_PROFILE_WIDTH)/ divider);
        else
            return (door.getWidth() - Constants.VERTICAL_PROFILE_WIDTH)/ divider;
    }
}
