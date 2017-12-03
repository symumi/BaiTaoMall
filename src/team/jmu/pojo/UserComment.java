package team.jmu.pojo;

public class UserComment {
	private String username;
	private String comment;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserComment(String username, String comment) {
		super();
		this.username = username;
		this.comment = comment;
	}

	public UserComment() {
	}

}
