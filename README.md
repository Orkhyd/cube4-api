## Pour utiliser la db avec docker : 
### Pour lancer la db
Dans le dossier cube4-api où est le fichier docker-compose.yml   : `docker compose up -d`

### Pour recharger la db ( une fois lancée ) après avoir update le dump
`docker compose down`
`docker compose up -d`

### Prop par défaut ( dans le fichier resources/application.properties )
Login : `root`
Password: `root`
Port: `3308`
Database: `Cube4DB`
