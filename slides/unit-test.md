# Unit Testing

----

## Plan

- Introduction


----
## Definition

>« Méthode du test logiciel qui consiste à tester individuellement des unités du logiciel sous test »


-----

## Units

Intuitivement, une unité est la plus petite partie testable d’un logiciel.
En programmation procédural, une unité désigne une fonction ou une procédure.
En programmation à objets, une unité désigne généralement une classe.

----

## Goal

\item[Postulat:] Si une méthode n'a pas de test automatique, elle ne marche pas. 
    
\item[1er objectif:] simplifier l'écriture de tests.
    
\item[2ème objectif:] simplifier la création de tests qui gardent leurs valeurs.  
    
\item[3ème objectif:] simplifier l'utilisation des tests existants pour en créer des nouveaux. 

----
## from the client prespective

Les cas de tests appellent les méthodes depuis l’extérieur
On ne peut tester que ce qui est public
Le test d’une classe se fait à partir d’une classe extérieure
Au moins un cas de test par méthode publique
Il faut choisir un ordre pour le test
quelles méthodes sont interdépendantes?




\newcommand{\code}[1]{\lstinline!#1!}

\title{JUnit}
\subtitle{Test unitaire en Java}
\author[G. Sunyé]{Gerson Suny\'e \\ gerson.sunye@univ-nantes.fr}
\institute[U. Nantes \hspace{2em} \insertframenumber/ \inserttotalframenumber]{Lina \--- Université de Nantes}
\begin{document}

\begin{frame}
  \titlepage
\end{frame}

\begin{frame}{Plan}
\tableofcontents[hidesubsections]
\end{frame}

\section{Introduction}
\frame{\tableofcontents[currentsection,hideothersubsections]}

\begin{frame} {JUnit}
%\vspace{1cm}
  \begin{itemize}
  \item Public visé: développeurs en train de tester leur code.
  
  \item Phase de développement: implémentation.
  
  \item Type de test: test unitaire de classes.
  
  \item Méthode: test d'entrées normales et erronées, et comparaison 
avec les résultats attendus.
  
  \end{itemize} 

\end{frame}


\begin{frame} {Bénéfices quantitatifs}
%\vspace{1cm}
  \begin{itemize}
    \item Objectif: succès ou échec.
    \item Répétitif: retester après un changement pour vérifier les 
effets de bord inattendus.
    \item Mesurable: il est possible de compter le nombre de 
succès/échecs.
    \item Limité: la détection d'erreurs est simplifiée.
    \item Economique: les erreurs sont trouvées et détectées très tôt.

  \end{itemize}

\end{frame}

\begin{frame} {Bénéfices qualitatifs}
%\vspace{1cm}
  \begin{itemize}
    \item Utilisation d'impositions: l'écriture du test unitaire nous 
force à traiter certains points importants du design: cohésion, 
couplage.

    \item Développement assuré: on sait ce qui marche. Il est plus 
simple de modifier quand on peut retester.

  \end{itemize}
\end{frame}

\begin{frame} {Historique}
%\vspace{1cm}
    \begin{itemize}
        \item  Programmation Extreme (XP).
    
        \item  Smalltalk Test Framework (Kent Beck).
    
        \item  JUnit - Première version écrite par Erich Gamma (97).
    
        \item  Décrit dans Java Report de Juillet 98.
    
        \item  Implémenté en plusieurs langages (C++, Python, etc.).
    \end{itemize}

\end{frame}

\begin{frame} {Objectifs}
%\vspace{1cm}
    \begin{description}

    \end{description} 
    
\end{frame}


% -------- -------- -------- -------- -------- -------- -------- 
% -------- --------
\section{Exemple d'utilisation}
\frame{\tableofcontents[currentsection,hideothersubsections]}


\begin{frame} {Définition du problème}
%\vspace{1cm}
    \begin{itemize}
        \item  Représentation arithmétique de plusieurs monnaies.
    
        \item  La conversion entre différentes monnaies n'est pas 
        possible: 
  \begin{itemize}
      \item  Il n'y a pas de taux d'échange unique.
  
      \item  Il est parfois nécessaire de comparer la valeur d'un 
      portefeuille avec les taux passés.
  \end{itemize}
    \end{itemize}
    
\end{frame}

\begin{frame}[fragile]
\frametitle{La classe Money}
\begin{lstlisting}[frame=tb]
class Money {
  private int fAmount;    
  private String fCurrency; //ISO abbreviation (USD, CHF, etc.). 
  public Money(int amount, String currency){
    fAmount= amount; fCurrency= currency;}     
  public int amount() {
    return fAmount;}    
  public String currency() {  
    return fCurrency;} 
  public Money add(Money m) {  
    return new Money(amount()+m.amount(),currency());}}
\end{lstlisting}

\end{frame}


\begin{frame} {Test de la classe Money}
%\vspace{1cm}
    \begin{itemize}
        \item Création d'une classe de test.
		\item Import des annotations de JUnit: After, AfterClass, Before, BeforeClass, Test.
		\item Import statiques de méthodes d'assertion: 
    \begin{itemize}
        \item   La méthode \code{assertTrue()} enregistre une erreur, quand l'argument est faux.
        \item  La méthode \code{assertEquals()} teste l'égalité et 
        enregistre la valeur des deux objets, s'ils sont différents.
    \end{itemize}
        \end{itemize}
\end{frame}


\begin{frame}[fragile]\frametitle{MoneyTest::testSimpleAdd() (1/2)}
\begin{lstlisting}[frame=tb]
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoneyTest {
  //...
}
\end{lstlisting}

\end{frame}

\begin{frame}[fragile]\frametitle{MoneyTest::testSimpleAdd() (2/2)}
Le résultat de l'addition de deux monnaies d'une même devise est le total des deux valeurs: 
%%\vspace{1cm}
%%\vspace{0.5cm}
\begin{lstlisting}[frame=tb]
  (...)
  @Test
  public void testSimpleAdd() {
    // Creation du contexte (test fixture):
    Money m12CHF= new Money(12, "CHF"); 
    Money m14CHF= new Money(14, "CHF");
    Money expected= new Money(26, "CHF");
    Money result= m12CHF.add(m14CHF); // calcul:
    assertTrue(expected.equals(result)); // verification
  }
    //... }
\end{lstlisting}

\end{frame}



\begin{frame} [fragile]
\frametitle{MoneyTest::testEquals()}
%\vspace{0.5cm}
    Deux monnaies sont égales si elles ont la 
    même valeur et la même devise:
    \begin{lstlisting}[frame=tb]
@Test
public void testEquals() {
  Money m12CHF= new Money(12, "CHF"); 
  Money m14CHF= new Money(14, "CHF");  
  assertFalse(m12CHF.equals(null));   
  assertEquals(m12CHF, m12CHF); 
  assertEquals(m12CHF, new Money(12, "CHF")); // (1)  
  assertFalse(m12CHF.equals(m14CHF)); }
    \end{lstlisting}

\end{frame}


\begin{frame}[fragile]
\frametitle {Money::equals()}
%\vspace{0.5cm}
    \begin{lstlisting}[frame=tb]
public boolean equals(Object anObject) {
  if (anObject instanceof Money){
    Money aMoney= (Money)anObject; 
    return aMoney.currency().equals(currency())  && 
      amount() == aMoney.amount(); } 
    return false; 
}
\end{lstlisting}

\end{frame}


\begin{frame} {Partie fixe commune (1/2)}
    %\vspace{1cm}
\begin{itemize}
    \item  Dupplication de code pour préparer les tests.

    \item  La méthode \code{setup()}
    \begin{itemize}
        \item  Réutilisation de la partie fixe de préparation.
    
        \item  Par l'utilisation de l'annotation \code{@Before}.
    \end{itemize}

    \item  L'annotation \code{@After}
    \begin{itemize}
        \item  Opération symétrique avec \code{@Before}.
        \item  Efface la partie fixe à la fin d'un test.
    \end{itemize}
\end{itemize}
\end{frame}


\begin{frame} {Partie fixe commune (2/2)}
    %\vspace{1cm}
        \begin{itemize}
    \item  Chaque test utilise sa propre partie fixe.
    \begin{itemize}
        \item  JUnit appelle les méthodes annotées \code{@Before} et \code{@After} avant et après chaque test.
    
        \item  Il ne doit pas avoir d'effet de bord entre différentes 
        exécutions.
    \end{itemize}
\end{itemize}

\end{frame}

\begin{frame}[c]
	\frametitle{Exécution de la classe de test}
	\begin{figure}[htbp]
		\centering
			\includegraphics[width=.6\linewidth]{execution}
		\caption{Diagramme d'activités UML}
		\label{fig:label}
	\end{figure}
	
\end{frame}


\begin{frame}[fragile]
\frametitle{Réécriture des tests (1/2)}
%\vspace{0.5cm}
    Utilisation de \code{@Before}:
    
    \begin{lstlisting}[frame=tb]
public class MoneyTest {
  private Money f12CHF;
  private Money f14CHF;
  @Before
  public void setUp() {  
    f12CHF= new Money(12, "CHF"); 
    f14CHF= new Money(14, "CHF");  
  }
  // (...)
  \end{lstlisting}
\end{frame}

\begin{frame}[fragile]
\frametitle{Réécriture des tests (2/2)}
%\vspace{0.5cm}
    \begin{lstlisting}[frame=tb]
  @Test
  public void testEquals() {
    assertFalse(f12CHF.equals(null)); 
    assertEquals(f12CHF, f12CHF); 
    assertEquals(f12CHF, new Money(12, "CHF")); 
    assertFalse(f12CHF.equals(f14CHF)); 
  } 
  @Test
  public void testSimpleAdd() { 
    Money expected= new Money(26, "CHF"); 
    Money result= f12CHF.add(f14CHF);  
    assertTrue(expected.equals(result)); }
}
  \end{lstlisting}
\end{frame}


\begin{frame}[fragile]
\frametitle {Arithmétique mixte}
%\vspace{0.2cm}
    Pour éviter les problèmes liés aux multiples devises, on créé la 
    classe \code{MoneyBag}.
    
    \begin{lstlisting}[frame=tb]
class MoneyBag {
  private List<Money> fMonies= new LinkedList<Money>();
  MoneyBag(Money m1, Money m2) { 
    appendMoney(m1); 
    appendMoney(m2); }    
  MoneyBag(Money bag[]) {
    for (int i= 0; i < bag.length; i++)
    appendMoney(bag[i]); // ajout d'une devise}}
\end{lstlisting}
\end{frame}


\begin{frame}[fragile]
\frametitle {Test de MoneyBag (1/2)}
%\vspace{1cm}
    \begin{lstlisting}[frame=tb]
@Before
public void setUp() {
     f12CHF= new Money(12, "CHF");
     f14CHF= new Money(14, "CHF");
     f7USD=  new Money( 7, "USD");
     f21USD= new Money(21, "USD");
     fMB1= new MoneyBag(f12CHF, f7USD);
     fMB2= new MoneyBag(f14CHF, f21USD); 
}

\end{lstlisting}
\end{frame}

\begin{frame}[fragile]
\frametitle{Test de MoneyBag (2/2)}
%\vspace{1cm}
    \begin{lstlisting}[frame=tb]
@Test
public void testBagEquals() {  
  assertFalse(fMB1.equals(null));  
  assertEquals(fMB1, fMB1);  
  assertFalse(fMB1.equals(f12CHF)); 
  assertFalse(f12CHF.equals(fMB1)); 
  assertFalse(fMB1.equals(fMB2)); 
}

\end{lstlisting}
\end{frame}


\begin{frame}[fragile]
\frametitle{La méthode Money::add()}
    %\vspace{1cm}
    \begin{lstlisting}[frame=tb]
public Money add(Money m) {
  if (m.currency().equals(currency()) ) 
    return new Money(amount()+m.amount(),currency()); 
  return new MoneyBag(this, m); 
}
\end{lstlisting}

\end{frame}


\begin{frame}[fragile]
\frametitle{L'interface IMoney}
    %\vspace{1cm}
    Introduction d'une interface pour cacher les deux 
    implémentations (\code{Money} et \code{MoneyBag}) des classes clientes.

    \begin{lstlisting}[frame=tb]
interface IMoney { 
    public abstract IMoney add(IMoney aMoney);     
   //... 
}
\end{lstlisting}
\end{frame}


\begin{frame}[fragile]
\frametitle{Test de l'addition}
    %\vspace{1cm}
    \begin{lstlisting}[frame=tb]
@Test
public void testMixedSimpleAdd() { 
     // [12 CHF] + [7 USD] == {[12 CHF][7 USD]} 
     Money bag[]= { f12CHF, f7USD };  
     MoneyBag expected = new MoneyBag(bag);   
     assertEquals(expected, f12CHF.add(f7USD));  
}
\end{lstlisting}
\end{frame}


\begin{frame} {Autres tests similaires}
    %\vspace{1cm}
\begin{itemize}
    \item  \code{testBagSimpleAdd()}: additionner un \code{MoneyBag} à un \code{Money}.

    \item  \code{testSimpleBagAdd()}: additionner un \code{Money} à un \code{MoneyBag}. 

    \item  \code{testBagBagAdd()}: additionner deux \code{MoneyBags}.
\end{itemize}
  
\end{frame}



\begin{frame} {Implémentation de l'addition}
%\vspace{0.2cm}
    La complexité de l'implémentation concerne la gestion des 
    différentes combinaisons possibles de \code{Money} et \code{MoneyBag}.
    \begin{itemize}
        \item  Le  \emph{double dispatch} est une manière élégante de 
        traiter le problème.
    
        \item  L'idée derrière le \emph{double dispatch} est 
        d'utiliser un appel additionel pour découvrir le type de 
        l'argument qui sera traité.
    
        \item  Une méthode de même nom que l'originelle (suivie du nom 
        du receveur) et implémentée par l'argument est appelée.
    \end{itemize}
\end{frame}
    
\begin{frame}[fragile]
\frametitle{Implémentation de l'addition}
%%\vspace{1cm}
    \begin{lstlisting}[frame=tb]
class Money implements IMoney {
  public IMoney add(IMoney m) {
    return m.addMoney(this);   }
  //... }
  
class MoneyBag implements IMoney {
  public IMoney add(IMoney m) {
    return m.addMoneyBag(this); }     
  //... }
\end{lstlisting}
\end{frame}


\begin{frame}[fragile]
\frametitle{Double dispatch dans Money}
%%\vspace{1cm}
    \begin{lstlisting}[frame=tb]
class Money implements IMoney {
  public IMoney add(IMoney m) {
    return m.addMoney(this);     }
    
  public IMoney addMoney(Money m) {
    if (m.currency().equals(currency()) )     
      return new Money(amount()+m.amount(), currency());  
    return new MoneyBag(this, m); } 
    
  public IMoney addMoneyBag(MoneyBag s) {
    return s.addMoney(this); }}
\end{lstlisting}
\end{frame}


\begin{frame}[fragile]
\frametitle{Double dispatch dans MoneyBag}
%%\vspace{1cm}
    \begin{lstlisting}[frame=tb]
class MoneyBag implements IMoney {
  public IMoney MoneyBag.add(IMoney m) {
    return m.addMoneyBag(this); 
  }   
  public IMoney addMoney(Money m) {   
    return new MoneyBag(m, this); 
  } 
  public IMoney addMoneyBag(MoneyBag s) {  
    return new MoneyBag(s, this); 
  } }
\end{lstlisting}
\end{frame}

\begin{frame}[fragile]
\frametitle{Test de la simplification dans MoneyBag}
%\vspace{1cm}
    \begin{lstlisting}[frame=tb]
@Test
public void testSimplify() {   
  // {[12 CHF][7 USD]} + [-12 CHF] == [7 USD]    
  Money expected= new Money(7, "USD"); 
  assertEquals(expected, fMS1.add(new Money(-12, "CHF"))); 
}

\end{lstlisting}
\end{frame}


\begin{frame}[fragile]
\frametitle{Simplification dans MoneyBag}
%%\vspace{1cm}
  \begin{lstlisting}[frame=tb]
class MoneyBag implements IMoney {
  public IMoney MoneyBag.add(IMoney m) {
    return m.addMoneyBag(this); }   
  public IMoney addMoney(Money m) {   
    return new MoneyBag(m, this).simplify(); } 
  public IMoney addMoneyBag(MoneyBag s) {  
    return new MoneyBag(s, this).simplify(); } 
  private IMoney simplify() { 
    if (fMonies.size() == 1)     
      return fMonies.firstElement(); 
    return this; }}
\end{lstlisting}
\end{frame}



% -------- -------- -------- -------- -------- -------- -------- 
% -------- -------- -------- -------- -------- -------- --------


\section{Conclusion}
\frame{\tableofcontents[currentsection,hideothersubsections]}


\begin{frame} {Résumé}
    %\vspace{1cm}
    \begin{enumerate}
        \item  Outil de création de tests, 100\% Java (mais pas seulement).
    
        \item  Cadre d'applications.
    
        \item  Gratuit!
    
        \item  http://www.junit.org
    \end{enumerate}

\end{frame}

\begin{frame} {Conclusion}
%\vspace{1cm}
    \begin{itemize}
        \item  Un peu de test, un peu de code, un peu de test, un peu 
        de code\ldots
    
        \item  Chaque fois que vous êtes tentés d'utiliser 
        \code{print()}, écrivez un test.
    
        \item  Le test est comme le code: il marche mieux s'il est 
        factorisé.
            \end{itemize}
\end{frame}

\begin{frame} {Conclusion}
%\vspace{1cm}
    \begin{itemize}    
        \item  Maintenir les vieux tests en fonctionnement est tout 
        aussi important que de créer des nouveaux tests.
    
        \item  Un peu d'investissement en test vous rendra plus 
        productifs, plus rapides et moins stressés.
    
        \item  Une fois que les tests sont en place, la 
        restructuration d'un programme devient plus simple.
    \end{itemize}
\end{frame}    


\begin{frame} {Références}
%\vspace{1cm}
\begin{itemize}
    \item  Erich Gamma and Kent Beck. \emph{JUnitTest Infected: 
Programmers Love 
    Writing Tests}. Java Report: Volume 3, Number 7. July 1998.

    \item  Erich Gamma and Kent Beck. \emph{JUnit A Cook's Tour}.
    
    \item http://junit.sourceforge.net
    
\end{itemize}

\end{frame}

\end{document}

