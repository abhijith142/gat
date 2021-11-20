public class Publisher {
    private String id;
    private String publisherName;

    public Publisher() {
    }

    public Publisher(String id, String name) {
        this.id = id;
        this.publisherName = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id='" + id + '\'' +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }
}
