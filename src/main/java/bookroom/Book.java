package bookroom;

public class Book implements Comparable<Book>
{
    private String name, author;
    private String genre; //enum for genre?
    private String cover; //enum for cover?
    private String publishDate; //should see about converting this to some kind of date object if java has that
    private double price;
    //Honestly, this is bad code because the book shouldn't care about how it's
    //sorted, but there's no other way I can think of at the moment to allow easy sorting.
    private Criteria criteria; 
    
    public Book(String name, String author, String genre, String cover, String publishDate, double price, Criteria criteria)
    {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.cover = cover;
        this.publishDate = publishDate;
        this.price = price;
        this.criteria = criteria;
    }
    
    //Do I even need this base case?
    /*public Book()
    {
        this.name = "";
        this.author = "";
        this.genre = "";
        this.cover = "";
        this.publishDate = "";
        this.price = 0.0;
    }*/
    
    public String getName()
    {
        return name;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public String getCover()
    {
        return cover;
    }
    
    public String getPublishDate()
    {
        return publishDate;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(float price)
    {
        this.price = price;
    }
    
    public Criteria getCriteria()
    {
        return criteria;
    }
    
    public void setCriteria(Criteria criteria)
    {
        this.criteria = criteria;
    }

    //I'm flying completely blind on this, but we'll see how it works
    //We'll work with sorting by name at the moment, and maybe go from there
    
    public int compareTo(Book o)
    {
        switch(criteria)
        {
            case NAME:
                return getName().compareTo(o.getName());
            case AUTHOR:
                return getAuthor().compareTo(o.getAuthor());
            case COVER:
                return getCover().compareTo(o.getCover());
            case GENRE:
                return getGenre().compareTo(o.getGenre());
            case PRICE:
                return (getPrice() > o.getPrice()) ? (1) : (-1);
            case PUBLISHDATE:
                //I think this won't work properly yet, need to look into proper dating next
                return getPublishDate().compareTo(o.getPublishDate());
            default:
                return 0;
                
        }
    }
}
