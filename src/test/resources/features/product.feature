Feature: Comprar producto
  Scenario: El usuario ingresa a la pagina para comprar un producto
    Given el usuario se encuentre en la página principal del comercio
    When haga clic sobre el producto
    And lo agregue al carrito
    Then Deberá ver la confirmación del producto añadido
