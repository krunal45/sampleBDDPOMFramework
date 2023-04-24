package Utility;

import java.util.HashMap;
import java.util.Map;

public class ProjectConstants {


    private static Map<String, String> articleDetails = new HashMap<>();
    private static Map<String, String> userCredentials = new HashMap<>();

    public static void setUserName(String userName) {
        userCredentials.put("userName", userName);
    }

    public static void setPassword(String password) {
        userCredentials.put("password", password);
    }

    public static String getUserName() {
        return userCredentials.get("userName");
    }

    public static String getPassword() {
        return userCredentials.get("password");
    }

    public static void setArticleTitle(String articleTitle) {
        articleDetails.put("articleTitle", articleTitle);
    }

    public static String getArticleTitle() {
        return articleDetails.get("articleTitle");
    }

    public static void setAboutArticle(String aboutArticle) {
        articleDetails.put("aboutArticle", aboutArticle);
    }

    public static String getAboutArticle() {
        return articleDetails.get("aboutArticle");
    }

    public static void setArticleDescription(String articleDescription) {
        articleDetails.put("articleDescription", articleDescription);
    }

    public static String getArticleDescription() {
        return articleDetails.get("articleDescription");
    }

    public static void setArticleTags(String articleTags) {
        articleDetails.put("articleTags", articleTags);
    }

    public static String getArticleTags() {
        return articleDetails.get("articleTags");
    }
}