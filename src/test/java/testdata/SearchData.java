package testdata;

import com.github.javafaker.Faker;

import java.util.Locale;

public class SearchData {

    Faker faker = new Faker(new Locale("ru"));

    public String searchCredit;
    public String placeholderText;


    public SearchData() {

        this.placeholderText = faker.options().option("Поиск по сайту");
        this.searchCredit = faker.options().option("Кредит на белорусские товары и услуги в любых магазинах",
                "Кредит на автомобили белорусского производства",
                "Кредит на белорусские товары и услуги у партнеров Приорбанка");
    }

}
