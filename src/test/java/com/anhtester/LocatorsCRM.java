package com.anhtester;

public class LocatorsCRM {
    public static String url = "https://crm.anhtester.com/admin/authentication";

    //Locators for Login Page
    public static String headerLoginPage = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String checkboxRememberMe = "//input[@id='remember']";
    public static String labelRememberMe = "//label[@for='remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String alertErrorMessage = "//div[contains(@class, 'alert-danger')]";
    public static String alertErrorEmailRequired = "//div[normalize-space()='The Email Address field is required.']";
    public static String alertErrorPasswordRequired = "//div[normalize-space()='The Password field is required.']";

    public static void verifyListAlertMessage() {
        // Verify the list of alert messages
        String[] alertMessages = {
                "The Email Address field is required.",
                "The Password field is required.",
                "Invalid login credentials.",
                "Account is locked.",
                "Password expired.",
        };

        for (String message : alertMessages) {
            System.out.println("Alert message: " + message);
            String alertErrorMessageItem = "//div[normalize-space()='" + message + "']";
            System.out.println("XPath Alert message: " + alertErrorMessageItem);
            //driver.findElement(By.xpath(alertErrorMessageItem)).isDisplayed();
        }
    }

//    public static void main(String[] args) {
//        verifyListAlertMessage();
//    }

    //Locators for Dashboard Page
    public static String menuDashboard = "//span[normalize-space()='Dashboard' and @class='menu-text']";
    public static String menuCustomers = "//span[normalize-space()='Customers' and @class='menu-text']";
    public static String menuContracts = "//span[normalize-space()='Contracts' and @class='menu-text']";
    public static String menuProjects = "//span[normalize-space()='Projects' and @class='menu-text']";
    public static String menuTasks = "//span[normalize-space()='Tasks' and @class='menu-text']";

    //Locators for Customers Page
    public static String buttonNewCustomer = "//a[normalize-space()='New Customer']";
    public static String buttonImportCustomer = "//a[normalize-space()='Import Customers']";
    public static String buttonContacts = "//a[normalize-space()='Contacts' and contains(@href, 'all_contacts')]";
    public static String headerCustomerPage = "//span[normalize-space()='Customers Summary']";

    //input[(@type='search') and (@aria-controls='clients')]
    //div[@id='clients_filter']//input[@type='search']
    public static String inputSearchCustomer = "//div[@id='clients_filter']//input[@type='search']";
    public static String firstRowItemCustomer = "//table[@id='clients']//tbody/tr[1]/td[3]/a";

    //Locators for New Customer Page
    public static String inputCompany = "//input[@id='company']";
    public static String inputVatNumber = "//input[@id='vat']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputWebsite = "//input[@id='website']";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputCity = "//input[@id='city']";
    public static String inputState = "//input[@id='state']";
    public static String inputZip = "//input[@id='zip']";

    public static String dropdownGroups = "//button[contains(@data-id,'groups_in')]";
    public static String inputSearchGroups = "//button[contains(@data-id,'groups_in')]/following-sibling::div//input[@type='search']";

    public static String dropdownCurrency = "//button[contains(@data-id,'default_currency')]";
    public static String inputSearchCurrency = "//button[contains(@data-id,'default_currency')]/following-sibling::div//input[@type='search']";

    public static String dropdownLanguage = "//button[contains(@data-id,'default_language')]";
    public static String optionLanguage = "//span[normalize-space()='Vietnamese']";
    public static String optionLanguageDynamic = "(//span[normalize-space()='%s'])[%d]";

    public static String selectXpathLanguage(String language) {
        String xpathLanguage = "//span[normalize-space()='" + language + "']";
        System.out.println("Selecting language: " + language);
        return xpathLanguage;
    }

    public static String dropdownCountry = "//button[contains(@data-id,'country')]";
    public static String inputSearchCountry = "//button[contains(@data-id,'country')]/following-sibling::div//input[@type='search']";

    public static String buttonSave = "//div[@id='profile-save-section']//button[normalize-space()='Save']";

}
