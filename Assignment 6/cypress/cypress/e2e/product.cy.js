import { loginpage } from "../../pageobj/pageaction/loginaction.cy.js"
import { ProductPage } from "../../pageobj/pageaction/productaction.cy.js"

const login_page = new loginpage()
const product_Page = new ProductPage()

describe("Product Detail", () => {

    it("Verify product detail page", () => {

        cy.visit("https://www.saucedemo.com/")

        login_page.username("standard_user")
        login_page.password("secret_sauce")
        login_page.loginbutton()

        product_Page.verifyproducturl()
        product_Page.verifyproductname()
        product_Page.verifyproductdescription()
        product_Page.verifyproductprice()
    })
})