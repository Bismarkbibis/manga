package manga.Http;

public class LoginEntrant {

	private String email;
	
	private String passeword;

	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPasseword() {
		return passeword;
	}



	public void setPasseword(String passeword) {
		this.passeword = passeword;
	}



	@Override
	public String toString() {
		return "LoginEntrant [idenfiant=" + email + ", passeword=" + passeword + "]";
	}
}
