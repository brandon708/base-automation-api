@Freetogame
Feature: Prueba de Status de Freetogame

  @S1
  Scenario: Se debe validar el status 200
    Given que la aplicación esta activa
    When  consulto la plataforma: "pc"
    And la categoria sea: "shooter"
    Then valida que la respuesta sea 200

  @S2
  Scenario: Caso error - Validar status 404
    Given que la aplicación esta activa
    When  consulto la plataforma: "pc"
    And la categoria: "ñ"
    Then valida que la respuesta sea igual 404


