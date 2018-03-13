package ru.itpark;

abstract class GameFactory {
    class Dice extends  GameFactory{}
    class HeadsOrTails extends GameFactory{}
}
