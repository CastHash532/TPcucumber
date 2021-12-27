Feature: Calcul du determinant d'une matrice

Scenario: determinant d'une matrice 3 x 3
Given une matrice 3x3 :
And les valeurs sont :
    | 1  4  3 |
    | 2  5  6 |
    | 7  8  9 |
When calculer le determinant
Then le determinant est : 36


