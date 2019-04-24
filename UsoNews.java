public class UsoNews {
	public static void main(String[] args) {
		NewsInterface n = null;
		if (args[1].equals("sqlite")) {
			n = new NewsImpleDB("jdbc:sqlite:news.db");
		}
		if (args[1].equals("mysql")) {
			n = new NewsImpleDB("jdbc:mysql://localhost/news?user=root&password=usuario&serverTimezone=UTC");
		}
		for (New new1 : n.findAll()) {
			System.out.println(new1.getTitle() + "\n    ****    " + new1.getDescription());
		}
	}
}
