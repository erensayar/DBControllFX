package dbcontrollfx.Controller;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class AnaPencereController {

    private ObservableList<ObservableList> data;

    @FXML
    private Button bt_read;
    @FXML
    private Button bt_update;
    @FXML
    private Button bt_add;
    @FXML
    private Button bt_delete;

    @FXML
    private TextField tf_1;
    @FXML
    private TextField tf_2;
    @FXML
    private TextField tf_3;
    @FXML
    private TextField tf_4;
    @FXML
    private TextField tf_5;
    @FXML
    private TextField tf_6;
    @FXML
    private TextField tf_7;
    @FXML
    private TextField tf_8;
    @FXML
    private TextField tf_9;
    @FXML
    private TextField tf_10;
    @FXML
    private TextField tf_11;
    @FXML
    private TextField tf_12;
    @FXML
    private TextField tf_13;
    @FXML
    private TextField tf_14;
    @FXML
    private TextField tf_15;
    @FXML
    private TextField tf_clear;

    @FXML
    private Label label_mesaj;
    @FXML
    private Label label_db_table;

    @FXML
    private TextField tf_tableName;

    @FXML
    private TableView tableview;

    private int numberOfColumns;
    private String tableName;

    @FXML
    void read(ActionEvent event) {
        tableName = tf_tableName.getText();
        label_db_table.setText("DataBase: " + AdminGirisController.dbName + "  |  Table: " + tableName);

        tableview.getColumns().clear();
        tablodoldur();
    }

    @FXML
    void add(ActionEvent event) {
        tableName = tf_tableName.getText();
        label_db_table.setText("DataBase: " + AdminGirisController.dbName + "  |  Table: " + tableName);

        Connection con = null;
        Statement statement = null;

    }

    @FXML
    void delete(ActionEvent event) {
        tableName = tf_tableName.getText();
        label_db_table.setText("DataBase: " + AdminGirisController.dbName + "  |  Table: " + tableName);

    }

    @FXML
    void update(ActionEvent event) {
        tableName = tf_tableName.getText();
        label_db_table.setText("DataBase: " + AdminGirisController.dbName + "  |  Table: " + tableName);

    }

    //Read Kısmı (Tableview)
    /**
     * **********************************************************************************************************
     */
    private void tablodoldur() {
        Connection c;
        data = FXCollections.observableArrayList();

        try {
            c = (Connection) dbcontrollfx.Connection.DBConnect.connect();
            String SQL = "SELECT * from " + tableName;
            ResultSet rs = c.createStatement().executeQuery(SQL);
            //Kolon Sayısını öğrendik
            numberOfColumns = rs.getMetaData().getColumnCount();
            //Kolonları çektik
            for (int i = 0; i < numberOfColumns; i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableview.getColumns().addAll(col);

            }

            while (rs.next()) {
                //Satırları yinele
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= numberOfColumns; i++) {
                    //sütunları yinele
                    row.add(rs.getString(i));
                }
                data.add(row);
                label_mesaj.setText("DataBase Reading is Successful");

            }
            //Sonucu tabloya ekleme
            tableview.setItems(data);

        } catch (Exception e) {
            //e.printStackTrace();
            label_mesaj.setText("DataBase Reading is Failed");
        }
    }

    /**
     * **********************************************************************************************************
     */

    @FXML
    private void tw_mouseClicked(MouseEvent event) {
        //Bu kısımda tableviewden seçilen öğeyi textfield'lara yazdıracağız.
        Object obj = tableview.getSelectionModel().getSelectedItem();
        String selectedItem = obj.toString();
        selectedItem = selectedItem.substring(1, selectedItem.length() - 1);
        String[] parsedStr = selectedItem.split(", ");

//##############################################################################        
        if (numberOfColumns == 1) {
            tf_2.clear();
            tf_3.clear();
            tf_4.clear();
            tf_5.clear();
            tf_5.clear();
            tf_6.clear();
            tf_7.clear();
            tf_8.clear();
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
        } else if (numberOfColumns == 2) {
            tf_3.clear();
            tf_4.clear();
            tf_5.clear();
            tf_5.clear();
            tf_6.clear();
            tf_7.clear();
            tf_8.clear();
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
        } else if (numberOfColumns == 3) {
            tf_4.clear();
            tf_5.clear();
            tf_5.clear();
            tf_6.clear();
            tf_7.clear();
            tf_8.clear();
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
        } else if (numberOfColumns == 4) {
            tf_5.clear();
            tf_5.clear();
            tf_6.clear();
            tf_7.clear();
            tf_8.clear();
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
        } else if (numberOfColumns == 5) {
            tf_5.clear();
            tf_6.clear();
            tf_7.clear();
            tf_8.clear();
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
        } else if (numberOfColumns == 6) {
            tf_7.clear();
            tf_8.clear();
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
        } else if (numberOfColumns == 7) {
            tf_8.clear();
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
        } else if (numberOfColumns == 8) {
            tf_9.clear();
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
        } else if (numberOfColumns == 9) {
            tf_10.clear();
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
            tf_9.setText(parsedStr[8]);
        } else if (numberOfColumns == 10) {
            tf_11.clear();
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
            tf_9.setText(parsedStr[8]);
            tf_10.setText(parsedStr[9]);
        } else if (numberOfColumns == 11) {
            tf_12.clear();
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
            tf_9.setText(parsedStr[8]);
            tf_10.setText(parsedStr[9]);
            tf_11.setText(parsedStr[10]);
        } else if (numberOfColumns == 12) {
            tf_13.clear();
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
            tf_9.setText(parsedStr[8]);
            tf_10.setText(parsedStr[9]);
            tf_11.setText(parsedStr[10]);
            tf_12.setText(parsedStr[11]);
        } else if (numberOfColumns == 13) {
            tf_14.clear();
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
            tf_9.setText(parsedStr[8]);
            tf_10.setText(parsedStr[9]);
            tf_11.setText(parsedStr[10]);
            tf_12.setText(parsedStr[11]);
            tf_13.setText(parsedStr[12]);
        } else if (numberOfColumns == 14) {
            tf_15.clear();

            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
            tf_9.setText(parsedStr[8]);
            tf_10.setText(parsedStr[9]);
            tf_11.setText(parsedStr[10]);
            tf_12.setText(parsedStr[11]);
            tf_13.setText(parsedStr[12]);
            tf_14.setText(parsedStr[13]);
        } else if (numberOfColumns == 15) {
            tf_1.setText(parsedStr[0]);
            tf_2.setText(parsedStr[1]);
            tf_3.setText(parsedStr[2]);
            tf_4.setText(parsedStr[3]);
            tf_5.setText(parsedStr[4]);
            tf_6.setText(parsedStr[5]);
            tf_7.setText(parsedStr[6]);
            tf_8.setText(parsedStr[7]);
            tf_9.setText(parsedStr[8]);
            tf_10.setText(parsedStr[9]);
            tf_11.setText(parsedStr[10]);
            tf_12.setText(parsedStr[11]);
            tf_13.setText(parsedStr[12]);
            tf_14.setText(parsedStr[13]);
            tf_15.setText(parsedStr[14]);
        }
//##############################################################################        

        /*
         for(int i=0 ; i<parsedStr.length ; i++){
            tf_i.setText(parsedStr[i]);
            //Gibi bir yapı düşünülebilir ama java bilgim yetmedi.
        }       
         */
    }

    /**
     * **********************************************************************************************************
     */
    @FXML
    private void clear(ActionEvent event) {
        tf_1.clear();
        tf_2.clear();
        tf_3.clear();
        tf_4.clear();
        tf_5.clear();
        tf_5.clear();
        tf_6.clear();
        tf_7.clear();
        tf_8.clear();
        tf_9.clear();
        tf_10.clear();
        tf_11.clear();
        tf_12.clear();
        tf_13.clear();
        tf_14.clear();
        tf_15.clear();
    }

}
