package GetMail.controller;

import GetMail.EmailManager;
import GetMail.view.ViewFactory;

public abstract class BaseController {

    protected EmailManager emailManager;
    protected ViewFactory viewFactory;
    private final String fxmlName;

    public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName(){
        return fxmlName;
    }
}
