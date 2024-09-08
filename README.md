# Java Example Test

## Objective

Building a system for managing settings of any kind.

## Knowledge to demonstrate

- Work knowledge of the MVC pattern
- Sufficient knowledge of JavaFX
- Sufficient knowledge of JDBC

## Test information

Length: 4h
Subject: POSEOO – Java

## Task 1 – MVC

### Classes

Add and all necessary file for the MVC pattern, including a model for a setting, a model for a setting property, the
`AppRepository`, the `ViewId` enum to differentiate between views, and an FXML file for a property edit view. You do not
have to implement these classes yet.

### Access

Make it so the `AppController`, the `AppView`, and the `AppRepository` can only be accessed through one instance. Write
the name of that pattern in a comment in the Application class. Then, implement the missing controller method.

### Model

The idea of the app is that settings have properties. These properties could e.g. be a brightness level, or the
language of the program. We simply say that a property has a name and a value. That means, you have to
implement the following models:

Use simple properties wherever you can. The following list uses normal types, change those accordingly.

#### Setting

- `String name`
- `boolean isEditable` (Some settings should not be editable.)
- `List<Property>` properties

Fix error in AppVCtl!

#### Property

- `String name`
- `String value`
- `toString()`

### Repository

The settings are stored in a list, the properties are a list in a setting. Both of these lists must be observable.
Implement methods for adding and removing properties to a setting. Do not use ids, use objects instead. Do not use JDBC
yet. Keep these methods unused until the bonus exercise. You still have to implement them fully in the controller and
in the repository, just not in the view.

Populate the settings list with those default settings on startup:

- `"Text Replacement"` (editable)
  - "sgduh" ... "Sehr geehrte Damen und Herren!"
  - "sgf" ... "Sehr geehrte Frau "
  - "sgh" ... "Sehr geehrter Herr " 

- `"Language and Region"` (editable)
  - "Country" ... "AUSTRIA"
  - "County" ... "UPPER AUSTRIA"
  - "Language" ... "English (US)"
  - "Currency" ... "€"

- `"Account Info"` (NOT editable)
  - "Email" ... "john.doe@example.com"
  - "Age" ... "19"
 
- `"Styles"` (editable)
  - "Theme" ... "Light"

(Please do also explain in the `AppRepository` whether or not you prefer to name the package "model" or "domain" and 
why.)

### View

Implement the view correctly. You will need to bind some FXML components using the @FXML annotation.
Implement a `ViewId` enum that discriminates the views and specifies their sizes, titles, and FXML file names.
Implement a view for editing a property. MAKE SURE TO NOT ONLY INCLUDE INPUTS, BUT ALSO LABELS.

## Task 2 – Error handling 

In the view and in the model, add some custom exceptions (make a folder for exceptions in both) and catch all 
exceptions you can in the controller. Create a `handleException` method in the controller that opens an alert dialog
in the view. If an exception is thrown in the view, make sure to still run the controller method.

## Task 3 – JDBC

Bind the repository to JDBC. Make sure to NOT let the SQL exceptions leak to the controller. Make sure to add an SQL
file that is used to initialize the database if it has not been created yet. In that SQL file, make sure to add all the
default settings from point `"Repositories"` above.

## Bonus

- Allow the user to add properties and only to delete the ones they have added themselves.

## Notes

- Do not through random ids around, use POJOs instead.
- If you do not understand the assignment for any reason, please consult the teacher.
