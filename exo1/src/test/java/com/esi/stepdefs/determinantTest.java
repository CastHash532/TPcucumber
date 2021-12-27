package com.esi.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import com.esi.determinant;

public class determinantTest {

    int[][] matrix;
    double result;

    @Given("une matrice {int}x{int}")
    public void a_matrix_x(int row, int col) {
        matrix = new int[row][col];
    }

    @And("^les valeurs sont:$")
    public void a_matrix_with_values(io.cucumber.datatable.DataTable dataTable) throws Throwable {
        int[][] matrix = new int[dataTable.asMaps().size()][dataTable.asMaps().get(0).size()];
        for (int i = 0; i < dataTable.asMaps().size(); i++) {
            for (int j = 0; j < dataTable.asMaps().get(0).size(); j++) {
                matrix[i][j] = Integer.parseInt(dataTable.asMaps().get(i).get(j));
            }
        }
    }

    @When("^calculer le determinant$")
    public void the_determinant_is_calculated() throws Throwable {
        result = determinant.Determinant(matrix);
    }

    @Then("^le determinant est : {int}$")
    public void the_result_is(int expected) throws Throwable {
        assertEquals(expected, result, 0.001);
    }
    
}
