/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Account;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed Elias
 */
public class UpdateAccountPageController implements Initializable {

    private Account oldAccount;
    @FXML
    private TextField accountNumberTxt;
    @FXML
    private TextField balanceTxt;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField creationDateTxt;
    @FXML
    private TextField currencyTxt;
    @FXML
    private Button updateAccountBtn;
    @FXML
    private TextField userIDTxt;
    @FXML
    private TextField usernameTF;

    @FXML

    void cancelCreation(ActionEvent event) {
        Controllers.AccountsManagmentController.updateStage.close();
    }

    @FXML
    void updateAccount(ActionEvent event) throws SQLException, ClassNotFoundException {
        int userID = Integer.parseInt(userIDTxt.getText());
        String username = usernameTF.getText();
        int accountNumber = Integer.parseInt(accountNumberTxt.getText());
        String currency = currencyTxt.getText();
        Double balance = Double.parseDouble(balanceTxt.getText());
        String creationDate = creationDateTxt.getText();
        Account newAccount = new Account(userID, accountNumber, username, currency, balance, creationDate);
        newAccount.setId(oldAccount.getId());
        newAccount.update();
        Controllers.AccountsManagmentController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account updated");
        alert.setContentText("Account updated");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.oldAccount = Controllers.AccountsManagmentController.selectedAccountToUpdate;
        userIDTxt.setText(String.valueOf(oldAccount.getUserId()));
        usernameTF.setText(oldAccount.getUsername());
        accountNumberTxt.setText(String.valueOf(oldAccount.getAccountNumber()));
        balanceTxt.setText(String.valueOf(oldAccount.getBalance()));
        creationDateTxt.setText(String.valueOf(oldAccount.getCreationDate()));
        currencyTxt.setText((oldAccount.getCurrency()));
    }

}
