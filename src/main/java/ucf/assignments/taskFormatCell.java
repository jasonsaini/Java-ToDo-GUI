package ucf.assignments;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;

public class taskFormatCell extends ListCell<listItem> {

    public taskFormatCell() {}
    @Override
    protected void updateItem(listItem item, boolean isComplete)
    {
        super.updateItem(item,isComplete);
        setText(item.toString());
        if(item != null)
        {
            boolean complete = item.isComplete;
            setTextFill(complete ? Color.GREEN : Color.RED);
        }
    }

}
