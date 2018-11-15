-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 19 sep. 2018 à 14:34
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Activite
#------------------------------------------------------------

CREATE TABLE Activite(
        id_activite Int  Auto_increment  NOT NULL ,
        nom         Varchar (50) NOT NULL
	,CONSTRAINT Activite_PK PRIMARY KEY (id_activite)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Region
#------------------------------------------------------------

CREATE TABLE Region(
        id_region Int  Auto_increment  NOT NULL ,
        nom       Varchar (50) NOT NULL
	,CONSTRAINT Region_PK PRIMARY KEY (id_region)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Apprenant
#------------------------------------------------------------

CREATE TABLE Apprenant(
        id_apprenant  Int  Auto_increment  NOT NULL ,
        prenom        Varchar (50) NOT NULL ,
        nom           Varchar (50) NOT NULL ,
        dateNaissance Date NOT NULL ,
        email         Varchar (50) NOT NULL ,
        photo         Varchar (50) NOT NULL ,
        id_region     Int NOT NULL
	,CONSTRAINT Apprenant_PK PRIMARY KEY (id_apprenant)

	,CONSTRAINT Apprenant_Region_FK FOREIGN KEY (id_region) REFERENCES Region(id_region)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Effectuer
#------------------------------------------------------------

CREATE TABLE Effectuer(
        id_activite  Int NOT NULL ,
        id_apprenant Int NOT NULL
	,CONSTRAINT Effectuer_PK PRIMARY KEY (id_activite,id_apprenant)

	,CONSTRAINT Effectuer_Activite_FK FOREIGN KEY (id_activite) REFERENCES Activite(id_activite)
	,CONSTRAINT Effectuer_Apprenant0_FK FOREIGN KEY (id_apprenant) REFERENCES Apprenant(id_apprenant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Region
#------------------------------------------------------------

INSERT INTO region (nom) VALUES
    ('Ile de France'),('Pays de Loire'),('Aquitaine');

#------------------------------------------------------------
# Table: Apprenant
#------------------------------------------------------------

INSERT INTO apprenant (prenom,nom, dateNaissance, email,id_region) VALUES
    ("Géraldine", "Autrique","1970-12-27","geraldine.autrique@laposte.fr", "3"),
    ("Nicolas", "Filine", "1986-08-07", "nicolas.filine@laposte.fr", "1"),
    ("Pierre", "Gorce", "1976-01-05", "pierrexgorce@gmail.com", "1"),
    ("Samuel", "Joblon", "1973-10-18", "samuel.joblon@gmail.com", "1"),
    ("Phoneprasong", "Khamvongsa", "1983-04-12", "pomlao@hotmail.com", "2"),
    ("Vincent", "Lebegue", "1986-08-13", "vincent.lebegue@labanquepostale.fr", "1"),
    ("Matthieu", "Londeix", "1981-05-19", "matthieu.londeix@laposte.fr", "2"),
    ("Thomas", "Longueville", "1972-04-26", "thomas.longueville@laposte.fr", "2"),
    ("Christine", "Métivier", "1980-04-29", "christine.pereira@laposte.fr", "1"),
    ("Laurent", "Picard", "1972-05-23", "laurent2.picard@laposte.fr", "1"),
    ("David", "Pouline", "1982-07-07", "david.pouline@facteo.fr", "3"),
    ("Julien", "Prod'homme", "1990-08-31", "prodhomme.julien@gmail.com", "1"),
    ("Samuel", "Sabot", "1980-04-10", "samuel.sabot@facteo.fr", "3"),
    ("Salvatore", "Sancesario", "1975-05-10", "salvatore.sancesario@facteo.fr", "1"),
    ("David", "Sylvestre", "1986-07-06", "david.sylvestre@mfacteur.fr", "2"),
    ("Cédric", "Tressous", "1984-08-08", "cedric.tressous@gmail.com", "2"),
    ("Zébulon", "Zébutruc", "1977-03-13", "zebulonzeb@free.fr", "2");

#------------------------------------------------------------
# Table: Effectuer
#------------------------------------------------------------

INSERT INTO effectuer (id_activite, id_apprenant) VALUES
    ("1", "1"), ("3", "1"), ("5", "1"),
    ("2", "2"), ("4", "2"), ("6", "2"),
    ("7", "3"),
    ("8", "4"), ("10", "4"),
    ("2", "5"), ("4", "5"), ("6", "5"),
    ("1", "6"), ("3", "6"), ("5", "6"),
    ("2", "7"), ("4", "7"), ("6", "7"),
    ("8", "8"), ("10", "8"), ("9", "8"),
    ("1", "9"), ("3", "9"), ("5", "9"),
    ("11", "10"),
    ("2", "11"), ("4", "11"), ("6", "11"),
    ("1", "12"), ("3", "12"), ("5", "12"),
    ("11", "13"),
    ("8", "14"), ("10", "14"),
    ("1", "15"), ("3", "15"), ("5", "15"),
    ("8", "16");

#------------------------------------------------------------
# Table: Activite
#------------------------------------------------------------

INSERT INTO Activite VALUES("001","Programmer en java");
INSERT INTO Activite VALUES("002","Ecouter les mouches");
INSERT INTO Activite VALUES("003","Jouer au bilboquet");
INSERT INTO Activite VALUES("004","Dormir pendant le cours");
INSERT INTO Activite VALUES("005","Chercher un stage Ã  Haiti");
INSERT INTO Activite VALUES("006","Attendre les vacances");
INSERT INTO Activite VALUES("007","Prendre le goÃ»ter");
INSERT INTO Activite VALUES("008","Caresser le chat");
INSERT INTO Activite VALUES("009","Ecouter de la musique");
INSERT INTO Activite VALUES("010","Rien faire");
INSERT INTO Activite VALUES("011","Jouer Ã  Angular");
INSERT INTO Activite VALUES("012","RÃªver");
INSERT INTO Activite VALUES("013","Travailler jour et nuit");