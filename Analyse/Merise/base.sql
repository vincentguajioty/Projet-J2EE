#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Produit
#------------------------------------------------------------

CREATE TABLE Produit(
        id_produit   int (11) Auto_increment  NOT NULL ,
        type_produit Varchar (25) ,
        nom_produit  Varchar (25) ,
        prix_produit Float ,
        PRIMARY KEY (id_produit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Client
#------------------------------------------------------------

CREATE TABLE Client(
        id_cli      int (11) Auto_increment  NOT NULL ,
        nom_cli     Varchar (25) ,
        prenom_cli  Varchar (25) ,
        adresse_cli Varchar (25) ,
        tel_cli     Numeric ,
        mdp_cli     Varchar (25) ,
        mail_cli    Varchar (25) ,
        datenaiss   Date ,
        id_panier   Int ,
        PRIMARY KEY (id_cli )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Traiteur
#------------------------------------------------------------

CREATE TABLE Traiteur(
        id_traiteur  int (11) Auto_increment  NOT NULL ,
        nom_traiteur Varchar (25) ,
        PRIMARY KEY (id_traiteur )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Plat
#------------------------------------------------------------

CREATE TABLE Plat(
        id_plat      int (11) Auto_increment  NOT NULL ,
        type_cuisine Varchar (25) ,
        nb_pers      Int ,
        chaud        Bool ,
        type_plat    Varchar (25) ,
        id_produit   Int NOT NULL ,
        PRIMARY KEY (id_plat ,id_produit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Panier
#------------------------------------------------------------

CREATE TABLE Panier(
        id_panier int (11) Auto_increment  NOT NULL ,
        id_cli    Int ,
        PRIMARY KEY (id_panier )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Commande
#------------------------------------------------------------

CREATE TABLE Commande(
        id_commande        int (11) Auto_increment  NOT NULL ,
        paiement_fait      Bool ,
        livraison_domicile Bool ,
        livraison_heure    Date ,
        etat_com           Int ,
        id_cli             Int ,
        PRIMARY KEY (id_commande )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Menu
#------------------------------------------------------------

CREATE TABLE Menu(
        id_menu    Int NOT NULL ,
        id_produit Int NOT NULL ,
        PRIMARY KEY (id_menu ,id_produit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: fournit
#------------------------------------------------------------

CREATE TABLE fournit(
        stock_trait Int ,
        id_traiteur Int NOT NULL ,
        id_plat     Int NOT NULL ,
        id_produit  Int NOT NULL ,
        PRIMARY KEY (id_traiteur ,id_plat ,id_produit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: contient
#------------------------------------------------------------

CREATE TABLE contient(
        id_produit Int NOT NULL ,
        id_panier  Int NOT NULL ,
        PRIMARY KEY (id_produit ,id_panier )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: avoir
#------------------------------------------------------------

CREATE TABLE avoir(
        id_menu            Int NOT NULL ,
        id_produit         Int NOT NULL ,
        id_plat            Int NOT NULL ,
        id_produit_Produit Int NOT NULL ,
        PRIMARY KEY (id_menu ,id_produit ,id_plat ,id_produit_Produit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: constitue
#------------------------------------------------------------

CREATE TABLE constitue(
        id_produit  Int NOT NULL ,
        id_commande Int NOT NULL ,
        PRIMARY KEY (id_produit ,id_commande )
)ENGINE=InnoDB;

ALTER TABLE Client ADD CONSTRAINT FK_Client_id_panier FOREIGN KEY (id_panier) REFERENCES Panier(id_panier);
ALTER TABLE Plat ADD CONSTRAINT FK_Plat_id_produit FOREIGN KEY (id_produit) REFERENCES Produit(id_produit);
ALTER TABLE Panier ADD CONSTRAINT FK_Panier_id_cli FOREIGN KEY (id_cli) REFERENCES Client(id_cli);
ALTER TABLE Commande ADD CONSTRAINT FK_Commande_id_cli FOREIGN KEY (id_cli) REFERENCES Client(id_cli);
ALTER TABLE Menu ADD CONSTRAINT FK_Menu_id_produit FOREIGN KEY (id_produit) REFERENCES Produit(id_produit);
ALTER TABLE fournit ADD CONSTRAINT FK_fournit_id_traiteur FOREIGN KEY (id_traiteur) REFERENCES Traiteur(id_traiteur);
ALTER TABLE fournit ADD CONSTRAINT FK_fournit_id_plat FOREIGN KEY (id_plat) REFERENCES Plat(id_plat);
ALTER TABLE fournit ADD CONSTRAINT FK_fournit_id_produit FOREIGN KEY (id_produit) REFERENCES Produit(id_produit);
ALTER TABLE contient ADD CONSTRAINT FK_contient_id_produit FOREIGN KEY (id_produit) REFERENCES Produit(id_produit);
ALTER TABLE contient ADD CONSTRAINT FK_contient_id_panier FOREIGN KEY (id_panier) REFERENCES Panier(id_panier);
ALTER TABLE avoir ADD CONSTRAINT FK_avoir_id_menu FOREIGN KEY (id_menu) REFERENCES Menu(id_menu);
ALTER TABLE avoir ADD CONSTRAINT FK_avoir_id_produit FOREIGN KEY (id_produit) REFERENCES Produit(id_produit);
ALTER TABLE avoir ADD CONSTRAINT FK_avoir_id_plat FOREIGN KEY (id_plat) REFERENCES Plat(id_plat);
ALTER TABLE avoir ADD CONSTRAINT FK_avoir_id_produit_Produit FOREIGN KEY (id_produit_Produit) REFERENCES Produit(id_produit);
ALTER TABLE constitue ADD CONSTRAINT FK_constitue_id_produit FOREIGN KEY (id_produit) REFERENCES Produit(id_produit);
ALTER TABLE constitue ADD CONSTRAINT FK_constitue_id_commande FOREIGN KEY (id_commande) REFERENCES Commande(id_commande);
