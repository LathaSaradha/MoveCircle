Move Circle 

Project Description
-------------------------
This project is created in accordance with my Masters Course Object-Oriented Design at Northeastern Illinois University.

The project is a JavaFX application that simulates moving a ball on a grid (think of this like a little robot,see image below). 


![Test Image 1](MoveCircle_Screenshot.png)



The grid is a 25 x 25 grid where the top-left-hand corner of the grid is at (0, 0) and the bottom left hand corner is (24, 24). 
The ball is initialized to a random location in the grid, and if the user enters an invalid direction (other than U/D/L/R) or an invalid number of spaces (either an invalid value or a value that takes the ball oﬀ the grid), the ball will not move from its current location.



Instructions
----------------
1. With IntelliJ(v2019.2.3RC or higher), Clone the project.

2. Make sure that the checkbox for Automatically import this project on changes in build script files is checked and that both the Build and run using: and Run tests using: dropdowns are set to Gradle.

3. Change theUse Gradle from’gradle-wrapper.properties’ file to ’wrapper’ task in Gradle build script.

4. Make sure that the Gradle JVM is set to Java 11! 

5. Also go to File→Project Structure/Project Settings→Project and make sure that the JDK is set to Java 11. 

6. Remember that to run the project for the first time,you will need to click on the Gradle tab on the right-hand side of the project and goto homework5→Tasks→application. 

7. Right-click on run and choose $projectname [run]. 
