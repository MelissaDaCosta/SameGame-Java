
JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        BoutonMenu.java \
        GrilleAleatoire.java \
        Hasard.java \
	Menu.java \
	NouvelleFenetre.java \
	Bloc.java \
	EffacerBlocs.java \
	FinBloc.java \
	FinJeu.java \
	Score.java \
	Survol.java \
	Deplacement.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

test: classes
	$(J) Main

clean:
	$(RM) *.class
