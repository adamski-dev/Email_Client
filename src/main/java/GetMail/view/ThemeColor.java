package GetMail.view;

public enum ThemeColor {

    LIGHT,
    DEFAULT,
    DARK;

    public static String getCssPath(ThemeColor themeColor){
        switch(themeColor){
            case LIGHT:
                return "css/themeLight.css";
            case DEFAULT:
                return "css/themeDefault.css";
            case DARK:
                return "css/themeDark.css";
            default:
                return null;
        }
    }
}
