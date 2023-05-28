/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Elias
 */
public class AdminDashboard extends Stage {

    private Scene accountsManagmentScene;
    private Scene createAccountScene;

    public AdminDashboard() throws IOException {
        FXMLLoader accountsLoader = new FXMLLoader(getClass().getResource("AccountsManagment.fxml"));
        Parent accountsRoot = accountsLoader.load();
        accountsManagmentScene = new Scene(accountsRoot);
        FXMLLoader createAccountLoader = new FXMLLoader(getClass().getResource("CreateAccount.fxml"));
        Parent createAccountRoot = createAccountLoader.load();
        createAccountScene = new Scene(createAccountRoot);
        this.setScene(accountsManagmentScene);
        this.setTitle("Admin Dashboard");
    }

    public void changeSceneToAccountsManagment() {
        this.setScene(accountsManagmentScene);
    }

    public void changeSceneToCreateAccount() {
        this.setScene(createAccountScene);
    }

}
