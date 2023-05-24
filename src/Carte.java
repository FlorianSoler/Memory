package idee_projet;

/**
 * Carte
 */
public class Carte {

    private Image recto;
    private int id;

    public int getId() {
        return id;
    }
    public Image getRecto() {
        return recto;
    }
    public Image getVerso() {
        return verso;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setRecto(Image recto) {
        this.recto = recto;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Carte) {
			return ((Carte)o).getId() == this.getId();
		} else {
			return false;
		}
    }

    public Carte(Image recto, int id){
        this.setId(id);
        this.setRecto(recto);
    }
}