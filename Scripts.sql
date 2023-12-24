create database dbCafe;
use dbCafe;
CREATE TABLE Cafe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Produit VARCHAR(50),
    Nom VARCHAR(50),
    Categorie VARCHAR(50),
    Quantite VARCHAR(50),
    Prix VARCHAR(50)
);

INSERT INTO Cafe (id, Produit, Nom, Categorie, Quantite, Prix) VALUES
(null, 'Expresso', 'Café Fort', 'Boissons chaudes', 50, 2.5),
(null, 'Cappuccino', 'Cappuccino Crémeux', 'Boissons chaudes', 30, 3.0),
(null, 'Muffin aux myrtilles', 'Muffin Moelleux', 'Pâtisseries', 20, 2.0),
(null, 'Salade de poulet', 'Salade Fraîcheur', 'Repas légers', 15, 5.5);

select * from Cafe;
