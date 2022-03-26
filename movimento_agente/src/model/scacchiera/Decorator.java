package model.scacchiera;

public abstract class Decorator extends Casella{
    protected Casella casella;

    @Override
    public abstract String getInfo();

}
