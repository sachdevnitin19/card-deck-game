# Card Deck Game

Terminal interactive card deck game implemented using Java.
List of games:-
1. Ek Patti:- In this game each player is dealt a card and the player who has maximum number card wins and if both have same number card then player having higher priority suit (SPADES>HEART>CLUB>DIAMONDS) wins the round.   

## Instructions for executing using JAR file

##### Executing JAR

First make sure JRE (Java Runtime Environment) is installed on your computer.

**Steps**:- 
1. Download "CardDeckGame.jar" file from [here](https://github.com/sachdevnitin19/card-deck-game/releases/latest)
2. Open terminal on your computer.
3. Execute command ```java -jar CardDeckGame.jar```. Make sure "CardDeckGame.jar" file has permission to execute.


## Instructions for executing program locally

Make sure **JDK 11**  is installed on your computer.
**Steps**:- 
1. clone this repository.
2. navigate to repository directory
3. run ```javac -d ./out/ -cp src/ src/com/nitin/Main.java``` command to compile code. This command creates all class files in 'out' directory.
4. run ```java -cp ./out/ com.nitin.Main``` to run the program.


## Instructions for executing building JAR File

Make sure **JDK 11** is installed on your computer.

**Steps**:- 
1. clone this repository.
2. navigate to repository directory
3. run ```javac -d ./out/ -cp src/ src/com/nitin/Main.java``` command to compile code. This command creates all class files in 'out' directory.
4. run ```jar -cvmf src/META-INF/MANIFEST.MF CardDeckGame.jar -C out/ com/``` to build JAR file.
5. Test jar file by executing command ```java -jar CardDeckGame.jar```.