import product from "../pageelements/product.json"

export class ProductPage {

    verifyproducturl() {
        cy.url().should('include', '/inventory-item.html')
    }

    verifyproductname() {
        cy.get(product.productname_loc)
            .should('be.visible')
            .and('contain', 'Sauce Labs Backpack')
    }

    verifyproductdescription() {
        cy.get(product.dec_loc)
            .should('be.visible')
            .and(
                'contain',
                'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.'
            )
    }

    verifyproductprice() {
        cy.get(product.price_loc)
            .should('be.visible')
            .and('contain', '$29.99')
    }
}