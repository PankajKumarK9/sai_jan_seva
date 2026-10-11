# Sai Jan Kalyan Seva Sansthan

Spring Boot website for Sai Jan Kalyan Seva Sansthan computer training center.

## Requirements

- Java 21 or newer
- Maven 3.9 or newer

## Run Locally

```powershell
mvn spring-boot:run
```

Open:

```text
http://localhost:8080/
```

## Build

```powershell
mvn package
```

Run the packaged jar:

```powershell
java -jar target\sai-jan-sansthan-1.0.0.jar
```

## Project Structure

```text
src/main/java/org/saijankalyan/
  SaiJanSansthanApplication.java
  web/WebsiteController.java

src/main/resources/templates/
  index.html
  courses.html
  about.html
  gallery.html
  contact.html
  fragments.html

src/main/resources/static/
  css/site.css
  js/site.js
  assets/uploads/airo-logo-shimmer-square.svg
```

## Pages

- Home: `/`
- Courses: `/courses`
- About: `/about`
- Gallery: `/gallery`
- Contact: `/contact`
# sai_jan_seva
