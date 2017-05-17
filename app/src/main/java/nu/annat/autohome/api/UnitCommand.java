package nu.annat.autohome.api;

public class UnitCommand {
    String id;
    Unit.Command data;

    public UnitCommand(String id, Unit.Command data) {
        this.id = id;
        this.data = data;
    }
}
