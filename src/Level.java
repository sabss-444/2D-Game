package game;

import city.cs.engine.*;

public abstract class Level extends World {

    private Hero player;
    protected Game game;

    public Level(Game game) {
        super();
        this.game = game;
        player = new Hero(this);
        initialise();
    }

    protected Level() {
    }

    protected abstract void initialise();

    public Hero getPlayer() {
        return player;
    }
}
