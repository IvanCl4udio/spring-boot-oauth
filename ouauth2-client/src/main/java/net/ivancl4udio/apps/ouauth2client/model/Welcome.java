package net.ivancl4udio.apps.ouauth2client.model;

public class Welcome {
    private static final String GREETINGS_FORMAT = new String("Welcome %s!");

    public String greetings;


    public Welcome(){
        // This method is necessary for run tests.
        // For deserialisation purposes Welcome must have a zero-arg constructor.
    }

    public Welcome(String who) {
        this.greetings = String.format(GREETINGS_FORMAT, who);
    }
}
