# TP2 : Capteurs, liste et fragments

Hugo SILIVERI

Lien du Git : https://github.com/HugoSiliveri/tp2-mobile

### Environnement

- Minimum SDK : API 24 (Nougat)
- Appareil virtuel utilisé : Pixel 8 API 35 (Android 15)
- Appareil physique utilisé : Samsung S20 API 33 (Android 13)


### Description des fichiers

- `MainActivity.kt` : Activité principale de l'application (page d'accueil pour accéder aux autres activités)
- `SensorList.kt` : Affichage de la liste des capteurs disponibles (exercice 1)
- `SensorAvailability.kt` : Affichage de la liste des capteurs indisponibles (exercice 2)
- `Accelerometer.kt` : Affichage de différentes couleurs en fonction de l'accélération (exercice 3)
- `Direction.kt` : Affichage de la direction du mouvement (exercice 4)
- `Flashlight.kt` : Allumage/Eteignage de la lampe-torche en secouant le téléphone (exercice 5)
- `Proximity.kt` : Affichage d'images en fonction de la proximité du capteur (exercice 6)
- `Geolocation.kt` : Afficahge des coordonnées géographiques du téléphone (exercice 7)
- `CountriesList.kt` : Affichage de la liste des pays (exercice 8)
- `CountriesListInfo.kt` : Affichage des informations détaillées d'un pays (exercice 8)
- `CountriesAdapter.kt` : Adapteur de la liste des pays (exercice 8 et 9)
- `CountryData.kt` : Données des pays (exercice 8 et 9)
- `CountriesFragmentActivity.kt` : Activité contenant les fragments (exercice 9)
- `CountriesFragment.kt` : Fragment de la liste des pays (exercice 9)
- `CountriesFragmentInfo.kt` : Fragment des informations détaillées d'un pays (exercice 9)

### Exercice 1

<img src="screenshots/exo1.png" alt="exo1" width="200"/>

### Exercice 2 (réalisé sur un appareil physique)

<img src="screenshots/exo2.jpg" alt="exo2" width="200"/>

### Exercice 3

<img src="screenshots/exo3.png" alt="exo3" width="200"/>

### Exercice 4

<img src="screenshots/exo4.png" alt="exo4" width="200"/>

### Exercice 5

J'ai mis un toast pour afficher si la lampe est allumée ou éteinte sur l'appareil viruelle.
Sinon la lampe s'allume/s'éteint bien sur l'appareil physique.

<img src="screenshots/exo5.png" alt="exo5" width="200"/>

### Exercice 6

L'image du chat qui tire la langue c'est pour un objet proche.

<img src="screenshots/exo6-1.png" alt="exo61" width="200"/>

L'image du chat qui regarde c'est pour un objet loin.

<img src="screenshots/exo6-2.png" alt="exo62" width="200"/>

### Exercice 7

<img src="screenshots/exo7.jpg" alt="exo7" width="200"/>

### Exercice 8

Les drapeaux étaient au format SVG, pour les utiliser dans les ImageView j'ai du les transformer en 
VectorAsset. Cependant, pour le drapeau des Etats-Unis, cela donne un résultat étrange avec les étoiles

<img src="screenshots/exo8-1.png" alt="exo81" width="200"/>
<img src="screenshots/exo8-2.png" alt="exo82" width="200"/>

### Exercice 9


<img src="screenshots/exo9-1.png" alt="exo91" width="200"/>
<img src="screenshots/exo9-2.png" alt="exo92" width="200"/>