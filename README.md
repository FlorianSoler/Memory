# Memory

Memory is a school project that aim at improving OOD skills in order to produce code at enterprise level.

Bien sûr ! Voici un exemple de fichier README pour expliquer comment lancer votre programme `Main.java` à la fois sur Visual Studio Code (VSCode) et sur Linux en utilisant `javac` :

---

Ce guide vous explique comment lancer le programme `Main.java` à la fois sur Visual Studio Code (VSCode) et sur Linux en utilisant `javac`.

## Prérequis

Assurez-vous d'avoir les éléments suivants installés sur votre système :

- Java Development Kit (JDK)
- Visual Studio Code (facultatif)

## Lancer le programme sur Visual Studio Code (VSCode)

1. Ouvrez le dossier contenant votre projet `Main.java` dans Visual Studio Code.
2. Assurez-vous d'avoir l'extension "Java Extension Pack" installée dans VSCode.
3. Dans VSCode, ouvrez le fichier `Main.java`.
4. Pour compiler le programme, appuyez sur `Ctrl + Maj + P` (ou `Cmd + Maj + P` sur Mac) pour ouvrir la palette de commandes.
5. Tapez "Java: Compiler le fichier actuel" dans la palette de commandes et sélectionnez cette option.
6. Une fois le fichier compilé avec succès, un fichier `.class` sera généré dans le même répertoire.
7. Pour exécuter le programme, retournez à la palette de commandes et tapez "Java: Exécuter le fichier actuel".

## Lancer le programme sur Linux avec javac

1. Ouvrez un terminal.
2. Assurez-vous que vous êtes dans le répertoire contenant le fichier `Main.java`.
3. Compilez le programme en utilisant la commande `javac` :

   ```bash
   javac Main.java
   ```

   Cela générera un fichier `Main.class` dans le même répertoire.
4. Une fois le fichier compilé avec succès, exécutez le programme en utilisant la commande `java` :

   ```bash
   java Main
   ```

   Le programme `Main` sera exécuté et vous verrez la sortie correspondante dans le terminal.

---

N'hésitez pas à personnaliser ce README en fonction de votre projet, y compris des instructions supplémentaires ou des informations spécifiques à votre cas d'utilisation.