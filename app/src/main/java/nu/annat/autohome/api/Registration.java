package nu.annat.autohome.api;

public class Registration {
    public String id;
    public String kind = "FCM";

    public Registration(String id) {
        this.id = id;
    }
}
