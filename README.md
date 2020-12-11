# F2020_Java_Final

Exercise 1: [100 marks]

Write a GUI application in Java that allows user to select students by their city.
GUI, you can design using Scene Builder.
The user should be able to enter the city. The application should retrieve the student information from an
Oracle table named Student. ( Or you can use MySql RDBMS which is open source)

Here is the definition of the table:

CREATE TABLE Student (
 studentID char(9) NOT NULL,
 firstName varchar (20) NOT NULL,
 lastName varchar (20) NOT NULL,
 address varchar (30) NOT NULL,
 city varchar(30) NOT NULL,
 province char(2) NOT NULL,
 postalCode char(6) NOT NULL,
 PRIMARY KEY (studentID)
);

Populate the table with at least 10 rows having different city names such as Toronto, Brampton, Montreal etc.
as below:

insert into Students values ('300111222','Sam', 'Malone', '10 Somewhere Road', 'Toronto','ON','M1Y2H2');
commit;

The information should be displayed in a JTextArea (or TextArea control of SceneBuilder) component which
has scrolling abilities. Use “\t” and “\n” to format the display.
Use the most appropriate layout manager classes to implement the layout of this GUI.
