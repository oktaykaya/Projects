const { test, expect } = require('@playwright/test');

const testdata= JSON.parse(JSON.stringify(require("../test.json")))

test("login to app",async ({page}) => {
test.slow();
  //Login
  await page.goto('https://test.eleport.io/login?lang=en');
  await page.getByRole('button', { name: 'I accept all cookies' }).click();
  await page.getByPlaceholder('Enter your email').click();
  await page.getByPlaceholder('Enter your email').fill(testdata.username);
  await page.getByPlaceholder('Enter your email').press('Tab');
  await page.getByLabel('Password', { exact: true }).fill(testdata.sifre).then(() => page.waitForTimeout(2000));
  await page.getByLabel('Password', { exact: true }).press('Enter');
  
  //Bina seçimi ve asansör oluşturma
  await page.getByText('TEST', { exact: true }).click();
  await page.getByText('1').click();
  await page.locator('.w-full > .chakra-icon').click();
  await page.getByLabel('Elevator Name*').click();
  await page.getByLabel('Elevator Name*').fill('playwright');
  await page.getByLabel('Elevator Name*').press('Tab');
  await page.getByLabel('Elevator Supervisor*').fill('playwright');
  await page.getByLabel('Elevator Serial No*').click();
  await page.getByLabel('Elevator Serial No*').fill('0').then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Create Elevator' }).click();
  await page.getByText('playwrightEditCopy').click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Draw' }).click();

  //Asansör sınıfı
  await page.locator('#asansor_sinifi').selectOption('2');
  await page.getByPlaceholder('-30000').click();
  await page.getByPlaceholder('-30000').fill('800');
  await page.getByRole('button', { name: 'Calculate' }).click();
  await page.locator('#seyir_mesafesi').click();
  await page.locator('#seyir_mesafesi').fill('12');
  await page.locator('input[name="t_nt"]').click();
  await page.locator('input[name="t_nt"]').fill('1');
  await page.locator('#kabin_anma_hizi').click();
  await page.locator('#kabin_anma_hizi').fill('1').then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Next' }).click();

  //kuyu seçimi
  await page.getByRole('img', { name: 'kuyu - tipi - 1' }).click();
  await page.getByRole('img', { name: 'md_1' }).click();
  await page.locator('#kat_sayisi').click();
  await page.locator('#kat_sayisi').fill('5');
  await page.locator('#kat_sayisi').press('Tab');
  await page.locator('#kuyu_alti').fill('1500');
  await page.locator('#kuyu_alti').press('Tab');
  await page.locator('#kuyu_ustu').fill('4000').then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Next' }).click();

  //Engel adedi
  await page.getByRole('combobox').selectOption('0').then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Next' }).click();
  
  //askı tipi seçimi
  await page.locator('#aski_katsayisi').selectOption('2');
  await page.locator('#aski_katsayisi').selectOption('1');
  await page.getByRole('img', { name: 'Y-1/1-' }).click();
  await page.locator('form img').nth(1).click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Next' }).click();

  //çizim şablonu
  await page.getByText('Drawing Template136137138Coming SoonBackCalculateDraw').click();
  await page.getByText('136137138Coming Soon').click();
  await page.locator('label').filter({ hasText: '136' }).locator('img').click();
  await page.locator('body').press('Tab');
  await page.getByRole('button', { name: 'Back' }).press('Tab').then(() => page.waitForTimeout(1000));
  await page.getByRole('button', { name: 'Calculate' }).press('Tab');
  await page.getByRole('button', { name: 'Draw' }).press('Enter');
  //await page.getByText('Drawing Template136137138Coming SoonBackCalculateDraw').click();
  //await page.locator('label').filter({ hasText: '136' }).locator('img').click().then(() => page.waitForTimeout(2000));
  //await page.getByText('136').click();
  //await page.getByRole('button', { name: 'Draw' }).click();

  //Karşı Ağırlık 
  await page.getByRole('button', { name: 'Counterweight' }).click();
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Default').click();
  await page.getByText('1x1-E').click();
  await page.getByText('890x160x2500').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByPlaceholder('19').click();
  await page.locator('#ka_secilen_ray_tip').selectOption('T75/B');
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('T3-Ro').click();
  await page.getByText('140x220x130').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.locator('#ka_duvar_ara_uz').click();
  await page.getByRole('button', { name: 'Select' }).click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('h2200').click();
  await page.getByText('2200x300x20').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.locator('#sep_or_u_kon_kalinlik').click();
  await page.locator('#sep_or_u_konsolun_ka_uz').click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Door' }).click();

  //Kapı
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Wittur').click();
  await page.getByText('Hydra - Standard Hangers').click();
  await page.getByLabel('Please Select a Component').locator('img').click();
  await page.getByText('700').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByRole('button', { name: 'Select' }).click();
  await page.getByText('Wittur', { exact: true }).click();
  await page.getByText('Hydra Plus - Standard').click();
  await page.getByLabel('Please Select a Component').locator('img').click();
  await page.getByText('700', { exact: true }).click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.locator('#antre_derinlik1').click();
  await page.locator('input[name="kapi1_h"]').click();
  await page.locator('input[name="kapi1_h"]').fill('2000');
  await page.locator('#kapilar_ar_mes1').click();
  await page.getByPlaceholder('0', { exact: true }).click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Cabin' }).click();

  //Kabin
  const element1 = await page.$('.css-2hgt1h');
  await element1?.click();
  await page.locator('.chakra-stack > div > div > div > .chakra-image').first().click();
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('T1-P-S').click();
  await page.getByText('30x15xR80xh150').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByLabel('Please Select a Component').getByText('/1').click();
  await page.getByText('L', { exact: true }).click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  const element2 = await page.$('.css-2hgt1h');
  await element2?.click();
  await page.getByLabel('(L) type frame connection').getByRole('img').first().click();
  await page.locator('#kbn_secilen_ray_tip').selectOption('T90/A');
  await page.getByRole('button', { name: 'Select' }).click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('T1-St').click();
  await page.getByText('140x100x90').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.locator('#kbn_gen').click();
  await page.locator('#kbn_gen').fill('1400');
  await page.locator('#kbn_gen').press('Tab');
  await page.locator('#kbn_raylari_ara_uz').fill('1000');
  await page.locator('#kbn_raylari_ara_uz').press('Tab');
  await page.locator('#kbn_derinligi').fill('1200').then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Motor' }).click();

  //Motor
  await page.getByRole('button', { name: 'Select' }).click();
  await page.getByText('Montanari').click();
  await page.getByText('Mgv25s').click();
  await page.getByText('Ø320x75').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByRole('button', { name: 'Safety Gear' }).click();

  //Kabin Güvenliği burdayız
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('R-2D').click();
  await page.getByText('k1=').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByRole('combobox').selectOption('1');
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('1d').click();
  await page.getByText('Ø240').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByRole('button', { name: 'Select' }).first().click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('Ø240', { exact: true }).click();
  await page.getByText('Ø240x340x80').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByRole('button', { name: 'Select' }).click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('MRL-W').click();
  await page.getByText('+Ø+20x100xh250').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  const element3 = await page.$('.css-2hgt1h');
  await element3?.click();
  const img1 = await page.$('img[alt="1"]');
  // @ts-ignore
  await img1.click().then(() => page.waitForTimeout(2000));
  //await page.locator('[id="popover-body-\\:rc5\\:"] > div > div > div > div').first().click();
  await page.getByRole('button', { name: 'Other' }).click();
  //await page.locator('[id="popover-body-\\:rc5\\:"] > div > div > div > div').first().click();
  //await page.getByLabel('Safety Gear', { exact: true }).locator('img').click();
  //await page.locator('[id="popover-body-\\:rc5\\:"]').getByRole('img').first().click();

  //Diğer

  //await page.getByRole('img', { name: '1', exact: true }).click();
  //await page.getByLabel('Other').locator('img').click();
  //await page.locator('[id="popover-body-\\:rbk\\:"] div').nth(3).click(

  const element4 = await page.$('.css-2hgt1h');
  await element4?.click();
  const img2 = await page.$('img[alt="1"]');
  // @ts-ignore
  await img2.click().then(() => page.waitForTimeout(2000));
  
  await page.getByRole('button', { name: 'Select' }).click();
  await page.getByText('Default', { exact: true }).click();
  await page.getByText('250x250x150').click();
  await page.getByText('250x250x150').nth(1).click();
  await page.getByRole('button', { name: 'Confirm' }).click();
  await page.getByRole('button', { name: 'Default / 250x250x150 /' }).press('Shift+Tab');
  await page.getByRole('button', { name: 'Compensation Chain / Flexible' }).click();

  //Denge Zinciri
  await page.locator('#denge_zinc_durumu').selectOption('2');
  const element5 = await page.$('.css-2hgt1h');
  await element5?.click();
  const img3 = await page.$('img[alt="2"]');
  // @ts-ignore
  await img3.click();
  await page.locator('#flexible_a').click();
  await page.locator('#flexible_a').fill('700');
  await page.getByPlaceholder('500').click();
//  await page.locator('[id="popover-trigger-\\:rht\\:"] img').click();
//  await page.locator('[id="popover-body-\\:rht\\:"]').getByRole('img').click();
  await page.getByPlaceholder('500').press('Tab');
  await page.getByRole('button', { name: 'Draw' }).click().then(() => page.waitForTimeout(5000));




  //Yatay Kesit Motor
  await page.locator('a').filter({ hasText: 'Machine Room Horizontal' }).click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'General' }).click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Motor' }).click().then(() => page.waitForTimeout(2000));

  const element6 = await page.$('.css-2hgt1h').then(() => page.waitForTimeout(2000));
  await element6?.click();
  const img4 = await page.$('img[alt="1"]').then(() => page.waitForTimeout(2000));
  // @ts-ignore
  //await img4.click().then(() => page.waitForTimeout(2000));
  

  const element7 = await page.$('.css-2hgt1h').then(() => page.waitForTimeout(2000));
  await element7?.click();
  const img5 = await page.$('img[alt="111]').then(() => page.waitForTimeout(2000));
  // @ts-ignore
  await img5.click().then(() => page.waitForTimeout(2000));

  await page.getByRole('button', { name: 'Select' }).click().then(() => page.waitForTimeout(2000));
  await page.getByText('Default').click().then(() => page.waitForTimeout(2000));
  await page.getByText('MRL_1/').click().then(() => page.waitForTimeout(2000));
  await page.getByText('h200').click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Confirm' }).click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Electric Panels' }).click().then(() => page.waitForTimeout(2000));

  //Electric Panels
  const element8 = await page.$('.css-2hgt1h').then(() => page.waitForTimeout(2000));
  await element8?.click();
  const img6 = await page.$('img[alt="101]').then(() => page.waitForTimeout(2000));
  // @ts-ignore
  await img6.click().then(() => page.waitForTimeout(2000));

  await page.getByRole('button', { name: 'Select' }).click().then(() => page.waitForTimeout(2000));
  await page.getByText('Default', { exact: true }).click().then(() => page.waitForTimeout(2000));
  await page.getByText('MRL', { exact: true }).click().then(() => page.waitForTimeout(2000));
  await page.getByText('350x300xh2000').click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Confirm' }).click().then(() => page.waitForTimeout(2000));
  await page.getByRole('button', { name: 'Draw' }).click().then(() => page.waitForTimeout(2000));


  //Dikeykesit

  await page.pause()
});