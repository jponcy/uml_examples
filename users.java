import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Utilisateur {
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}


class Article {
    private final String reference;
    private float prix;
    private Utilisateur auteur;
    private List<DocumentArticle> documents = new ArrayList<>();

    public Article(final String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public List<DocumentArticle> getDocuments() {
        return documents;
    }

    public void addDocument(DocumentArticle doc) {
        this.documents.add(doc);

        // if (!doc.getArticle().equals(this)) {
        if (doc.getArticle() != this) {
            doc.setArticle(this);
        }
    }

    public void removeDocument(DocumentArticle doc) {
        this.documents.remove(doc);

        if (doc.getArticle().equals(this)) {
            doc.setArticle(null);
        }
    }
}

class DocumentArticle {
    private String nom;

    /** Chemin vers le fichier physique. */
    private String chemin;

    private Article article;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;

        if (article != null && !article.getDocuments().contains(this)) {
            article.addDocument(this);
        }
    }
}



class Application {
    public static void main(String[] args) {
        Article a = new Article("bx4000");

        a.setPrix(42f);


        DocumentArticle doc = new DocumentArticle();

        doc.setNom("image du produit");
        doc.setChemin("C:/Utilisateurs/Toto/Images/bx4000.png");


        doc.setArticle(a);

        System.out.println("Mon article possède " + a.getDocuments().size() + " documents");
        // Affichage en console de :
        // Mon article possède 0 documents

        a.addDocument(doc);
    }
}
