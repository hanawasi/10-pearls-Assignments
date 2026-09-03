export class loginpage{

     loginlocators = require('../pageelements/login element.json')
    username(username){
          
        cy.get(this.loginlocators.loginloc.username_loc).type(username)
        return

    }

    password(password){
        cy.get(this.loginlocators.loginloc.pass_loc).type(password)
        return
    }

    loginbutton(){
        cy.get(this.loginlocators.loginloc.button_loc).click()
        return

    }

}
