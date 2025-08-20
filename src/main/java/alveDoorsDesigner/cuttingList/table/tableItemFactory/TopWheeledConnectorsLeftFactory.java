package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class TopWheeledConnectorsLeftFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.TOP_WHEELED_CONNECTOR_LEFT.getItemCode(),
                Product.TOP_WHEELED_CONNECTOR_LEFT.getName(),
                "",
                wardrobe.getDoors().size());
    }
}
