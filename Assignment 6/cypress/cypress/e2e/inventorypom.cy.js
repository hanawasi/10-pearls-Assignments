



import { loginpage } from "../../pageobj/pageaction/loginaction.cy.js"

import { inventory } from "../../pageobj/pageaction/inventoryaction.cy.js"




const login_page = new loginpage()
const inventory_page = new inventory()

describe('Inventory Tests', function () {

    it('Add product to cart', function () {

        // Login
       
        cy.visit('https://www.saucedemo.com/')

        login_page.username('standard_user')
        login_page.password('secret_sauce')
        login_page.loginbutton()

        // Inventory actions
        inventory_page.verifydescription()
        inventory_page.verifyprice()
        inventory_page.verifyproductclick()
        inventory_page.verifyproductvisible()

    })

})