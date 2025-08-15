package steps;

import featurepages.ProductPage;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProductSteps {
    ProductPage productPage;

    public ProductSteps() {
        this.productPage = new ProductPage(Hooks.driver);
    }

    @Given("el usuario se encuentre en la página principal del comercio")
    public void view_main_page() {
        productPage.navigateToHomePage();
    }

    @When("haga clic sobre el producto")
    public void click_product() {
        productPage.clickFirstViewProduct();
    }

    @And("lo agregue al carrito")
    public void add_product() {
        productPage.verifyFirstViewProduct();
        productPage.clickAddToCart();
    }

    @Then("Deberá ver la confirmación del producto añadido")
    public void verify_product_in_car() {
        productPage.verifyAddedToCart();
    }
}

