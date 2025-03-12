# Tic-Tac-Toe

Run the program with `$ ./TicTacToe` to get the results.

To build the project, run `$ ./gradlew :runDebugExecutableNative`.
The executables will be in `build/bin/native/debugExecutable`.

To run the tests, run `$ ./gradlew :nativeTest`.

## Description

The game currently always starts with `Player.X`. The game is played on a 3x3 board. The players
take turns to place their mark on the board. The game ends when a player has won or the board is
full.

The game is implemented in Kotlin/Native. The game logic is in `src/commonMain/kotlin/Main.kt`.

The game is tested with Kotlin tests in `src/nativeTest/kotlin/`.

## Future improvements

1. Currently the game always starts with `Player.X`. It would be nice to randomize the starting player.
2. The bots are currently very simple. It would be nice to implement a more advanced bot that can
actually play the game well instead of depending on random moves.
3. Add player input to play the game manually against a bot or another player.
4. Build scripts for CI/CD.
5. Game logic is currently not tested / testable due to time restraints unlike the Board utilities.