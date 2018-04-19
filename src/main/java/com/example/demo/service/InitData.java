package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class InitData {

    @Autowired
    private EntityManager em;

    public void insertTestData() {

        Client client  = new Client();
        client.setNom("PETRILLO");
        client.setPrenom("Alexandre");
        client.setAge(28);
        client.setAdresse("40 Rue de l'égalité 69003");
        em.persist(client);
        
        Client client2  = new Client();
        client2.setNom("SLIMANI");
        client2.setPrenom("Abderzak");
        client2.setAge(30);
        client2.setAdresse("32 Avenue de la gloire 69001");
        em.persist(client2);
        
        Client client3  = new Client();
        client3.setNom("DUPOND");
        client3.setPrenom("Julien");
        client3.setAge(25);
        client3.setAdresse("4 Allée des musées 69007");
        em.persist(client3);

        Article article = new Article();
        article.setLibelle("Carte mère ASROCK 2345");
        article.setPrix(79.90);
        em.persist(article);
        
        Article article2 = new Article();
        article2.setLibelle("Carte mère ASROCK 1005");
        article2.setPrix(85.00);
        em.persist(article2);
        
        Article article3 = new Article();
        article3.setLibelle("Ecran Samsung 2145");
        article3.setPrix(120.00);
        em.persist(article3);
        
        Article article4 = new Article();
        article4.setLibelle("Chargeur 150A 3301");
        article4.setPrix(75.50);
        em.persist(article4);

        Facture facture = new Facture();
        facture.setClient(client);
        em.persist(facture);
        
        Facture facture2 = new Facture();
        facture2.setClient(client2);
        em.persist(facture2);
        
        Facture facture3 = new Facture();
        facture3.setClient(client3);
        em.persist(facture3);

        LigneFacture ligneFacture1 = new LigneFacture();
        ligneFacture1.setFacture(facture);
        ligneFacture1.setArticle(article);
        ligneFacture1.setQuantite(1);
        em.persist(ligneFacture1);
        
        LigneFacture ligneFacture2 = new LigneFacture();
        ligneFacture2.setFacture(facture);
        ligneFacture2.setArticle(article2);
        ligneFacture2.setQuantite(1);
        em.persist(ligneFacture2);

        LigneFacture ligneFacture3 = new LigneFacture();
        ligneFacture3.setFacture(facture);
        ligneFacture3.setArticle(article3);
        ligneFacture3.setQuantite(3);
        em.persist(ligneFacture3);
        
        LigneFacture ligneFacture4 = new LigneFacture();
        ligneFacture4.setFacture(facture2);
        ligneFacture4.setArticle(article);
        ligneFacture4.setQuantite(3);
        em.persist(ligneFacture4);
        
        LigneFacture ligneFacture5 = new LigneFacture();
        ligneFacture5.setFacture(facture2);
        ligneFacture5.setArticle(article2);
        ligneFacture5.setQuantite(5);
        em.persist(ligneFacture5);
              
        LigneFacture ligneFacture6 = new LigneFacture();
        ligneFacture6.setFacture(facture3);
        ligneFacture6.setArticle(article);
        ligneFacture6.setQuantite(4);
        em.persist(ligneFacture6);
        
    }
}