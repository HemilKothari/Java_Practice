package inheritance.collectionAPI.Bookstore;

public class Genre implements Comparable<Genre> {
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName.toLowerCase();
    }

    @Override
    public int compareTo(Genre o) {
        return this.genreName.compareToIgnoreCase(o.genreName);
    }
    
}
