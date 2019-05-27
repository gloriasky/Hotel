package front.sample.helpers;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;

public class ChangeListenerImpl {
    public static ChangeListener<String> getDataCheckListener(Label label) {
        return (observable, oldValue, newValue) -> {
            if (newValue.equals("")) {
                label.setText("");
            } else if (!newValue.matches("[0-3][0-9][.][0-1][0-9][.][1-2][0-9][0-9][0-9]")) {
                label.setText("Введена неправильная дата");
            } else {
                label.setText("");
            }
        };
    }

    public static ChangeListener<String> getNumberCheckListener(Label label) {
        return (observable, oldValue, newValue) -> {
            if (newValue.equals("")) {
                label.setText("");
            } else if (!newValue.matches("\\d*")) {
                label.setText("Введено неправильное число");
            } else {
                label.setText("");
            }
        };
    }
}
