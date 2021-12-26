Feature: Calcul du determinant d'une matrice

Scenario: determinant d'une matrice 3x3
Given un tableau de 3 lignes et 3 colonnes
And les valeurs sont :
    | 1  4  3 |
    | 2  5  6 |
    | 7  8  9 |
When on calcule le determinant
Then le determinant est : 36

Scenario: determinant nul d'une matrice 3x3
Given un tableau de 3 lignes et 3 colonnes
And les valeurs sont :
    | 1  2  3 |
    | 4  5  6 |
    | 7  8  9 |
When on calcule le determinant
Then le determinant est : 0

