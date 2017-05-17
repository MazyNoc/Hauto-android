package nu.annat.autohome.api;

public class DimmerUnit extends Unit {

    public float value;

    public static class Command extends SwitchUnit.Command {
        Float value;

        public Command(String state, Float value) {
            super(state);
            this.value = value;
        }
    }
}
