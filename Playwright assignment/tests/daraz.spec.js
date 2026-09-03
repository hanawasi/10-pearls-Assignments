// @its-check

const {test, expect}= require("@playwright/test")

test('navigatetohomepage',async({page})=>{
    await page.goto('https://www.daraz.pk/#?')
    await expect(page.locator("img[alt='Online Shopping Daraz.PK Logo']").first()).toBeVisible()
    await page.locator('#q').fill('electronics')
    
    await page.locator('.search-box__button--1oH7').click()
    await expect(page).toHaveURL(/q=electronics/)
   

await page.getByText("Iqbal Electronics", { exact: true }).click();
      await expect(
        
        page.locator(".ant-tag.css-1bkhbmc.app")
    ).toContainText("Brand: Iqbal Electronics")
    await page.locator("input[placeholder='Min']").scrollIntoViewIfNeeded() 
    await page.waitForTimeout(5000)
    await page.locator("input[placeholder='Min']").fill('500')
     
    await page.locator("input[placeholder='Max']").fill('5000')
   
    await page.waitForTimeout(5000)
    await page.locator(".ant-btn.css-1bkhbmc.app.ant-btn-primary.ant-btn-icon-only.yUcnk").click()
 await expect(
    page.locator(".ant-tag").filter({ hasText: "Price:" })
).toContainText("Price: 500-5000");
     await page.waitForTimeout(5000)
  
// Validate Product Count
async function validateProductCount(page) {
    const productCards = page.locator('[data-qa-locator="product-item"]')
    const productCount = await productCards.count();

    console.log("Product count:", productCount);

    expect(productCount).toBeGreaterThan(0);
}

await validateProductCount(page);
await page.locator("a[title='Soldering Wire 0.8mm 50g – Premium Rosin Core Solder Wire for Electronics, PCB & Electrical Repair']").click()
await expect(page).toHaveURL(/daraz\.pk\/products\//);
const freeShipping = page.getByText("Free Shipping", { exact: true }).first();

if (await freeShipping.count() > 0) {
    await expect(freeShipping).toBeVisible();
    console.log("Free Shipping label is visible");
} else {
    console.log("Free Shipping is not available for this product");
}

       
      
       
})

