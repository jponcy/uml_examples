import java.util.List;

class Utilisateur {
    /** Commentaires écrit par l'utilisateur. */
    // @OneToMany(mappedBy="auteur")
    private List<Commentaire> commentaires;

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}

class Publication {
    // @OneToMany(mappedBy="publication")
    private List<Commentaire> commentaires;

    /** "Destructeur" / méthode appelée automatiquement lors de la désallocation de l'objet en mémoire. */
    @Override
    protected void finalize() throws Throwable {
        // ...
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}

class Commentaire {
    // @ManyToOne
    private Publication publication;

    // @ManyToOne
    private Utilisateur auteur;

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }
}

// class CommentaireController {
//     @PostMapping("/publication/{id}/add-comment")
//     public void createComment(
//         @Pathvariable Long id,
//         @RequestBody Commentaire comment
//     ) {
//         Publication pub = this.publicationRepository.find(id);

//         comment.setPublication(pub);
//     }
// }
