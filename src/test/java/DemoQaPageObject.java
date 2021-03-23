import org.junit.jupiter.api.Test;


public class DemoQaPageObject extends TestBase {
    DemoQaForm DemoQaForm;


    @Test
    void pageObjectDemoQa() {
        DemoQaForm = new DemoQaForm();

        DemoQaForm.openDemoQaSite();
        DemoQaForm.fillTestForm();
        DemoQaForm.checkForm();




    }
}
