

/// <reference types="cypress" />

describe('SauceDemo Tests custom commands', function(){

    // 1. Login Failure Scenario
    it('Login with invalid data custom command', function(){

        
        cy.visit('https://www.saucedemo.com/')

     
        cy.Login('standard_user','secret_sauce')
    })
    it('navigation custom command', function(){

        
        cy.visit('https://www.saucedemo.com/')

     
        cy.Login('standard_user','secret_sauce')
        cy.navigation()
    })

    

    



})