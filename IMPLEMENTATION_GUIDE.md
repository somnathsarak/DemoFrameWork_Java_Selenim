# DemoFrameWork_Java_Selenim - Implementation Guide

## Framework Setup Status ✅

### Completed
- ✅ Maven Project Structure (pom.xml with all dependencies)
- ✅ Directory Structure (src/main, src/test, resources, reports, test-output, config)
- ✅ README.md (comprehensive documentation)
- ✅ .gitignore (Maven + IDE)
- ✅ BasePage.java (base page class with common methods)

## Implementation Roadmap

### Phase 1: Base Classes (In Progress)

#### 1. BaseTest.java
- TestNG @BeforeMethod setup
- Driver initialization
- ExtentReport initialization
- @AfterMethod teardown
- Take screenshot on failure

#### 2. WebDriverFactory.java
- Chrome driver setup
- Firefox driver setup  
- Edge driver setup
- Headless mode support
- WebDriverManager for auto driver downloads

#### 3. ConfigReader.java
- Read config.properties
- Get browser type
- Get base URL
- Get timeouts
- Get test data path

#### 4. ExtentReportManager.java
- Initialize ExtentReports
- Create test node
- Log steps
- Attach screenshots
- Flush and close reports

### Phase 2: Configuration Files

#### src/main/resources/config.properties
```properties
baseURL=https://opensource-demo.orangehrmlive.com
browser=chrome
implicit_wait=10
explicit_wait=15
page_load_timeout=30
headless=false
screenshot_on_failure=true
test_data_path=src/test/resources/testdata.xlsx
log_level=INFO
```

#### src/main/resources/log4j2.properties
- Log file location: logs/
- Log pattern with timestamp
- Console and file appenders
- Log levels: INFO, WARN, ERROR, DEBUG

#### src/test/resources/testng.xml
- Test suite configuration
- Test grouping
- Listeners configuration
- Parallel execution settings

### Phase 3: Utility Classes

#### WebDriverUtils.java
- Navigation methods
- Window handle switching
- Alert handling
- JavaScript execution
- Scroll operations

#### DataProvider.java
- Excel data reading
- Test data parameterization
- Dynamic test case generation

#### FileUtils.java
- Screenshot capture
- File operations
- Excel file handling
- JSON reading

#### ReportUtils.java
- Report directory creation
- Report naming convention (date+time)
- Screenshot attachment to report

### Phase 4: Listener Classes

#### TestListener.java (ITestListener)
- onTestStart()
- onTestSuccess()
- onTestFailure() - capture screenshot
- onTestSkipped()
- onFinish()

#### RetryAnalyzer.java (IRetryAnalyzer)
- Retry failed tests up to 2 times
- Only retry if enabled in config

### Phase 5: Page Object Classes

#### LoginPage.java
- Email field locator
- Password field locator
- Login button
- Methods: login(), isLoginSuccessful()

#### HomePage.java
- Home page specific elements
- Home page methods

#### DashboardPage.java
- Dashboard specific elements
- Navigation methods

### Phase 6: Test Classes

#### LoginTest.java
- testValidLogin()
- testInvalidLogin()
- testEmptyCredentials()

#### HomeTest.java
- testHomePageDisplay()
- testNavigationElements()

#### DashboardTest.java
- testDashboardDisplay()
- testUserActions()

### Phase 7: Test Data & Resources

#### testdata.xlsx
- Login test data sheet
- Valid/Invalid credentials
- Empty field scenarios

#### test.properties
- Test environment settings
- Feature toggles
- Test data locations

## Implementation Steps

### Step 1: Create Base Classes
```bash
cd src/main/java/com/automation/base/
# Create: BaseTest.java
# Create: WebDriverFactory.java
# Create: ConfigReader.java
# Create: ExtentReportManager.java
```

### Step 2: Create Utility Classes
```bash
mkdir -p src/main/java/com/automation/utils/
# Create utilities listed in Phase 3
```

### Step 3: Create Listener Classes
```bash
mkdir -p src/main/java/com/automation/listeners/
# Create TestListener.java
# Create RetryAnalyzer.java
```

### Step 4: Create Configuration Files
```bash
mkdir -p src/main/resources/
mkdir -p src/test/resources/
# Create config.properties
# Create log4j2.properties
# Create testng.xml
```

### Step 5: Create Page Objects
```bash
mkdir -p src/main/java/com/automation/pages/
# Create page classes
```

### Step 6: Create Test Classes
```bash
mkdir -p src/test/java/com/automation/tests/
# Create test classes
```

## Technology Stack
- Java 11+
- Selenium WebDriver 4.15.0
- TestNG 7.8.1
- Maven 3.8+
- ExtentReports 5.0.9
- Log4j2 2.20.0
- WebDriverManager 5.6.2
- Apache POI 5.2.3

## Key Implementation Notes

1. **POM Configuration**: Use Page Object Model for maintainability
2. **Data-Driven Testing**: Parameterize tests using TestNG and Excel
3. **Reporting**: Use ExtentReports with screenshots on failure
4. **Logging**: Implement comprehensive logging with Log4j2
5. **Error Handling**: Use proper exception handling and retry mechanisms
6. **Waits**: Use explicit waits with expected conditions
7. **Parallel Execution**: Configure testng.xml for parallel runs

## Next Steps

1. Complete implementation of all base classes
2. Add utility classes for common operations
3. Implement TestNG listeners for test tracking
4. Create page object classes for target application
5. Write comprehensive test cases
6. Create test data Excel file
7. Configure TestNG XML for test execution
8. Run mvn clean test to execute suite
9. Review ExtentReport in test-reports/ folder

## Troubleshooting

- If WebDriver not found: Check internet (WebDriverManager downloads)
- If tests timeout: Increase timeouts in config.properties
- If report not generated: Check logs/ directory for errors
- If elements not found: Verify locators in page classes

## Support Resources
- Selenium Docs: https://www.selenium.dev/
- TestNG Docs: https://testng.org/
- ExtentReports: https://www.extentreports.com/
- Maven: https://maven.apache.org/

---

**Status**: Framework structure ready - Implementation in progress
**Last Updated**: December 24, 2025
**Version**: 2.0
