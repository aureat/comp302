### Game

- domain.model => Game & objects
- domain.controller => Game <--> UI

- domain.controller.app.App: main

Game = null

newGame() => new Game();
Game.players = new ArrayList<Player>()
Game.players.add(new Player() // AI)

addPlayer() => Game.players.add(new Player())

continue() => 