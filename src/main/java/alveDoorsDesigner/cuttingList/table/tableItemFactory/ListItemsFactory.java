package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

import java.util.List;

public interface ListItemsFactory {
    List<TableItem> create(Wardrobe wardrobe);
}
