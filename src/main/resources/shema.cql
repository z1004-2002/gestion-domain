CREATE KEYSPACE IF NOT EXISTS yowyobdb
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE yowyobdb;
-- Création de la table ressources
