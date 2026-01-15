# 🎓 Student Management System – Java JDBC & PostgreSQL

Application Java **en ligne de commande** permettant la gestion d’étudiants via une base de données **PostgreSQL**, en utilisant **JDBC**, une architecture en couches et des bonnes pratiques backend.

Ce projet a été réalisé dans un objectif **professionnel et pédagogique**, afin de consolider les bases du développement backend Java avant l’utilisation de frameworks comme Spring Boot.

---

## 🎯 Objectifs du projet

- Implémenter un CRUD complet avec **JDBC**
- Appliquer une **architecture en couches** (UI / Service / DAO)
- Utiliser le **pattern DAO**
- Gérer une base de données PostgreSQL
- Manipuler les entrées utilisateur via le terminal
- Structurer un projet Java maintenable et évolutif

---

## 🛠️ Stack technique

- **Java** (JDK 24+)
- **PostgreSQL**
- **JDBC**
- **Gradle**
- **IntelliJ IDEA**

---

## 🧱 Architecture du projet

```
src/main/java
└── com/Djallil
    ├── Main.java
    │
    ├── ui
    │   └── Menu.java
    │
    ├── service
    │   └── EtudiantService.java
    │
    ├── dao
    │   └── EtudiantDAO.java
    │
    ├── model
    │   └── Etudiant.java
    │
    ├── db
    │   ├── DatabaseConfig.java
    │   └── DatabaseConnection.java
    │
    └── exception
        └── DaoException.java
```
🔍 Rôle des couches
UI (ui)
Gère l’interaction utilisateur (menu, saisie clavier)

Service (service)
Contient la logique métier et fait le lien entre UI et DAO

DAO (dao)
Gère l’accès à la base de données via JDBC

Model (model)
Représente les entités métier (Étudiant)

DB (db)
Centralise la configuration et la connexion PostgreSQL

Exception (exception)
Gestion des exceptions personnalisées liées aux accès DB

🗄️ Modèle de données
Table etudiant
```
CREATE TABLE etudiant (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    note DOUBLE PRECISION NOT NULL
);
```
⚙️ Fonctionnalités
➕ Ajouter un étudiant

📄 Afficher tous les étudiants

✏️ Modifier la note d’un étudiant

❌ Supprimer un étudiant

📊 Calculer la moyenne des notes

▶️ Exécution du projet
Configuration de la base de données
Les paramètres de connexion sont définis dans :
```
db/DatabaseConfig.java
```
et utilisés par :
```
db/DatabaseConnection.java
```
Lancement avec Gradle
```
./gradlew run
```
ou sous Windows :
```
gradlew run
```
💻 Exemple d’utilisation
```
==== MENU PRINCIPAL ====
1. Ajouter un étudiant
2. Afficher les étudiants
3. Modifier une note
4. Supprimer un étudiant
5. Quitter

Votre choix :
```
🧠 Compétences mises en œuvre
Java orienté objet

JDBC (Connection, PreparedStatement, ResultSet)

SQL (CRUD)

Pattern DAO

Architecture en couches

Try-with-resources

Gestion des exceptions

Interaction console

🚀 Évolutions possibles
Ajout de tests unitaires

Gestion avancée des transactions

Pagination et tri

Migration vers une API REST avec Spring Boot

Interface web (Angular / Thymeleaf)

👨‍💻 Auteur : **Djallil AHAMADA**

Projet réalisé dans le cadre d’un apprentissage approfondi du développement backend Java et de la persistance des données avec PostgreSQL.
