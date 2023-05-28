/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Account;
import View.ViewManager;
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
public class CreateAccountController implements Initializable {

    @FXML
    private TextField accountNumberTxt;

    @FXML
    private Button accountsManagmentPageBtn;

    @FXML
    private Button accountsPageBtn;

    @FXML
    private TextField balanceTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField creationDateTxt;

    @FXML
    private TextField currencyTxt;

    @FXML
    private Button operationsPageBtn;

    @FXML
    private Button saveNewAccountBtn;

    @FXML
    private TextField usernameTF;

    @FXML
    private TextField userIDTxt;

    @FXML
    void cancelAccountCreation(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    void saveNewAccount(ActionEvent event) throws SQLException, ClassNotFoundException {
        int userID = Integer.parseInt(userIDTxt.getText());
        String username = usernameTF.getText();
        int accountNumber = Integer.parseInt(accountNumberTxt.getText());
        String currency = currencyTxt.getText();
        Double balance = Double.parseDouble(balanceTxt.getText());
        String creationDate = creationDateTxt.getText();
        Account account = new Account(userID, accountNumber, username, currency, balance, creationDate);
        account.save();

        ViewManager.adminPage.changeSceneToAccountsManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account inserted");
        alert.setContentText("Account inserted");
        alert.showAndWait();
    }

    @FXML
    void showUsersManagmentPage(ActionEvent event) {

    }

    @FXML
    void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    void showOperationsPage(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
