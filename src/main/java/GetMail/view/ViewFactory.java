package GetMail.view;

import GetMail.EmailManager;
import GetMail.Launcher;
import GetMail.controller.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;

    public ViewFactory(EmailManager emailManager){
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    public boolean isMainViewInitialized(){
        return mainViewInitialized;
    }
    //View options handling
    private ThemeColor themeColor = ThemeColor.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ThemeColor getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(ThemeColor themeColor) {
        this.themeColor = themeColor;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow(){
        System.out.println("show login window called");
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        stageInitializer(controller);
    }

    public void showMainWindow(){
        System.out.println("main window called");
        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        stageInitializer(controller);
        mainViewInitialized = true;
    }

    public void showOptionsWindow(){
        System.out.println("main window called");
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        stageInitializer(controller);
    }

    public void showComposeMessageWindow(){
        System.out.println("compose message window called");
        BaseController controller = new ComposeMessageController(emailManager, this, "ComposeMessageWindow.fxml");
        stageInitializer(controller);
    }

    public void showEmailDetailsWindow(){
        BaseController controller = new EmailDetailsController(emailManager, this, "EmailDetailsWindow.fxml");
        stageInitializer(controller);
    }
    public void stageInitializer(BaseController baseController){
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try{
            parent = fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stage) {
        stage.close();
        activeStages.remove(stage);
    }

    public void updateLayoutStyles() {
        for (Stage stage: activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();

            scene.getStylesheets().add(Launcher.class.getResource(ThemeColor.getCssPath(themeColor)).toExternalForm());
            scene.getStylesheets().add(Launcher.class.getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }



}
