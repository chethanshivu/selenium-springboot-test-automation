# SpringBoot Selenium Test Automation Framework

## Tech Stack
- Java (JDK 17+)
- SpringBoot 3.x
- Selenium WebDriver 4.x
- Cucumber 7.x
- JUnit 5
- Maven
- Jenkins Pipeline Integration
- Cross-browser Support (Chrome, Firefox, Edge)

## Project Architecture
```
src/
├── main/
│   ├── java/
│   │   └── com/framework/
│   │       ├── config/              # Spring configurations
│   │       ├── constants/           # Framework constants
│   │       ├── driver/              # WebDriver management
│   │       ├── pages/               # Page Object classes
│   │       ├── utils/               # Utility classes
│   │       └── Application.java     # Spring Boot main class
│   └── resources/
│       ├── application.properties   # Framework properties
│       └── webdriver/              # WebDriver binaries
├── test/
│   ├── java/
│   │   └── com/framework/
│   │       ├── steps/              # Cucumber step definitions
│   │       ├── runners/            # Cucumber test runners
│   │       └── hooks/             # Cucumber hooks
│   └── resources/
│       ├── features/              # Cucumber feature files
│       └── test-config.properties # Test configuration
```

## Key Features
1. Spring Boot Integration for dependency injection
2. Parallel test execution support
3. Cross-browser testing (Chrome, Firefox, Edge)
4. Page Object Model implementation
5. Cucumber BDD framework
6. Jenkins Pipeline integration
7. Detailed HTML reports
8. Screenshot capture on failure
9. Reusable utility functions

## Prerequisites
- JDK 17 or higher
- Maven 3.8+
- IDE (IntelliJ IDEA recommended)
- Jenkins (for CI/CD)

## Setup and Configuration

### 1. Clone and Build
```bash
git clone <repository-url>
cd springboot-selenium-framework
mvn clean install
```

### 2. Framework Configuration
Configure `application.properties`:
```properties
# Browser Configuration
browser.type=chrome
browser.headless=false

# Application URLs
base.url=https://your-application-url.com

# Timeouts
default.timeout=30
implicit.wait=10

# Screenshot Path
screenshot.path=target/screenshots/
```

### 3. WebDriver Configuration
The framework uses WebDriverManager for browser driver management:

```java
@Configuration
public class WebDriverConfig {
    @Bean
    public WebDriver webDriver() {
        return WebDriverFactory.createDriver(
            System.getProperty("browser", "chrome")
        );
    }
}
```

## Writing Tests

### 1. Feature Files
Create feature files in `src/test/resources/features`:

```gherkin
Feature: User Authentication

  @smoke
  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters username "test@example.com"
    And user enters password "Test@123"
    And user clicks login button
    Then user should be logged in successfully
```

### 2. Step Definitions
Create step definitions in `src/test/java/steps`:

```java
@SpringBootTest
public class LoginSteps {
    @Autowired
    private LoginPage loginPage;
    
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage.navigateToLoginPage();
    }
    
    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }
}
```

### 3. Page Objects
Create page objects in `src/main/java/pages`:

```java
@Component
public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
}
```

## Running Tests

### Local Execution
```bash
# Run all tests
mvn test

# Run specific feature
mvn test -Dcucumber.features="src/test/resources/features/login.feature"

# Run with specific browser
mvn test -Dbrowser=firefox

# Run specific tags
mvn test -Dcucumber.filter.tags="@smoke"
```

### Jenkins Pipeline
```groovy
pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git 'repository-url'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test -Dbrowser=${BROWSER} -Dcucumber.filter.tags=${TAGS}'
            }
        }
        
        stage('Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'overview-features.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }
}
```

## Test Reports
Reports are generated in `target/cucumber-reports` directory:
- Cucumber HTML Reports
- JUnit XML Reports
- Extent Reports (optional)

## Cross Browser Testing
Supported browsers:
- Chrome (default)
- Firefox
- Edge

Configure in `application.properties` or pass as system property:
```bash
mvn test -Dbrowser=firefox
```

## Utilities and Helpers

### Screenshot Capture
```java
@Aspect
@Component
public class ScreenshotAspect {
    @AfterThrowing(pointcut = "execution(* com.framework.steps.*.*(..))")
    public void captureScreenshotOnFailure(JoinPoint joinPoint) {
        // Screenshot capture logic
    }
}
```

### Common WebDriver Operations
```java
public class WebDriverUtils {
    public static void waitForElementVisible(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
```

## Best Practices

1. **Test Data Management**
   - Use external data files (JSON/Excel)
   - Implement data providers
   - Avoid hardcoding test data

2. **Page Objects**
   - Follow single responsibility principle
   - Use meaningful names for methods
   - Implement proper waits

3. **Framework Structure**
   - Maintain clear separation of concerns
   - Use Spring profiles for different environments
   - Implement proper logging

## Troubleshooting

Common issues and solutions:

1. **WebDriver Initialization Failures**
   - Update WebDriver binaries
   - Check browser compatibility
   - Verify system properties

2. **Element Interaction Issues**
   - Implement explicit waits
   - Check element locators
   - Verify page load status

## Contributing
1. Fork the repository
2. Create a feature branch
3. Submit pull request with proper description

## License
MIT License
