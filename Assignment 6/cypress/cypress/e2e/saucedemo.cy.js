


/// <reference types="cypress" />

describe('SauceDemo Tests', () => {

    // 1. Login Failure Scenario
    it('Login with invalid data', () => {

        cy.visit('https://www.saucedemo.com/')

        cy.get('[data-test="username"]').type('standard_user1')
        cy.get('[data-test="password"]').type('secret_sauce1')
        cy.get('[data-test="login-button"]').click()

        cy.get('[data-test="error"]')
            .should('be.visible')
            .and('contain', 'Epic sadface: Username and password do not match any user in this service')
    })


    // 2. Login Success Flow and Homepage Validation
        
    it('Login Success Flow and Homepage Validation', () => {

        cy.visit('https://www.saucedemo.com/')

        cy.get('[data-test="username"]').type('standard_user')
        cy.get('[data-test="password"]').type('secret_sauce')
        cy.get('[data-test="login-button"]').click()

        cy.url().should('include', '/inventory.html')

        cy.get('[data-test="secondary-header"]')
            .should('be.visible')

        cy.get(':nth-child(1) > [data-test="inventory-item-description"]')
            .should('be.visible')
    })


    // 3. Product Navigation and Validation
    it('Product Navigation and Validation', () => {

        cy.visit('https://www.saucedemo.com/')

        // Login first
        cy.get('[data-test="username"]').type('standard_user')
        cy.get('[data-test="password"]').type('secret_sauce')
        cy.get('[data-test="login-button"]').click()

       
        // Verify product name
        cy.get('[data-test="item-4-title-link"] > [data-test="inventory-item-name"]')
            .should('be.visible')
            .and('contain', 'Sauce Labs Backpack')

        // Verify product description
        cy.get(':nth-child(1) > [data-test="inventory-item-description"] > .inventory_item_label > [data-test="inventory-item-desc"]')
            .should('be.visible')
            .and('contain', 'carry.allTheThings()')

        // Verify product price
        cy.get('[data-test="inventory-item-price"]')
            .first()
            .should('be.visible')
            .and('contain', '$29.99')

        // Click product
        cy.get('[data-test="item-4-title-link"]')
            .click()

      
        // Verify product detail page
        cy.url().should('include', '/inventory-item.html')
       cy.get('[data-test="inventory-item-name"]').should('be.visible').and('contain','Sauce Labs Backpack')
       cy.get('[data-test="inventory-item-desc"]').should('be.visible').and('contain','carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')
       cy.get('[data-test="inventory-item-price"]').should('be.visible').and('contain','$29.99')
    })

})

