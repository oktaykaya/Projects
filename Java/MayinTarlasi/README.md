# MineSweeper Game

## Overview

This project is a simple implementation of the MineSweeper game in Java. The game allows users to create a board of specified dimensions and play a classic game of MineSweeper.

## How to Play

1. **Set Board Dimensions**: When the game starts, you will be prompted to enter the number of rows and columns for the game board.
2. **Play the Game**: The game board will be displayed, and you will be prompted to enter the coordinates (row and column) of the cell you want to uncover.
3. **Game Over**: If you uncover a cell containing a mine, the game is over.
4. **Win the Game**: If you uncover all cells that do not contain mines, you win the game.

## Classes

### Main

The `Main` class is the entry point of the program. It initializes a `MineSweeper` object and starts the game.

```java
public class Main {
    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper(0, 0, 0, 0);
        mineSweeper.Game();
    }
}


lütfen oyun tahtanızın boyutlarını belirleyiniz
satır sayısı : 3
sütun sayısı : 3
Oyun Tahtası
- - - 
- - - 
- - - 
Mayınlı Harita
* - - 
- * - 
- - - 
satır: 1
sütun : 1
Oyun Tahtası
1 - - 
- - - 
- - - 
