package oopsfundamentals;

/*
Design the Color model used by a TrafficLight controller. The controller displays one colour at a time and moves through the same repeating cycle: red, green, yellow, then back to red.

The TrafficLight class is provided. Complete the missing Color enum—or the closest enum-like type in your language—so the controller has everything it needs to behave as follows:

TrafficLight(String startColor) starts on RED, GREEN, or YELLOW, matching the input without regard to case. An unrecognized value defaults to RED.
String getColor() returns the current colour's name.
int getDuration() returns the current colour's duration: RED lasts 30 seconds, GREEN lasts 25, and YELLOW lasts 5.
String next() advances once through the cycle and returns the new colour's name.
String describe() returns the current colour and duration in the exact format "<COLOR> (<duration>s)", such as "RED (30s)".
Each colour should know both how long it lasts and which colour follows it:

RED (30s) -> GREEN (25s) -> YELLOW (5s) -> RED (30s)

Read the supplied controller carefully to see the exact fields, methods, or lookup tables expected from Color in your language. Do not duplicate the cycle rules inside the controller.

*/

enum Color {
	RED(30), GREEN(25), YELLOW(5);

	private final int duration;

	Color(int duration) {
		this.duration = duration;
	}

	int duration() {
		return duration;
	}

	Color next() {
		switch (this) {
		case RED:
			return GREEN;
		case GREEN:
			return YELLOW;
		default:
			return RED;
		}
	}
}

public class TrafficLight {

	private Color current;

	public TrafficLight(String startColor) {
		Color parsed = Color.RED;
		for (Color color : Color.values()) {
			if (color.name().equalsIgnoreCase(startColor)) {
				parsed = color;
				break;
			}
		}
		this.current = parsed;
	}

	public String getColor() {
		return current.name();
	}

	public int getDuration() {
		return current.duration();
	}

	public String next() {
		current = current.next();
		return current.name();
	}

	public String describe() {
		return current.name() + " (" + current.duration() + "s)";
	}

	public static void main(String[] args) {
		
		TrafficLight tl=new TrafficLight("YELLOW");
		System.out.println(
			    tl.getColor() + ", " + 
			    tl.describe() + ", " + 
			    tl.getDuration() + ", " + 
			    tl.next() + ", " + 
			    tl.getColor() + ", " + 
			    tl.describe()
			);

	}

}
