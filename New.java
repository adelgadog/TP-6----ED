public class New {
	private String title;
	private String slug;
	private String description;
	public New() {
        }
	public New(String title, String slug, String description) {
		this.title = title;
		this.slug = slug;
		this.description = description;
        }
	public void setTitle(String t) {
		this.title = t;
        }
	public void setSlug(String s) {
		this.slug = s;
        }
	public void setDescription(String d) {
		this.description = d;
        }
	public String getSlug() {
		return slug;
        }
	public String getDescription() {
		return description;
        }
	public String getTitle() {
		return title;
        }
}
