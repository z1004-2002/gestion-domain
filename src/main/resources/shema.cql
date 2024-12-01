CREATE KEYSPACE IF NOT EXISTS yowyobdb
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE yowyobdb;

-- Création de la table domain
CREATE TABLE domains(
    id TEXT PRIMARY KEY,                -- Identifiant unique du domaine
    name TEXT,                          -- Nom du domaine
    apiKey TEXT,                        -- Clé API associée
    idOwner TEXT                        -- Identifiant du propriétaire
);
