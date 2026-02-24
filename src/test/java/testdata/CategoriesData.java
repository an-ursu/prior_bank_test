package testdata;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CategoriesData {

    Faker faker = new Faker(new Locale("ru"));
    public String buttonName;

    public static final List<String> MAIN_VISIBLE_CATEGORIES = Arrays.asList(
            "Кредиты", "Карточки", "Пакеты сервисов",
            "Переводы", "Вклады и инвестиции"
    );

    public static final List<String> DROPDOWN_CATEGORIES = Arrays.asList(
            "Страхование", "Онлайн сервисы"
    );

    public static final List<String> ALL_CATEGORIES = Arrays.asList(
            "Кредиты", "Карточки", "Пакеты сервисов",
            "Переводы", "Вклады и инвестиции", "Страхование", "Онлайн сервисы"
    );

    public CategoriesData() {
        this.buttonName = faker.options().option("Еще");
    }


}
