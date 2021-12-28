package com.esi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;


import com.esi.determinant;

public class stedefs {

    int[][] matrix;
    double result;

    @Given("^une matrice (\\d+)x(\\d+) :$")
    public void a_matrix_x(int row, int col) {
        matrix = new int[row][col];
    }

    @And("^les valeurs sont :$")
    public void a_matrix_with_values(List<List<Integer>> dataTable) throws Throwable {
        for (int i = 0; i < dataTable.size(); i++) {
            for (int j = 0; j < dataTable.get(i).size(); j++) {
                matrix[i][j] = dataTable.get(i).get(j);
            }
        }
    }

    @When("^calculer le determinant$")
    public void the_determinant_is_calculated() throws Throwable {
        result = determinant.Determinant(matrix);
    }

    @Then("^le determinant est :(\\d+)$")
    public void the_result_is(int expected) throws Throwable {
        assertEquals(expected, result, 0.001);
    }
    
}
