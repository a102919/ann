package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Controller {
    @FXML
    private TextField timeId;
    @FXML
    private TextField hId;
    @FXML
    private Button CalculationId;
    @FXML
    private TextArea showid;
    @FXML
    private void Calculation(ActionEvent actionEvent){
        showid.setText("");
        double Η = 0;
        if(hId.getText()!="") {
            Η = Double.parseDouble(hId.getText());
        }
        cellbody cellbody = new cellbody();
        Map<Integer,Double> w = cellbody.initW();
        showid.appendText("亂數取得w1值\n");
        showW(w);
        showid.appendText("--------------------\n");
        List<List<Double>> x = cellbody.initX();
        cellbody.train(w,x,Η,showid);
        showid.appendText("結束迴圈--------\n");
        showid.appendText("最後得到w值\n");
        showW(w);

    }

    private void showW(Map<Integer, Double> w) {
        showid.appendText("w : ");
        for (Integer key:w.keySet()){
            DecimalFormat df=new DecimalFormat("#.##");
            String Strw=df.format(w.get(key));
            showid.appendText(Strw+" , ");
        }
        showid.appendText("\n");
    }
}
