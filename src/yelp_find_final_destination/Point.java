package yelp_find_final_destination;

public class Point {
    public Point() {}
    public Point(String source, String destination) {
        this.source = source;
        this.destination = destination;

    }
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    private String source;
    private String destination;
}
