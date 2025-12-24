# DemoFrameWork_Java_Selenim

## Selenium Test Automation Framework - Professional Edition

**Status**: ✅ Production Ready  
**Framework Version**: 2.0  
**Last Updated**: December 24, 2025  
**Java Version**: 11+  
**Framework Type**: Hybrid (Page Object Model + Data-Driven)  

---

## 📋 Overview

A comprehensive **Selenium Java Test Automation Framework** built with industry best practices for:
- **Robust web application testing**
- **Data-driven test execution**
- **Advanced reporting and logging**
- **Easy maintenance and scalability**
- **Professional HTML reports**

---

## 🎯 Key Features

### 1. **Page Object Model (POM)**
- Encapsulated page objects for maintainability
- Centralized element locators
- Reusable page methods
- Easy test script updates

### 2. **Data-Driven Testing**
- External test data management
- Multiple data source support
- Parameterized test execution
- Excel and JSON data handling

### 3. **Advanced Reporting**
- ExtentReports integration
- Professional HTML reports
- Screenshot on failure
- Test execution timeline
- System information capture

### 4. **Robust Framework**
- Multiple wait strategies
- Explicit and implicit waits
- Test retry mechanism
- Error handling and recovery
- Comprehensive logging

### 5. **Cross-Browser Testing**
- Chrome support
- Firefox support
- Edge support
- Safari support
- Mobile browser capability

### 6. **Test Management**
- TestNG framework integration
- Test listeners for event tracking
- Test grouping and categorization
- Parallel execution support
- Test dependencies management

---

## 🛠️ Technology Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 11+ | Programming Language |
| Selenium | 4.15.0 | Web Browser Automation |
| TestNG | 7.8.1 | Test Framework |
| Maven | 3.8+ | Build & Dependency Management |
| ExtentReports | 5.1.1 | Advanced Test Reporting |
| Log4j2 | 2.20.0 | Logging Framework |
| Apache POI | 5.2.3 | Excel Data Management |
| WebDriverManager | 5.6.3 | Automatic Driver Management |
| Gson | 2.10.1 | JSON Parsing |

---

## 📁 Project Structure

```
DemoFrameWork_Java_Selenim/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/automation/
│   │   │       ├── base/
│   │   │       │   ├── BasePage.java              # Base page class
│   │   │       │   ├── BaseTest.java              # Base test setup
│   │   │       │   ├── WebDriverFactory.java      # Driver management
│   │   │       │   ├── ConfigReader.java          # Configuration reader
│   │   │       │   └── ExtentReportManager.java   # Report management
│   │   │       ├── pages/
│   │   │       │   ├── LoginPage.java             # Login page object
│   │   │       │   ├── HomePage.java              # Home page object
│   │   │       │   ├── DashboardPage.java         # Dashboard page object
│   │   │       │   └── [Additional Page Objects]
│   │   │       ├── utils/
│   │   │       │   ├── WebDriverUtils.java        # Driver utilities
│   │   │       │   ├── DataProvider.java          # Test data provider
│   │   │       │   ├── FileUtils.java             # File operations
│   │   │       │   └── ReportUtils.java           # Report utilities
│   │   │       └── listeners/
│   │   │           ├── TestListener.java          # TestNG listeners
│   │   │           └── RetryAnalyzer.java         # Retry logic
│   │   │
│   │   └── resources/
│   │       ├── config.properties                  # Configuration file
│   │       ├── log4j2.properties                  # Logging config
│   │       └── testng.xml                         # TestNG suite
│   │
│   └── test/
│       ├── java/
│       │   └── com/automation/tests/
│       │       ├── LoginTest.java                 # Login tests
│       │       ├── HomeTest.java                  # Home tests
│       │       └── [Additional Test Classes]
│       │
│       └── resources/
│           ├── testdata.xlsx                      # Test data Excel
│           └── test.properties                    # Test config
│
├── target/                                        # Build output
├── test-reports/                                  # Test reports
├── pom.xml                                        # Maven configuration
├── .gitignore                                     # Git ignore file
└── README.md                                      # This file
```

---

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.8 or higher
- Git
- Chrome/Firefox/Edge browser installed

### Installation

#### Step 1: Clone Repository
```bash
git clone https://github.com/somnathsarak/DemoFrameWork_Java_Selenim.git
cd DemoFrameWork_Java_Selenim
```

#### Step 2: Install Dependencies
```bash
mvn clean install
```

#### Step 3: Configure Environment
Edit `src/main/resources/config.properties`:
```properties
# Application URL
baseURL=https://your-application-url.com

# Browser Configuration
browser=chrome

# Timeouts (in seconds)
implicit_wait=10
explicit_wait=15
page_load_timeout=30

# Test Data
test_data_path=src/test/resources/testdata.xlsx

# Logging
log_level=INFO
```

#### Step 4: Configure Test Data
Update `src/test/resources/testdata.xlsx` with your test data

---

## ▶️ Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn test -Dtest=LoginTest
```

### Run Specific Test Method
```bash
mvn test -Dtest=LoginTest#testValidLogin
```

### Run with Custom Browser
```bash
mvn test -Dbrowser=firefox
```

### Run Tests in Parallel
```bash
mvn test -Dparallel=methods -DthreadCount=4
```

---

## 📊 Test Reports

### ExtentReport
**Location**: `test-reports/ExtentReport_*.html`

**Contains**:
- Test summary (Passed, Failed, Skipped)
- Detailed execution logs
- Screenshots on failure
- System information
- Execution timeline

### Open Report
```bash
# Linux/Mac
open test-reports/ExtentReport_*.html

# Windows
start test-reports/ExtentReport_*.html
```

---

## 🏗️ Framework Architecture

### BasePage Class
Provides common page object methods:
```java
public void click(By locator)
public void sendKeys(By locator, String text)
public String getText(By locator)
public boolean isElementPresent(By locator)
public void selectDropdown(By locator, String value)
```

### BaseTest Class
Handles test setup and teardown:
```java
@BeforeMethod
public void setUp()          // Initialize WebDriver

@AfterMethod
public void tearDown()       // Close browser and generate report
```

### WebDriverFactory
Manages WebDriver instances:
```java
public static WebDriver getDriver(String browser)
public static void quitDriver()
```

### ConfigReader
Reads configuration properties:
```java
public static String getProperty(String key)
public static int getTimeout()
```

---

## 📈 Best Practices Implemented

✅ **Single Responsibility Principle**
- Each class has one responsibility
- Separation of concerns

✅ **DRY (Don't Repeat Yourself)**
- Reusable methods in base classes
- Centralized configurations

✅ **Maintainability**
- Clear naming conventions
- Well-documented code
- Easy to update locators

✅ **Scalability**
- Modular design
- Easy to add new test cases
- Page object extensibility

✅ **Robustness**
- Explicit waits
- Error handling
- Retry mechanism

✅ **Reporting**
- Professional HTML reports
- Screenshot captures
- Detailed logs

---

## 🔧 Configuration Options

### Browser Options
```properties
browser=chrome          # Chrome browser
browser=firefox         # Firefox browser
browser=edge           # Microsoft Edge
```

### Headless Mode
```properties
headless=true          # Run in headless mode
headless=false         # Run with GUI
```

### Screenshot Options
```properties
screenshot_on_failure=true   # Capture on failure
screenshot_on_pass=false     # Capture on pass
```

---

## 📚 Writing Tests

### Example Test Case
```java
public class LoginTest extends BaseTest {
    
    private LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }
    
    @Test
    public void testValidLogin() {
        loginPage.login("username", "password");
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
}
```

---

## 🐛 Troubleshooting

### WebDriver Not Found
**Solution**: WebDriverManager auto-downloads drivers. Ensure internet connection.

### Tests Timeout
**Solution**: Increase timeouts in config.properties

### Report Not Generated
**Solution**: Check write permissions in test-reports directory

### Element Not Found
**Solution**: Verify element locators and wait for element presence

---

## 📞 Support & Documentation

- **Selenium Documentation**: https://www.selenium.dev/
- **TestNG Documentation**: https://testng.org/
- **ExtentReports**: https://www.extentreports.com/
- **Maven Documentation**: https://maven.apache.org/

---

## 📝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

---

## 📄 License

MIT License - feel free to use and modify

---

## 👨‍💻 Author

**Somnath Sarak**
- GitHub: [@somnathsarak](https://github.com/somnathsarak)
- LinkedIn: [Somnath Sarak Profile](https://www.linkedin.com/in/saraksomanath/)

---

## 🎓 Latest Updates (v2.0)

✅ Updated to Selenium 4.15.0
✅ Enhanced ExtentReports integration
✅ Improved logging with Log4j2
✅ Added data-driven testing capabilities
✅ Implemented TestNG listeners
✅ Added retry mechanism for flaky tests
✅ Cross-browser testing support
✅ Professional documentation
✅ Best practices implementation
✅ Production-ready framework

---

## 📋 Checklist for New Users

- [ ] Clone the repository
- [ ] Install Java 11+
- [ ] Install Maven 3.8+
- [ ] Run `mvn clean install`
- [ ] Update config.properties
- [ ] Prepare test data
- [ ] Write test cases
- [ ] Execute tests with `mvn test`
- [ ] View ExtentReport
- [ ] Customize as needed

---

**Framework Status**: ✅ **Production Ready**  
**Version**: 2.0  
**Last Updated**: December 24, 2025  
**Maintained By**: Somnath Sarak  

⭐ If you find this framework useful, please star the repository!
