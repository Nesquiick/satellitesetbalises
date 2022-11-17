# SatellitesEtBalises

## Auteurs
Loreleï NOIRAUD & Yuna OTRANTE-CHARDONNET

##Modification apportées au projet
###Correction du bogue
Nous avons corrigé le souci de blocage de la balise au bout d'un certain temps à la surface.
Nous avons remarqué que cela était dû au fait que la balise se rechargeait en donnée même en attendant 
un satellite à la surface. Nous avons donc ajouté une condition afin d'incrémenter notre quantité de data uniquement 
lorsque notre balise n'est pas à la surface et lorsqu'elle n'est pas déjà pleine.

###Modification de la profondeur d'une balise
Nous avons remarqué que les balises retournent toujours à la même profondeur avant de se déplacer afin de se recharger en donnée. 
Nous trouvons ça dommage, une balise ne va jamais au-delà de sa limite. 
Nous avons donc décider qu'elle redescendra à chaque fois a une profondeur aléatoire.
Cette modification pouvait aussi régler le bogue précédemment corrigé.

###Bouton pause
Nous avons ajouté un bouton afin de pouvoir pauser l'animation

###Affichage des données
Nous avons ajouté un label afin d'afficher la quantité de données contenue par les satellites

###Commentaires

###Documentation


//TODO
vider la memoire du satellite
améliorations algorithmiques et de conception objet