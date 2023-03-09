package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurservice {
    void addUtilisateur(Utilisateur utilisateur);
    void deleteutilisateur(int id);
    void updateParticipant(Utilisateur utilisateur);
    List<Utilisateur> getAllUtilisateur();
    Utilisateur getUtilisateurByUsername(String username);
    Utilisateur getUtilisateurById(int id);
}
