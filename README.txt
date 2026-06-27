# Apache Maven

Apache Maven is a powerful **build automation** and **project management** tool primarily used for Java applications. It simplifies project development by managing dependencies, compiling source code, running tests, packaging applications, and generating project documentation using a single configuration file called the **Project Object Model (POM)** (`pom.xml`).

---

## 🚀 Features

* Build automation for Java projects
* Dependency management using Maven Central Repository
* Standardized project structure
* Plugin-based architecture
* Test execution and reporting
* Automatic project packaging (JAR/WAR)
* Project documentation generation
* Multi-module project support

---

## 📁 Project Structure

```text
project-name/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       └── resources/
├── target/
├── pom.xml
└── README.md
```

---

## 📋 Prerequisites

Before using Maven, ensure you have:

* Java Development Kit (JDK 8 or later)
* Apache Maven installed
* Environment variables configured:

  * `JAVA_HOME`
  * `MAVEN_HOME`
  * `PATH`

---

## ⚙️ Installation

1. Download Apache Maven.
2. Extract the downloaded archive.
3. Set the `MAVEN_HOME` environment variable.
4. Add the Maven `bin` directory to your system `PATH`.
5. Verify the installation:

```bash
mvn -version
```

---

## 📦 Common Maven Commands

| Command               | Description                                    |
| --------------------- | ---------------------------------------------- |
| `mvn compile`         | Compiles the project source code               |
| `mvn test`            | Runs unit tests                                |
| `mvn package`         | Packages the application into a JAR or WAR     |
| `mvn install`         | Installs the package into the local repository |
| `mvn clean`           | Deletes the `target` directory                 |
| `mvn validate`        | Validates the project structure                |
| `mvn dependency:tree` | Displays project dependencies                  |
| `mvn site`            | Generates project documentation                |

---

## 📄 POM File

The `pom.xml` file is the heart of every Maven project. It contains:

* Project information
* Dependencies
* Plugins
* Build configuration
* Packaging type
* Repository information
* Profiles

Example:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>demo-project</artifactId>
    <version>1.0.0</version>

    <dependencies>
        <!-- Project dependencies -->
    </dependencies>
</project>
```

---

## 📚 Maven Lifecycle

### Clean Lifecycle

* `clean`

### Default Lifecycle

* `validate`
* `compile`
* `test`
* `package`
* `verify`
* `install`
* `deploy`

### Site Lifecycle

* `site`
* `site-deploy`

---

## 📂 Dependency Management

Maven automatically downloads project dependencies from the Maven Central Repository and stores them in the local repository.

Local Repository:

```text
~/.m2/repository
```

---

## 🌟 Advantages

* Easy dependency management
* Standard project layout
* Automatic build process
* Plugin support
* Cross-platform compatibility
* Faster project setup
* Easy integration with IDEs
* Supports Continuous Integration (CI)

---

## 🛠 Technologies

* Java
* Apache Maven
* XML
* Maven Central Repository

---

## 📖 Documentation

For complete documentation, installation guides, plugins, and tutorials, visit the official Apache Maven website.

---

## 📜 License

Apache License 2.0

---

## 👨‍💻 Author

Developed using **Apache Maven**, the industry-standard build and dependency management tool for Java applications.
