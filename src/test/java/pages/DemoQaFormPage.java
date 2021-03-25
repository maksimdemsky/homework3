package pages;
import com.github.javafaker.Faker;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaFormPage {


    Faker faker = new Faker();
    String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            mobile = faker.number().digits(10),
            address = faker.address().fullAddress(),
            birth = "07 March,1997",
            hobby1 = "Sports",
            hobby2 = "Music",
            state = "NCR",
            city = "Delhi",
            stateAndCity = "NCR Delhi",
            fullName = firstName + " " + lastName,
            hobbies = "Sports, Music",
            acceptFormText = "Thanks for submitting the form",
            sex = "Male",
            subject = "Physics";


    public void openDemoQaSite()
    {
        open("https://demoqa.com/automation-practice-form");
    }


    public void fillTestForm() {


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(sex)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__month").$(byText("7")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/123.jpg"));
        $("#currentAddress").setValue(address);
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $(byText(state)).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $(byText(city)).click();
        $("#submit").click();
    }

    public void checkForm() {
        $(".modal-content").shouldHave(text(acceptFormText),
                text(fullName),
                text(userEmail),
                text(mobile),
                text("Male"),
                text(birth),
                text("Physics"),
                text(hobbies),
                text("123.jpg"),
                text(address),
                text(stateAndCity));

    }


}
