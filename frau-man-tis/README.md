# Probetest 2 – Frau Man Tis

## Objective

Mantis is too old so we need a new version. After much consideration, the maintainers landed on the name Frau Man Tis
(in support of the Global Feminist Movement). Your mission will be to create a working prototype. You will, thus, manage
users and their tasks. A user only has a username, a task only stores whether it has been done, its description, when
it has been added and when it is due.

## Information

- Time: 2h
- Subject: POSEOO – Java

## Notes

- Ask teacher if you have any questions.
- Do not forget to do proper exception handling throughout the application. Errors should be handled mainly from the
  controller.
- The `FmtUser` class should not be touched. It also does not need to use JavaFX's simple properties. The corresponding
  `FmtUsersRepository` should also not be touched.
- The most important part of the exam is task 5 (JDBC) as it accounts for 65 % of your test grade.

## Task 1 – MVC

Because all you get is the model, you will have to build the MVC/MVVM structure yourself. Follow best practises. In the
application class, do provide a reason for why the terms "model" or "domain" might be preferred for some people. What
do you prefer and why?

## Task 2 – XML

Finish the XML code and implement the `TableView` fully in the FXML file and in the `AppVCtl`.

## Task 3 – Exception handling

Implement proper error handling in the controller (use a helper method and show an alert on exceptions). When needed, do
throw custom exceptions too. Do NOT use ANY `RunTimeException`s. No exceptions should leak anywhere.

## Task 4 – Finish the entire view code

Use your best judgement.

## Task 5 – JDBC

Add an H2 database connection. Use the following libraries:

- com.h2database:h2:2.3.232
- com.oracle.ojdbc:ojdbc10:19.3.0.0

Do not let any JDBC code, including but not limited to `SqlException`s leak out of the model.
Do create a table for the users. Every user can have many tasks. This means that you have two tables and a 1:n relation.
Add an SQL script that is loaded if the database does not yet exist. It should create the tables and add the default
users. Do NOT add default tasks.

## Task 6 – Finishing touches

Make shore all the separate parts work and that all resources are being closed. Any unclosed resource, including the
database itself, will cause point deduction. Also make sure that the program compiles.

## Task 7 – Bonus

Allow for chronological sorting of the tasks.