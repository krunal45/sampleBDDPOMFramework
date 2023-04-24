package Utility;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class FakeDataGenerator {
    static Faker faker = new Faker();
    public static Map<String, String> fakeData = new HashMap<>();

    public static String getFakeData(String key) {
        String articleTitle = faker.book().title();
        String aboutArticle = faker.lorem().sentence();
        String articleDescription = faker.lorem().paragraph();
        String tags = faker.lorem().words(3).toString().replaceAll("[\\[\\],]", "");
        String userName = faker.name().firstName();
        String email = faker.name().firstName() + "@" + "test.com";
        String password = faker.name().fullName();

        fakeData.put("articleTitle", articleTitle);
        fakeData.put("aboutArticle", aboutArticle);
        fakeData.put("articleDescription", articleDescription);
        fakeData.put("tags", tags);
        fakeData.put("userName", userName);
        fakeData.put("email", email);
        fakeData.put("password", password);

        return fakeData.get(key);
    }
}