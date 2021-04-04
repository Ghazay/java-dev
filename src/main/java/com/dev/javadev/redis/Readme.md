Lancez la commande
```
docker run -p 6379:6379 -d redis
```

Pour ne pas avoir à killer le container pour retrouver un redis "vide",
entrez dans le container puis faites
```
redis-cli
```
```
FLUSHALL
```