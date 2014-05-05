Zombie Smash
============

LOCKET DEVELOPER CODE CHALLENGE

This approach uses backtraking without any constraint in order to resolve the challenge.

#### Loading test cases
The execution starts from class [App]. It loads the test case file using a [FileTestCasesReader] which implements the [TestCasesReader] interface. Every [TestCase] loaded is used to call the backtracking method "play" in [GamePlay] class.

#### Backtraking
It starts with the list of [ZombieAppearance]  and a clean [GameStatus]. The algorithm is explaind with comments in the class [GamePlay]

### Hands on

#### Build project
```sh
mvn package
```

#### Run tests
```sh
mvn test
```

#### Run game
You need to build the project before run it
```sh
run.sh [input file]
```

[App]:https://github.com/sebastianperruolo/zombie-smash/blob/master/src/main/java/com/locket/challenge/game/App.java
[FileTestCasesReader]:https://github.com/sebastianperruolo/zombie-smash/blob/master/src/main/java/com/locket/challenge/game/utils/FileTestCasesReader.java
[TestCasesReader]:https://github.com/sebastianperruolo/zombie-smash/blob/master/src/main/java/com/locket/challenge/game/utils/TestCasesReader.java
[TestCase]:https://github.com/sebastianperruolo/zombie-smash/blob/master/src/main/java/com/locket/challenge/game/data/TestCase.java
[GamePlay]:https://github.com/sebastianperruolo/zombie-smash/blob/master/src/main/java/com/locket/challenge/game/play/GamePlay.java
[ZombieAppearance]:https://github.com/sebastianperruolo/zombie-smash/blob/master/src/main/java/com/locket/challenge/game/data/ZombieAppearance.java
[GameStatus]:https://github.com/sebastianperruolo/zombie-smash/blob/master/src/main/java/com/locket/challenge/game/play/GameStatus.java
