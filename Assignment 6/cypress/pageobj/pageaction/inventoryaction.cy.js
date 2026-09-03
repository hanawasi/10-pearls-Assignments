const inventorylocators = require('../pageelements/inventory.json')
export class inventory{
       
        
    verifyproductvisible(){
          cy.get(inventorylocators.inventoryloc.productname_loc)
            .should('be.visible')
            .and('contain', 'Sauce Labs Backpack')

    }
    
      
    verifydescription(){
          cy.get(inventorylocators.inventoryloc.dec_loc)
            .should('be.visible')
            .and('contain', 'carry.allTheThings()')
    }

    
      verifyprice(){
          cy.get(inventorylocators.inventoryloc.price_loc)
            .first()
            .should('be.visible')
            .and('contain', '$29.99')

      }

      verifyproductclick(){
        cy.get(inventorylocators.inventoryloc.clickproduct_loc)
            .click()
}

      }
      
        