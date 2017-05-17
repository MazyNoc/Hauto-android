package nu.annat.autohome.api;

public class Scene extends Unit {

    public static class Command extends Unit.Command{}

    public Command createCommand() {
        return new Command();
    }
}
