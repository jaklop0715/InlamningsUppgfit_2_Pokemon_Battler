### Pokémon Pokédex

#### About the project

This is a Java console application where the user can create and manage their own Pokémon Pokédex.

This project was created as a part of my Java programming course. The main focus of the project is to practice 
object-oriented programming, collection, file handling, input validation and building a program
that can handle incorrect user input without crashing. 

#### Features

- View all Pokémon in the Pokédex
- Create a new Pokémon
- Edit an existing Pokémon
- Change a Pokémon's name, HP or type
- Add or remove attacks
- Remove Pokémon
- Save the Pokédex to a file
- Load saved Pokémon from a file
- Reset the Pokédex to the original seed data
- Exit the application and save automatically

#### Pokémon

##### Each Pokémon contains:

- A Name.
- A Type.
- Maximum HP.
- Current HP.
- 1-4 attacks.

##### Each attack contains:

- A Name.
- Base damage.
- Accuracy.
- A Type.

##### The available Pokémon types are:

- Fire.
- Water.
- Grass.
- Electric.
- Normal.

#### Validation

I have added input validation throughout the application so that incorrect input does not crash the program.

Some examples:

- Names cannot be empty. 
- HP cannot be negative, empty space or any letters.
- Current HP cannot be higher than maximum HP, have any letters or empty space.
- Attack names cannot be empty.
- Base damage and accuracy must be between 1 and 100.
- A Pokémon must have between 1 and 4 attacks.
- The menu choice must be valid so between 1 and 8. 
- Numbers must be entered where numeric input is expected.

When something is entered incorrectly, the program displays an error message and lets the user try again.

#### Saving and loading

The Pokédex is saved in a text file called "pokedex.txt".

When the application starts, it checks if saved data exists. If there is saved data it is loaded. If there is no saved
data, the application creates six predefined Pokémon instead. There are also options in the menu to manually save and 
load the Pokédex. 

#### Structure 

The project contains the following classes:

Main - Handles the menu and the main flow of the application.
Pokemon - Represents a Pokémon.
Attack - Represents an attack.
Pokedex - Keeps track of all Pokémon.
Type - An enum containing the available Pokémon types.
InputHelper - Handles and validates user input.
FileHelper - Handles saving and loading the Pokédex.
Readme - 

#### How to run the program

Clone the repository and open the project in IntelliJ IDEA as a Maven project.

Run Main.java to start the application.

The program will then display the Pokédex menu in the console.

#### Example

======================== POKÉDEX ======================== 
1. View all Pokémon 
2. Create a new Pokémon 
3. Edit Pokémon 
4. Remove Pokémon 
5. Save to file 
6. Load from file 
7. Reset to seed data 
8. Exit

The application is mainly a console-based project, so all interaction is done through the menu and keyboard input.