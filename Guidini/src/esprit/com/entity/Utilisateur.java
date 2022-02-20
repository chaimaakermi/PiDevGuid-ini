/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author amira
 */
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String motpass;
    private String role;
    
    // Affichage ( affichage par id ), modifier  , Id AutoIncrement

    public Utilisateur(int id, String nom, String prenom, String adresse, String email, String motpass, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpass = motpass;
        this.role = role;
    }
// Recherche par id , supprission
    public Utilisateur(int id) {
        this.id = id;
    }
// isertion sans id
    public Utilisateur(String nom, String prenom, String adresse, String email, String motpass, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpass = motpass;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotpass() {
        return motpass;
    }

    public void setMotpass(String motpass) {
        this.motpass = motpass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "\n Utilisateur"+ id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", motpass=" + motpass + ", role=" + role + '}';
    }
  
    
}
