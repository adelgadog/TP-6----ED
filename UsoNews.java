public class UsoNews {
  public static void main (String[] args) {
    NewsInterface n = new NewsImpleDB("jdbc:sqlite:news.db");    
    for(New new1 : n.findAll()) {
       System.out.println(new1.getTitle() + "\n    ****    " + new1.getDescription());
    }
  }
}

