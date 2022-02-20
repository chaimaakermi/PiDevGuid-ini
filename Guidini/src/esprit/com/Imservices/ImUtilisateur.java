/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.IserviceMethode;
import esprit.com.entity.Utilisateur;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amira
 */
// sna3et class bech n'impplimenti les methdes eli san2tho mn interface ISERVICE w 3adina Utilisateur par parametre
public class ImUtilisateur implements IserviceMethode<Utilisateur>{
    Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajouter(Utilisateur t) {
        try {
            String req = "INSERT INTO utilisateur (nom, prenom,adresse,email,motpass,role) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getAdresse());
            pst.setString(6, t.getRole());

           pst.executeUpdate();
            System.out.println("utilisateur  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Utilisateur t) {
          try {
            String req = "DELETE FROM utilisateur WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("utilisatuer suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Utilisateur t) {
         try {
            String req = "UPDATE utilisateur SET nom=?,prenom=?,adresse=?, email=? , motpass=? , role=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(7, t.getId());
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getMotpass());
            pst.setString(6, t.getRole());
            pst.executeUpdate();
            System.out.println("utilisateur modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Utilisateur> afficher() {
        
                List<Utilisateur> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM utilisateur";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Utilisateur(rs.getInt(1), rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("motpass"),rs.getString("role")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    

    @Override
    public List<Utilisateur> recherche(Utilisateur t) {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `utilisateur` WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                   list.add(new Utilisateur(rs.getInt(1), rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("motpass"),rs.getString("role")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
}
