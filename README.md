# SatellitesEtBalises

## Auteurs
Loreleï NOIRAUD & Yuna OTRANTE-CHARDONNET

##Modification apportée au projet
###Correction du bogue
Nous avons corrigé le souci de blocage de la balise au bout d'un certain temps à la surface.
Nous avons remarqué que cela était dû au fait que la balise se rechargeait en donnée même en attendant 
un satellite à la surface. Nous avons donc ajouté une condition afin d'incrémenter notre quantité de data uniquement 
lorsque notre balise n'est pas à la surface et lorsqu'elle n'est pas déjà pleine.

###Modification de la profondeur d'une balise
Nous avons remarqué que les balises retournent toujours à la même profondeur avant de se déplacer afin de se recharger 
en donnée. 
Nous trouvons ça dommage, une balise ne va jamais au-delà de sa limite. 
Nous avons donc décidé qu'elle redescendra à chaque fois a une profondeur aléatoire.
Cette modification pouvait aussi régler le bogue précédemment corrigé.

###Bouton pause
Nous avons ajouté un bouton afin de pouvoir pauser l'animation

###Affichage des données
Nous avons ajouté un label afin d'afficher la quantité de données contenue par les satellites

###Javadoc
De nombreux commentaires ont été ajoutés afin de permettre une meilleure compréhension des méthodes 
et des classes de ce projet.

###Documentation
Des diagrammes UML de l'architecture ont été réalisé afin d'apporter une meilleure compréhension 
à l'architecture globale de ce projet.

###Ajout de l'antenne
Nous avons décidé d'ajouter à la simulation une antenne qui récupères les données des satellites (quand ils en ont)
quand ils passent au-dessus de celle-ci. Nous avons décidé que notre antenne récupère des données à chaque fois qu'un 
satellite passe avec des données (même s'il n'est pas plein) afin d'éviter des pertes de données vis-à-vis des balises.


###Privatisation des variables d'instances des différentes classes
Afin de sécuriser le code pour éviter une mauvaise utilisation par la suite des variables, nous avons décidé de rendre 
les variables private avec des accesseurs.

###Transfère des données des balises
Tel que le code était fait, les données des balises étaient transférées aux satellites dès que la mémoire était pleine 
sans attendre que la balise ne soit remontée à la surface. Maintenant, on attend que la balise soit remontée pour
transférer les données

###Création d'une nouvelle classe abstraite
Comme nous avons ajouté une antenne, nous avons décidé de créer une classe abstraite Element dont dépend maintenant 
ElementMobile et qui est hérité par la classe Antenne.