/*
 * @author: Francesca
 * @exercise
 */

package kafkajson.movie;

public class MovieObject {

	private String id;
	private String titolo;
	private int anno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setName(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public MovieObject(String id, String titolo, int anno) {
		this.id = id;
		this.titolo = titolo;
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "CustomObject{" + "id_videoteca ='" + id + '\'' + ", Titolo Film ='" + titolo + '\'' + ", Anno uscita ="
				+ anno + '}';
	}
}
