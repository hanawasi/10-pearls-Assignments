/// <reference types="cypress" />



import { loginpage } from "../../pageobj/pageaction/loginaction.cy.js"

const login_page = new loginpage()

describe('pom login', function () {

    it('Login with valid credentials', function () {

        cy.visit('https://www.saucedemo.com/')

        login_page.username('standard_user')
        login_page.password('secret_sauce')
        login_page.loginbutton()

    })

})