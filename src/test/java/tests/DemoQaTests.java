package tests;
import org.junit.jupiter.api.Test;
import pages.DemoQaFormPage;


public class DemoQaTests extends TestBase {
    DemoQaFormPage DemoQaFormPage;


    @Test
    void pageObjectDemoQa() {
        DemoQaFormPage = new DemoQaFormPage();

        DemoQaFormPage.openDemoQaSite();
        DemoQaFormPage.fillTestForm();
        DemoQaFormPage.checkForm();




    }
}
