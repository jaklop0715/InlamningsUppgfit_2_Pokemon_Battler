### Pokémon Pokédex

#### About the project

This is a Java console application where the user can create and manage their own Pokémon Pokédex
and battle against a wild Pokémon controlled by the computer.

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
- Start a battle against a wild Pokémon
- View battle results (wins and losses)
- Exit the application and save automatically

#### Pokémon

##### Each Pokémon contains:

- A Name.
- A Type.
- Maximum HP.
- Current HP.
- Speed.
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

#### Battle

The battle is a turn based fight between the player's Pokémon and a wild Pokémon.

1. The player chooses one of the Pokémon in the Pokédex.
2. A random wild Pokémon appears. There are three different wild Pokémon, and a new one is created every 
time so it always starts with full HP.
3. The Pokémon with the highest speed attacks first. If the speed is the same, the player goes first.
4. The player chooses an attack by entering its number. The computer chooses a random attack.
5. The battle continues until one of the Pokémon has 0 HP.
6. After the battle the player's Pokémon gets its full HP back, so it can battle again.

##### Hit chance

A random number between 1 and 100 is drawn. The attack hits if the number is less than or equal to the
accuracy of the attack. An attack with accuracy 100 always hits.

##### Damage formula

damage = base damage * percent / 100

The percent is a random number between 85 and 100. Example: an attack with base damage 50 and a
random percent of 90 gives 50 * 90 / 100 = 45 damage. The HP of a Pokémon can never go below 0.

##### Battle results

The program keeps track of the number of wins and losses. They can be viewed from the menu.
The results are only saved while the program is running.

#### Validation

I have added input validation throughout the application so that incorrect input does not crash the program.

Some examples:

- Names cannot be empty.
- HP cannot be negative, empty space or any letters.
- Current HP cannot be higher than maximum HP, have any letters or empty space.
- Speed must be between 1 and 100.
- Attack names cannot be empty.
- Base damage and accuracy must be between 1 and 100.
- A Pokémon must have between 1 and 4 attacks.
- The menu choice must be valid so between 1 and 10.
- The attack choice in a battle must be one of the attacks the Pokémon has.
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
Battle - Contains the battle logic: turn order, hit chance, damage and the battle loop.
BattleStatus - Keeps track of the number of wins and losses.
InputHelper - Handles and validates user input.
FileHelper - Handles saving and loading the Pokédex.
SeedData - Creates the predefined Pokémon and the wild Pokémon.
Readme - Describes the project.

I put the battle logic in its own class, Battle, so that Main only handles the menu and Pokemon only holds
the data of a Pokémon. That way each class has one job.

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
8. Start battle
9. View battle results
10. Exit

The application is mainly a console-based project, so all interaction is done through the menu and keyboard input.
